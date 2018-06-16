package data;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase; 

public class MongoDBDAO {
	private static MongoDBDAO instance = new MongoDBDAO();
	public static MongoDBDAO getInstance() {
		return instance;
	}
	
	private MongoClient client;
    private MongoDatabase db;
	
	private MongoDBDAO() {
		client = new MongoClient();
		db = client.getDatabase("doacao");
	}
	
	public void insertInstituicoes(String instituicaoJSON) {
        MongoCollection<Document> coll = db.getCollection("instituicoes");
		Document newInst = Document.parse(instituicaoJSON);
		coll.insertOne(newInst);
		System.out.println("Inserindo no bd");
	}
	
	public String getInstituicoes() {
        MongoCollection<Document> coll = db.getCollection("instituicoes");
        List<Document> results = coll.find().into(new ArrayList<Document>());
        String resultStr = "[";
        for (int i = 0; i < results.size()-1; i++) {
        	resultStr += JSONtoString(results.get(i)) + ",";
        }
        resultStr += "]";
        
		return resultStr;
	}
	
	private String JSONtoString(Document document) {
		JsonWriter jsonWriter = new JsonWriter(new StringWriter(),
                new JsonWriterSettings(JsonMode.SHELL, true));
		new DocumentCodec().encode(jsonWriter, document,
		    EncoderContext.builder()
		                  .isEncodingCollectibleDocument(true)
		                  .build());
		return jsonWriter.getWriter().toString();
	}
}

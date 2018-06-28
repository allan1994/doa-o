package data;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.Document;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase; 

import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.*;

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
	
	public String insertInstituicoes(String instituicaoJSON) {
        MongoCollection<Document> coll = db.getCollection("instituicoes");
		Document newInst = Document.parse(instituicaoJSON);
		coll.insertOne(newInst);
		ObjectId id = (ObjectId) newInst.get("_id");
		
		System.out.println("Inserindo no bd");
		return id.toString();
	}
	
	public String getInstituicoes() {
        MongoCollection<Document> coll = db.getCollection("instituicoes");
        List<Document> results = coll.find().into(new ArrayList<Document>());
        String resultStr = "[";
        for (int i = 0; i < results.size()-1; i++) {
        	resultStr += JSONtoString(results.get(i)) + ",";
        }
        
        if (!results.isEmpty()) resultStr += JSONtoString(results.get(results.size()-1));
        resultStr += "]";
        
		return resultStr;
	}
	
	public String getInstituicaoById(String id) {
		MongoCollection<Document> coll = db.getCollection("instituicoes");
        List<Document> results = coll.find(eq("_id", new ObjectId(id))).into(new ArrayList<Document>());
        String resultStr = JSONtoString(results.get(0));
        
		return resultStr;
	}
	
	public String getInstituicoesByName(String name) {
		MongoCollection<Document> coll = db.getCollection("instituicoes");
		Pattern regex = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
		
        List<Document> results = coll.find(eq("nome", regex)).into(new ArrayList<Document>());

        String resultStr = "[";
        for (int i = 0; i < results.size()-1; i++) {
        	resultStr += JSONtoString(results.get(i)) + ",";
        }        
        
        if (!results.isEmpty()) resultStr += JSONtoString(results.get(results.size()-1));
        resultStr += "]";
        
		return resultStr;
	}
	
	public String getInstituicoesByLocale(String name) {
		MongoCollection<Document> coll = db.getCollection("instituicoes");
		Pattern regex = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
		
        List<Document> results = coll.find(eq("bairro", regex)).into(new ArrayList<Document>());

        String resultStr = "[";
        for (int i = 0; i < results.size()-1; i++) {
        	resultStr += JSONtoString(results.get(i)) + ",";
        }        
        
        if (!results.isEmpty()) resultStr += JSONtoString(results.get(results.size()-1));
        resultStr += "]";
        
		return resultStr;
	}
	
	public String getInstituicoesByRequest(String request) {
		MongoCollection<Document> coll = db.getCollection("instituicoes");
		Pattern regex = Pattern.compile(request, Pattern.CASE_INSENSITIVE);
		
        List<Document> results = coll.find(
        	elemMatch("pedidos", eq("nome", regex))
        ).into(new ArrayList<Document>());

        String resultStr = "[";
        for (int i = 0; i < results.size()-1; i++) {
        	resultStr += JSONtoString(results.get(i)) + ",";
        }
        if (!results.isEmpty()) resultStr += JSONtoString(results.get(results.size()-1));
        resultStr += "]";
        
		return resultStr;
	}
	
//	public void adicionarPedido(String id, String json) {
//		MongoCollection<Document> coll = db.getCollection("instituicoes");
//		Document newPedido = Document.parse(json);
//		coll.updateOne(eq("_id", new ObjectId(id)), null);
//		
//		
//		System.out.println("Inserindo no bd");
//		
//	}
	
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

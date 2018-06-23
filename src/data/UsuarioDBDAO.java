package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONObject;

public class UsuarioDBDAO {
	private static UsuarioDBDAO instance = new UsuarioDBDAO();
	public static UsuarioDBDAO getInstance() {
		return instance;
	}
	
	private Connection connection;
	
	private UsuarioDBDAO() {
		try {
			System.out.println("Try connect");
	        Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/doacao_usuarios", "root", "senhasql");
			System.out.println("Conectado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("NÃ£o achou!");
			e.printStackTrace();
		}
	}
	
	public void insert(String userJSON) {
		JSONObject userObj;
		try {
			userObj = new JSONObject(userJSON);
			System.out.println("Inserindo User...");
			String sql = "INSERT INTO proprietario (tipoConta, idOng, usuario, senha, email) VALUES (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, userObj.getString("tipoConta"));
			stmt.setString(2, userObj.getString("idOng"));
			stmt.setString(3, userObj.getString("usuario"));
			stmt.setString(4, userObj.getString("senha"));
			stmt.setString(5, userObj.getString("email"));
			System.out.println(stmt.toString());
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String retrieve(String userJSON) {
		JSONObject userObj;
		try {
			userObj = new JSONObject(userJSON);
			String sql = "SELECT * FROM usuarios WHERE usuario=? AND senha=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, userObj.getString("usuario"));
			stmt.setString(2, userObj.getString("senha"));
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) 
				return "{\"tipoConta\": \"" + rs.getString(2) + "\", \"id\": \"" + rs.getString(3) + "\"}";

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "Não encontrado";
	}


//	public ArrayList<Administrador> retrieve() throws DAOAccessException {
//		ArrayList<Administrador> ret = new ArrayList<Administrador>();
//		
//		System.out.println("Buscando...");
//		String sql = "SELECT * FROM proprietario ORDER BY idProprietario";
//		try {
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery();
//			
//			while (rs.next()) {
//				ret.add(new Proprietario(rs.getInt(1), rs.getString(2),  rs.getString(3), rs.getString(4), rs.getString(5)));
//			}
//			
//			stmt.close();		
//			
//		} catch (SQLException e) {
//			System.out.println("Falha na busca!");
//			throw new DAOAccessException();
//		}
//		
//		return ret;
//	}

}

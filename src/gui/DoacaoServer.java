package gui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.MongoDBDAO;
import data.UsuarioDBDAO;

/**
 * Servlet implementation class DoacaoServer
 */
@WebServlet("/DoacaoServer")
public class DoacaoServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MongoDBDAO bd;
	private UsuarioDBDAO bdUser;
	
    /**
     * Default constructor. 
     */
    public DoacaoServer() {
    	bd = MongoDBDAO.getInstance();
		bdUser = UsuarioDBDAO.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String res;
		if (action.equals("cadastrar")) {
			res = bd.insertInstituicoes(request.getParameter("json"));
		} else if (action.equals("cadastrarUsuario")) {
			bdUser.insert(request.getParameter("json"));
			res = "ok";
		} else if (action.equals("listar")) {
			res = bd.getInstituicoes();
		} else if (action.equals("getInstituicao")) {
			res = bd.getInstituicaoById(request.getParameter("id"));
		} else if (action.equals("buscaNome")) {
			res = bd.getInstituicoesByName(request.getParameter("nome"));
		} else if (action.equals("buscaPedidos")) {
			res = bd.getInstituicoesByRequest(request.getParameter("pedido"));
		} else if (action.equals("buscaLocal")) {
			res = bd.getInstituicoesByLocale(request.getParameter("local"));
		} else if (action.equals("adicionarPedido")) {
			// bd.adicionarPedido(request.getParameter("id"), request.getParameter("json"));
			res = "ok";
		} else if (action.equals("login")) {
			res = bdUser.retrieve(request.getParameter("json"));
		} else {
			System.out.println("A��o inv�lida, " + action);
			res = "A��o inv�lida";
		}
		
		System.out.println(request.getContextPath());
		
		response.getWriter().append(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

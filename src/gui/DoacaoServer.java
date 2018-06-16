package gui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.MongoDBDAO;

/**
 * Servlet implementation class DoacaoServer
 */
@WebServlet("/DoacaoServer")
public class DoacaoServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MongoDBDAO bd;
	
    /**
     * Default constructor. 
     */
    public DoacaoServer() {
    	bd = MongoDBDAO.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String res = "";
		if (action.equals("cadastrar")) {
			bd.insertInstituicoes(request.getParameter("json"));
			res = "ok";
		} else if (action.equals("listar")) {
			res = bd.getInstituicoes();
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

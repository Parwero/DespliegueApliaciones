package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import managers.UsuarioManagers;
import objetos.Usuario;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email="";
		String contrasenia="";


		if(request.getParameter("email")!=null) {
			email = request.getParameter("email");
		}
		if(request.getParameter("contrasenia")!=null) {
			contrasenia = request.getParameter("contrasenia");
		}
		
		Usuario usuario = new Usuario(email, contrasenia);
		
		request.getSession().setAttribute("usuario", usuario);
		
		if(UsuarioManagers.comprobarUsuarioExiste(usuario)) {
			RequestDispatcher rd= request.getRequestDispatcher("formulario.jsp");
			rd.forward(request, response);
			
		}
		
		else {
		RequestDispatcher rd= request.getRequestDispatcher("inicio.jsp");
		rd.forward(request, response);
		}
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
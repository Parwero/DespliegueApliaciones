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
 * Servlet implementation class Alta
 */
@WebServlet("/alta")
public class Alta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email="";
		String contrasenia1="";
		String contrasenia2="";
		
		if(request.getParameter("email")!=null) {
			email = request.getParameter("email");
		}
		if(request.getParameter("contrasenia1")!=null) {
			contrasenia1 = request.getParameter("contrasenia1");
		}
		if(request.getParameter("contrasenia2")!=null) {
			contrasenia2 = request.getParameter("contrasenia2");
		}
		
		Usuario usuario = new Usuario(email, contrasenia1);
		
		request.getSession().setAttribute("usuario", usuario);
		
		Usuario usuario1 = new Usuario(email, contrasenia2);
		
		request.getSession().setAttribute("usuario", usuario1);
		
		RequestDispatcher rd= request.getRequestDispatcher("alta.jsp");
		rd.forward(request, response);
		
		UsuarioManagers.crearUsuario(usuario);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

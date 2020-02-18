package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objetos.Usuario;
import peliculas.Busqueda;
import peliculas.Parseadores;
import proyectoJson.PeticionWeb;

/**
 * Servlet implementation class BuscarPelicula
 */
@WebServlet("/buscarpelicula")
public class BuscarPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("nombre")!=null) {
			String email="";
			
			if(request.getParameter("usu.getEmail()")!=null) {
				email = request.getParameter("usu.getEmail()");
			}
			System.out.println("aqui");
		
			
			String nombre= request.getParameter("nombre");
			nombre=nombre.replaceAll(" ","+");
			
			try {
				String json=PeticionWeb.peticionHttpGet("http://www.omdbapi.com/?apikey=dcdf1c79&s="+nombre);
				Busqueda b=Parseadores.parseadorBusqueda(json);
				request.getSession().setAttribute("busqueda", b);
				request.getSession().setAttribute("pelicula", null);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("formulario.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

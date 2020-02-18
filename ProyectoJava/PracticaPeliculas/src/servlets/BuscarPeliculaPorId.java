package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import peliculas.Parseadores;
import peliculas.InfoPelicula;
import proyectoJson.PeticionWeb;

/**
 * Servlet implementation class BuscarPelicula
 */
@WebServlet("/buscarpeliculaporid")
public class BuscarPeliculaPorId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPeliculaPorId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")!=null) {
			String id= request.getParameter("id");

			try {
				String json=PeticionWeb.peticionHttpGet("http://www.omdbapi.com/?apikey=dcdf1c79&i="+id);
				InfoPelicula p=Parseadores.parseadorPelicula(json);
				request.getSession().setAttribute("pelicula", p);
				request.getSession().setAttribute("busqueda", null);
			
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

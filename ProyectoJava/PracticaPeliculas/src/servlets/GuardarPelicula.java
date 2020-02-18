package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import managers.PeliculaManagers;
import objetos.Pelicula;
import objetos.Usuario;
import peliculas.InfoPelicula;
/**
 * Servlet implementation class GuardarPelicula
 */
@WebServlet("/guardarPelicula")
public class GuardarPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email="";
		String titulo="";
		String id_peliculaAPI="";

		if(request.getParameter("email")!=null) {
			email = request.getParameter("email");
		}
		
		if(request.getParameter("titulo")!=null) {
			titulo = request.getParameter("titulo");
		}
		
		if(request.getParameter("id_peliculaAPI")!=null) {
			id_peliculaAPI = request.getParameter("id_peliculaAPI");
		}

			
	
		Pelicula p1= new Pelicula(id_peliculaAPI,email,-1,titulo);
		
		
		boolean existe=PeliculaManagers.comprobarPeliculaExiste(p1);
		if(existe==true) {
			System.out.println("actualiza");
			
			ArrayList<Pelicula>numerosid=PeliculaManagers.consultarId(p1);
			
			int numero=0;
			
			for (int i = 0; i < numerosid.size(); i++) {
				numero=numerosid.get(i).getId_pelicula();
			}
			
			Pelicula p2= new Pelicula(numero,id_peliculaAPI,email,-1,titulo);
			
			PeliculaManagers.actualizarPelicula(p2);
		}else {
			System.out.println("crea");
			PeliculaManagers.crearPelicula(p1);
		}
		
		
		RequestDispatcher rd= request.getRequestDispatcher("formulario.jsp");
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

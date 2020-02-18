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
 * Servlet implementation class CrearPuntuacion
 */
@WebServlet("/crearPuntuacion")
public class CrearPuntuacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearPuntuacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int puntuacion=0;
		String contrasenia="";
		String email="";
		String titulo="";
		String id_peliculaAPI="";
		
		
		
		if(request.getParameter("puntuacion")!=null) {
			puntuacion = Integer.parseInt(request.getParameter("puntuacion"));
		}
		if(request.getParameter("contrasenia")!=null) {
			contrasenia = request.getParameter("contrasenia");
		}
		
		if(request.getParameter("email")!=null) {
			email = request.getParameter("email");
		}
		
		if(request.getParameter("titulo")!=null) {
			titulo = request.getParameter("titulo");
		}
		
		if(request.getParameter("id_peliculaAPI")!=null) {
			id_peliculaAPI = request.getParameter("id_peliculaAPI");
		}


	
		Pelicula p1= new Pelicula(id_peliculaAPI,email,puntuacion,titulo);
		
		
		boolean existe=PeliculaManagers.comprobarPeliculaExiste(p1);
		
		
		if(existe==true) {
			System.out.println("actualiza");
			
			ArrayList<Pelicula>numerosid=PeliculaManagers.consultarId(p1);
			
			int numero=0;
			
			for (int i = 0; i < numerosid.size(); i++) {
				numero=numerosid.get(i).getId_pelicula();
			}
			
			
			Pelicula p2= new Pelicula(numero,id_peliculaAPI,email,puntuacion,titulo);
			
			System.out.println(numero);
		
			PeliculaManagers.actualizarPelicula(p2);
			
		}else {
			PeliculaManagers.crearPelicula(p1);
			System.out.println("crea");
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

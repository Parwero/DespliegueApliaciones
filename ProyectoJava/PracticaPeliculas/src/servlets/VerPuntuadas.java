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


/**
 * Servlet implementation class VerPuntuadas
 */
@WebServlet("/verPuntuadas")
public class VerPuntuadas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerPuntuadas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email="";
		
		String titulo="";
		int puntuacion=0;
		
		if(request.getParameter("email")!=null) {
			email = request.getParameter("email");
		}
		
		
		ArrayList<Pelicula>peliculasPuntuadas= new ArrayList<Pelicula>();
		
		ArrayList<Pelicula>peliculas=PeliculaManagers.consultarPeliculas();
		
		for (int i = 0; i < peliculas.size(); i++) {
			
			
			if(email.equals(peliculas.get(i).getEmail())) {
							
				Pelicula p1=peliculas.get(i);
			
				
				if(p1.getPuntuacion()>=0) {
					peliculasPuntuadas.add(p1);				
				
		
				}
			}
		}
		
		request.getSession().setAttribute("peliculasPuntuadas", peliculasPuntuadas);
		
		RequestDispatcher rd= request.getRequestDispatcher("resultadoPuntuadas.jsp");
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

package objetos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity 
@Table ( name = "pelicula" , schema = "bbddpeliculas" )
public class Pelicula {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id_pelicula;
	private String id_peliculaAPI;
	
	private String email;
	private int puntuacion;
	private String titulo;
	
	public Pelicula() {
		
	}

	public Pelicula(String id_peliculaAPI, String email, int puntuacion, String titulo) {
		super();
		this.id_peliculaAPI = id_peliculaAPI;
		this.email = email;
		this.puntuacion = puntuacion;
		this.titulo = titulo;
	}
	public Pelicula(int id_pelicula, String id_peliculaAPI, String email, int puntuacion, String titulo) {
		super();
		this.id_pelicula=id_pelicula;
		this.id_peliculaAPI = id_peliculaAPI;
		this.email = email;
		this.puntuacion = puntuacion;
		this.titulo = titulo;
	}

	
	public Pelicula(String titulo, int puntuacion) {
		super();
		this.puntuacion=puntuacion;
		this.titulo = titulo;
	}

	public Pelicula(String id_peliculaAPI, String email, String titulo) {
		super();
		this.id_peliculaAPI = id_peliculaAPI;
		this.email = email;
		this.titulo = titulo;
	}


	public String getId_peliculaAPI() {
		return id_peliculaAPI;
	}

	public void setId_peliculaAPI(String id_peliculaAPI) {
		this.id_peliculaAPI = id_peliculaAPI;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}
	

	

	

}
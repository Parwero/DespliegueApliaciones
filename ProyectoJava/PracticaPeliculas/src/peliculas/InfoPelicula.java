package peliculas;

public class InfoPelicula {
	private String titulo;
	private String poster;
	private int anio;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public InfoPelicula(String titulo, String poster, int anio) {
		super();
		this.titulo = titulo;
		this.poster = poster;
		this.anio = anio;
	}
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", poster=" + poster + ", anio=" + anio + "]";
	}
	
	

}

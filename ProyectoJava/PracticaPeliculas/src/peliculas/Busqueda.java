package peliculas;

import java.util.ArrayList;

public class Busqueda {
	private int numeroResultados;
	private ArrayList<InfoPelicula> peliculas;
	public int getNumeroResultados() {
		return numeroResultados;
	}
	public void setNumeroResultados(int numeroResultados) {
		this.numeroResultados = numeroResultados;
	}
	public ArrayList<InfoPelicula> getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(ArrayList<InfoPelicula> peliculas) {
		this.peliculas = peliculas;
	}
	public Busqueda(int numeroResultados, ArrayList<InfoPelicula> peliculas) {
		super();
		this.numeroResultados = numeroResultados;
		this.peliculas = peliculas;
	}
	@Override
	public String toString() {
		return "Busqueda [numeroResultados=" + numeroResultados + ", peliculas=" + peliculas + "]";
	}
	

}

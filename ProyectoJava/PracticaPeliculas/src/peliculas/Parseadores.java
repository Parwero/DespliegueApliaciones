package peliculas;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Parseadores {
	public static Busqueda parseadorBusqueda(String resultadosJson) {
		JsonParser parser = new JsonParser();
		//Utilizo el parser para crear un array de json
        JsonObject obj = parser.parse(resultadosJson).getAsJsonObject();
        // Saco un objeto de cada elemento del array de json
        int resultados = obj.get("totalResults").getAsInt();
        //Recogemos cada pelicula en un array JSON
        JsonArray peliculas = obj.get("Search").getAsJsonArray();
        ArrayList<InfoPelicula> listaPeliculas = new ArrayList<InfoPelicula>();
        //Por cada elemento en el array de posicionesJSON creo otro en el arrayList 
        for (JsonElement peli : peliculas) {
        	JsonObject gsonPeliculaObj =peli.getAsJsonObject();
        	String titulo=gsonPeliculaObj.get("Title").getAsString();
        	int anio=0;
        	try {
        		anio=gsonPeliculaObj.get("Year").getAsInt();
        	}catch (NumberFormatException e) {
        	}
        	String poster=gsonPeliculaObj.get("Poster").getAsString();
        	
        	String id=gsonPeliculaObj.get("imdbID").getAsString();
        	InfoPelicula pelicula = new InfoPelicula(titulo,poster, anio);
        	pelicula.setId(id);
        	listaPeliculas.add(pelicula);
        }
        Busqueda b1=new Busqueda(resultados, listaPeliculas);
        return b1;
	}
	public static InfoPelicula parseadorPelicula(String resultadosJson) {
		JsonParser parser = new JsonParser();
		//Utilizo el parser para crear un array de json
        JsonObject obj = parser.parse(resultadosJson).getAsJsonObject();
        JsonObject gsonPeliculaObj =obj.getAsJsonObject();
        String titulo=gsonPeliculaObj.get("Title").getAsString();
        	int anio=0;
        	try {
        		anio=gsonPeliculaObj.get("Year").getAsInt();
        	}catch (NumberFormatException e) {
        	}
        	String poster=gsonPeliculaObj.get("Poster").getAsString();
        	
        	String id=gsonPeliculaObj.get("imdbID").getAsString();
        	InfoPelicula pelicula = new InfoPelicula(titulo,poster, anio);
        	pelicula.setId(id);
        return pelicula;
	}
}








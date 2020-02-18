package peliculas;

import proyectoJson.PeticionWeb;

public class BuscadorPeliculas {

	public static void main(String[] args) {
		String url="http://www.omdbapi.com/?s=titanic&apikey=dcdf1c79";
		try {
			String busquedaJson=PeticionWeb.peticionHttpGet(url);
			Busqueda busqueda= Parseadores.parseadorBusqueda(busquedaJson);
			System.out.println(busqueda);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

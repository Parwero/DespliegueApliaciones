package managers;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import objetos.Pelicula;



public class PeliculaManagers {
	private static EntityManager entityManager;
	public static void crearPelicula(Pelicula pelicula) {
    	entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(pelicula);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
	 public static void eliminarPelicula(Pelicula pelicula) {
	   		entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	   		entityManager.getTransaction().begin();
	   		//merge es unir.
	   		entityManager.remove(entityManager.contains(pelicula)
	   				?pelicula:entityManager.merge(pelicula));//condicion ? true : else
	   		entityManager.getTransaction().commit();
	   		entityManager.close(); 
	   }
	 public static ArrayList<Pelicula> consultarPeliculas() {
		   	ArrayList<Pelicula> peliculas= new ArrayList<Pelicula>();
		   	entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();
		   	entityManager.getTransaction().begin();
		   	peliculas= (ArrayList<Pelicula>) entityManager
		   			.createQuery("Select d from objetos.Pelicula d").getResultList();
		       return peliculas;
	 }
	 
	 
	   public static ArrayList<Pelicula> consultarId(Pelicula pelicula) {
			ArrayList<Pelicula> peliculas= new ArrayList<Pelicula>();
		
		   	entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();
		   	entityManager.getTransaction().begin();
		   	peliculas= (ArrayList<Pelicula>) entityManager
		   			.createQuery("Select e from objetos.Pelicula e where e.id_peliculaAPI ='" 
		   						+pelicula.getId_peliculaAPI()+"' and e.email='"+pelicula.getEmail()+
		   						"' and e.titulo='"+pelicula.getTitulo()+"'").getResultList();
		  		    
		    return peliculas;
	   }
	   
	 

	   public static boolean comprobarPeliculaExiste(Pelicula pelicula) {
			ArrayList<Pelicula> peliculas= new ArrayList<Pelicula>();
			boolean existe=false;
		   	entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();
		   	entityManager.getTransaction().begin();
		   	peliculas= (ArrayList<Pelicula>) entityManager
		   			.createQuery("Select e from objetos.Pelicula e where e.id_peliculaAPI ='" 
		   						+pelicula.getId_peliculaAPI()+"'").getResultList();
		    if(!peliculas.isEmpty()) {
		    	existe=true;
		    }
		    return existe;
	   }
	   
	   
	 public static void actualizarPelicula(Pelicula pelicula) {
		   	entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		   	entityManager.getTransaction().begin();
		   	entityManager.merge(pelicula);
		   	entityManager.getTransaction().commit();
		       entityManager.close(); 
	} 
	 
	 

}

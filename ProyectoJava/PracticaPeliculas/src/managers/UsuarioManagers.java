package managers;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import objetos.Usuario;

public class UsuarioManagers {
	private static EntityManager entityManager;
	public static void crearUsuario(Usuario usuario) {
    	entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
	 public static void eliminarUsuario(Usuario usuario) {
	   		entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	   		entityManager.getTransaction().begin();
	   		//merge es unir.
	   		entityManager.remove(entityManager.contains(usuario)
	   				?usuario:entityManager.merge(usuario));//condicion ? true : else
	   		entityManager.getTransaction().commit();
	   		entityManager.close(); 
	   }
	 public static ArrayList<Usuario> consultarUsuarios() {
		   	ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
		   	entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();
		   	entityManager.getTransaction().begin();
		   	usuarios= (ArrayList<Usuario>) entityManager
		   			.createQuery("Select d from objetos.Usuario d").getResultList();
		       return usuarios;
	 }
	 
	 
	   public static boolean comprobarUsuarioExiste(Usuario usuario) {
				ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
				boolean existe=false;
			   	entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();
			   	entityManager.getTransaction().begin();
			   	usuarios= (ArrayList<Usuario>) entityManager
			   			.createQuery("Select e from objetos.Usuario e where e.email ='"
			   					+ usuario.getEmail() + "' AND e.contrasenia= '" + usuario.getContrasenia() + "'").getResultList();
			    if(!usuarios.isEmpty()) {
			    	existe=true;
			    }
			    return existe;
		   }
		   
	}
	 



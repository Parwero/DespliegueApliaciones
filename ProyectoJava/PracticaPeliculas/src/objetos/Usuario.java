package objetos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "usuario" , schema = "bbddpeliculas" )
public class Usuario {
	@Id
	@Column(name="email")
	private String email;
	private String contrasenia;
	
	public Usuario() {
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Usuario(String email, String contrasenia) {
	
		this.email = email;
		this.contrasenia = contrasenia;
	}
	
}

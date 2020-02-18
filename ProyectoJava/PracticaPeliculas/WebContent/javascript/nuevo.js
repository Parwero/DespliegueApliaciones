/**
 * 
 */

function ComprobarContrasenia(){
	var c = document.getElementById("contrasenia1").value;
	var b = document.getElementById("contrasenia2").value;
		if (c==b){
		document.getElementById("formulario").submit();
		
		}
		else{
			document.getElementById('error').style.visibility = 'visible';
		}

}

function existe(){
	var c = document.getElementById("email").value;
	var b = document.getElementById("contrasenia").value;
	
}



<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<form  method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>" >
 <p>Nombre: <input type="text" name="Primernombre" /></p>
 <p>Apellido: <input type="text" name="Apellido" /></p>
  <p>Correo: <input type="text" name="Correo" /></p>
 


 <p><input type="submit" name="envioRegistro" /></p>
</form>

	
</body>
</html>



<?php
$servername="localhost";

$username="root";

$password="";

$dbname = "Mibase";

//Create conection

$conn = new mysqli($servername, $username, $password, $dbname);

if($conn->connect_error){
	die("Connection fallida" . $conn->connect_error);
}


if(isset($_POST['envioRegistro'])){
		global $conn;
		$Primernombre = $_POST['Primernombre']; 
        $Apellido = $_POST['Apellido']; 
        $Correo = $_POST['Correo']; 
        
         $sql= "INSERT INTO Usuario (Primernombre, Apellido, correo) VALUES ('$Primernombre','$Apellido','$Correo');";
        /*$sql= "INSERT INTO myguests VALUES ('".$firstname."','".$lastname."');";*/

			if(mysqli_query($conn,$sql)===TRUE){

				echo "<h3 style='color:#69e776'>Registro completado con exito</h3>";

			}else{

				echo "<h3 style='color:#f55858'>Error al registrar: ".$conn->error."</h3>";

			}

	}




$conn->close();

?>



<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<form  method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>" >

<h2>Borrar</h2>

 <p> Por Nombre: <input type="text" name="Primernombre" /></p>
 <p><input type="submit" name="envioRegistro" /></p>
</form>

<form  method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>" >
<p> Por Apellido: <input type="text" name="Apellido" /></p>
<p><input type="submit" name="envioRegistro1" /></p>
</form>

<form  method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>" >
<p> Por Correo: <input type="text" name="Correo" /></p>
<p><input type="submit" name="envioRegistro2" /></p>
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


$sql4="SELECT Primernombre, Apellido, Correo FROM usuario";
$result = $conn->query($sql4);

 if ($result->num_rows > 0){

	 echo "<table border='1'><tr><th>Datos</th></tr>";

	while($row = $result->fetch_assoc()){

		echo "<tr ><td >".$row["Primernombre"]." ".$row["Apellido"]." ".$row["Correo"]."</td></tr>";

	}

	echo "</table>";

}else{

	echo "0 results";

}




if(isset($_POST['envioRegistro'])){
		global $conn;
		$Primernombre = $_POST['Primernombre']; 

         $sql= "DELETE  FROM Usuario WHERE Primernombre='$Primernombre'";
        /*$sql= "INSERT INTO myguests VALUES ('".$firstname."','".$lastname."');";*/

			if(mysqli_query($conn,$sql)===TRUE){

				echo "<h3 style='color:#69e776'>Registro completado con exito</h3>";

			}else{


				echo "<h3 style='color:#f55858'>Error al registrar: ".$conn->error."</h3>";

			}

	}

	if(isset($_POST['envioRegistro1'])){

		$Apellido = $_POST['Apellido']; 

         $sql2= "DELETE  FROM Usuario WHERE Apellido='$Apellido'";
        /*$sql= "INSERT INTO myguests VALUES ('".$firstname."','".$lastname."');";*/

			if(mysqli_query($conn,$sql2)===TRUE){

				echo "<h3 style='color:#69e776'>Registro completado con exito</h3>";

			}else{


				echo "<h3 style='color:#f55858'>Error al registrar: ".$conn->error."</h3>";

			}

	}

	if(isset($_POST['envioRegistro2'])){

		$Correo = $_POST['Correo']; 

         $sql3= "DELETE  FROM Usuario WHERE Correo='$Correo'";
        /*$sql= "INSERT INTO myguests VALUES ('".$firstname."','".$lastname."');";*/

			if(mysqli_query($conn,$sql3)===TRUE){

				echo "<h3 style='color:#69e776'>Registro completado con exito</h3>";

			}else{


				echo "<h3 style='color:#f55858'>Error al registrar: ".$conn->error."</h3>";

			}

	}




$conn->close();

?>


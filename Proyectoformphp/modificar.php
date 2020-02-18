
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<form  method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>" >
<p>Modificar<p>
<p>Listas de nombres</p>		
 <p>Nombre: <input type="text" name="Primernombre" /></p>
 <p>Nuevo valor Nombre: <input type="text" name="Valor" /></p>
<p><input type="submit" name="envioRegistro" /></p>
</form>

	<form  method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>" >	
 <p>Apellido: <input type="text" name="Apellido" /></p>
 <p>Nuevo valor Apellido: <input type="text" name="Valor2" /></p>
<p><input type="submit" name="envioRegistro2" /></p>
</form>

<form  method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>" >	
 <p>Correo: <input type="text" name="Correo" /></p>
 <p>Nuevo valor Correo: <input type="text" name="Valor3" /></p>
<p><input type="submit" name="envioRegistro3" /></p>
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

$sql2="SELECT Primernombre, Apellido, Correo FROM usuario";
$result = $conn->query($sql2);

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
		$conn;
		$Primernombre = $_POST['Primernombre']; 
		$Valor = $_POST['Valor']; 
     

         $sql= "UPDATE Usuario SET Primernombre='$Valor' WHERE Primernombre='$Primernombre';";
        /*$sql= "INSERT INTO myguests VALUES ('".$firstname."','".$lastname."');";*/

			if(mysqli_query($conn,$sql)===TRUE){

				echo "<h3 style='color:#69e776'>Registro completado con exito</h3>";

			}else{

				echo "<h3 style='color:#f55858'>Error al registrar: ".$conn->error."</h3>";

			}

	}


	if(isset($_POST['envioRegistro2'])){
		$conn;
		$Apellido = $_POST['Apellido']; 
		$Valor2 = $_POST['Valor2']; 
     

         $sql3= "UPDATE Usuario SET Apellido='$Valor2' WHERE Apellido='$Apellido';";
        /*$sql= "INSERT INTO myguests VALUES ('".$firstname."','".$lastname."');";*/

			if(mysqli_query($conn,$sql3)===TRUE){

				echo "<h3 style='color:#69e776'>Registro completado con exito</h3>";

			}else{

				echo "<h3 style='color:#f55858'>Error al registrar: ".$conn->error."</h3>";

			}

	}


	if(isset($_POST['envioRegistro3'])){
		$conn;
		$Correo = $_POST['Correo']; 
		$Valor3 = $_POST['Valor3']; 
     

         $sql4= "UPDATE Usuario SET Apellido='$Valor3' WHERE Correo='$Correo';";
        /*$sql= "INSERT INTO myguests VALUES ('".$firstname."','".$lastname."');";*/

			if(mysqli_query($conn,$sql4)===TRUE){

				echo "<h3 style='color:#69e776'>Registro completado con exito</h3>";

			}else{

				echo "<h3 style='color:#f55858'>Error al registrar: ".$conn->error."</h3>";

			}

	}







$conn->close();



/*
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "UPDATE Usuario SET Apellido='Hola' WHERE id=2";

if ($conn->query($sql) === TRUE) {
    echo "Record updated successfully";
} else {
    echo "Error updating record: " . $conn->error;
}

$conn->close();

*/

?>


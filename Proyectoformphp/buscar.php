
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<form  method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>" >

<h2>Buscar</h2>
 <p> Por Nombre: <input type="text" name="Primernombre" /></p>
 <p><input type="submit" name="envioRegistro" /></p>
</form>


	<form  method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>" >
 <p> Por Apellido: <input type="text" name="Apellido" /></p>
 <p><input type="submit" name="envioRegistro2" /></p>
</form>

	<form  method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>" >
 <p> Por Correo: <input type="text" name="Correo" /></p>
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



	if(isset($_POST['envioRegistro'])){
		$conn;
		$Primernombre = $_POST['Primernombre']; 


$sql="SELECT * FROM usuario WHERE Primernombre='$Primernombre'";
$result = $conn->query($sql);

 if ($result->num_rows > 0){

	 echo "<table border='1'><tr><th>Datos</th></tr>";

	while($row = $result->fetch_assoc()){

		echo "<tr ><td >".$row["Primernombre"]." ".$row["Apellido"]." ".$row["Correo"]."</td></tr>";

	}

	echo "</table>";

}else{

	echo "0 results";

}
}

if(isset($_POST['envioRegistro2'])){
		$conn;
		$Apellido = $_POST['Apellido']; 


$sql2="SELECT * FROM usuario WHERE Apellido='$Apellido'";
$result2 = $conn->query($sql2);

 if ($result2->num_rows > 0){

	 echo "<table border='1'><tr><th>Datos</th></tr>";

	while($row2 = $result2->fetch_assoc()){

		echo "<tr ><td >".$row2["Primernombre"]." ".$row2["Apellido"]." ".$row2["Correo"]."</td></tr>";

	}

	echo "</table>";

}else{

	echo "0 results";

}
}


if(isset($_POST['envioRegistro3'])){
		$conn;
		$Correo = $_POST['Correo']; 


$sql3="SELECT * FROM usuario WHERE Correo='$Correo'";
$result3 = $conn->query($sql3);

 if ($result3->num_rows > 0){

	 echo "<table border='1'><tr><th>Datos</th></tr>";

	while($row3 = $result3->fetch_assoc()){

		echo "<tr ><td >".$row3["Primernombre"]." ".$row3["Apellido"]." ".$row3["Correo"]."</td></tr>";

	}

	echo "</table>";

}else{

	echo "0 results";

}
}







?>


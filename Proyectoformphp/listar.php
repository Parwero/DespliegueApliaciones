
<?php
//objeto mysql
$servername="localhost";

$username="root";

$password="";

$dbname = "Mibase";

//create connection

$conn = new mysqli($servername, $username, $password, $dbname);

if($conn->connect_error){
	die("Connection fallida" . $conn->connect_error);

}



$sql="SELECT Primernombre, Apellido, Correo FROM usuario";
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




/*
$sql = "SELECT firstname, lastname FROM MyGuests"; //mysql 
$result = $conn->query($sql);


if($result->num_rows > 0 ){
	while($row = $result->fetch_assoc()){
	echo "Nombre: " .$row["firstname"]. " " . $row["lastname"]. "";
}
	}else{
	echo "0 resultados";
	}
	$conn->close();
*/

?>



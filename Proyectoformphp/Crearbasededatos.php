<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "Mibase";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// sql to create table
$sql = "CREATE TABLE Usuario (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Primernombre VARCHAR(30) NOT NULL,
Apellido VARCHAR(30) NOT NULL,
Correo VARCHAR(50),
reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)";

if ($conn->query($sql) === TRUE) {
    echo "Table MyGuests created successfully";
} else {
    echo "Error creating table: " . $conn->error;
}

$conn->close();
?>
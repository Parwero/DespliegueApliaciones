<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="javascript/nuevo.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>Login</h1>

<Form method = "GET" action = "admin" id="formulario">
	<Label for = "email" > Email: </label>
	<Input id = "email" type = "email" name = "email" placeholder="inserta email"/>
	<br/><br/>
	<Label for = "contrasenia" > Contraseña:</label>
	<Input id = "contrasenia" type = "password" name = "contrasenia" placeholder="inserta contrasenia"/>
	<Input type = "button" value="Entrar" onClick="submit()">
</Form>	
	<br/><hr/><br/>


	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
    <%@ page import="objetos.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="javascript/nuevo.js"></script>
<title>Insert title here</title>
</head>
<body>
<%Usuario usu = null;
	if (request.getSession().getAttribute("usuario")!=null){
		usu=(Usuario)request.getSession().getAttribute("usuario");
	}else{
		usu=new Usuario("g@daniel.com", "dani");
	}
	request.getSession().setAttribute("usuario", usu);
	
%>


<h2>El usuario <%=usu.getEmail() %> se ha insertado corretamente</h2>


	<Form method = "GET" action = "altaUsuario.html" id="formulario">
	
		<Input type = "submit" value="volver" >
		
	</Form >
</body>
</html>
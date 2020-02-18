<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@page import="managers.PeliculaManagers"%>  
<%@page import="objetos.Pelicula"%>    
<%@page import="java.util.ArrayList"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
	
		<%ArrayList<Pelicula> peliculasPuntuadas = (ArrayList<Pelicula>)request.getSession().getAttribute("peliculasPuntuadas");%>
		
		<h1>Puntuadas</h1>
			
			<%for (int i=0; i<peliculasPuntuadas.size();i++){ %>
				<a>Titulo <%=peliculasPuntuadas.get(i).getTitulo() %></a>
				<a>Puntuacion <%=peliculasPuntuadas.get(i).getPuntuacion()%></a>
				<br/>
			<%}%>
					
		<a href=/PracticaPeliculas/formulario.jsp>volver</a>
	</body>
</html>
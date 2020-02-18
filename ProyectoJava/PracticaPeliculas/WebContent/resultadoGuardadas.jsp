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
		
	
		<%ArrayList<Pelicula> peliculasGuardadas = (ArrayList<Pelicula>)request.getSession().getAttribute("peliculasGuardadas");%>
		
		<h1>Guardadas</h1>
					
		<%for (int i=0; i<peliculasGuardadas.size();i++){ %>
				<a>Titulo <%=peliculasGuardadas.get(i).getTitulo() %></a>
				
				<br/>
		<%}%>
						
			
		<a href=/PracticaPeliculas/formulario.jsp>volver</a>
	</body>
</html>
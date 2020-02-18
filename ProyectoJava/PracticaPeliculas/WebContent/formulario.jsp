<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="peliculas.Busqueda" %>
<%@ page import="peliculas.InfoPelicula" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="managers.PeliculaManagers"%>

<%@ page import="objetos.Usuario" %>
<%@ page import="objetos.Pelicula" %>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="javascript/nuevo.js"></script>

<title>Insert title here</title>
</head>
<body>
	<Form method = "GET" action = "buscarpelicula" id="formulario">
	
		<%Usuario usu = null;
			if (request.getSession().getAttribute("usuario")!=null){
				usu=(Usuario)request.getSession().getAttribute("usuario");
			}else{
				usu=new Usuario("g@daniel.com", "dani");
			}
			request.getSession().setAttribute("usuario", usu);
			
		%>
		<h3>Estas autentificado con el usuario <%=usu.getEmail()%></h3>
		<a name=<%=usu.getEmail()%>></a>

	
	
		<Label for = "nombre" > Nombre pelicula </label>
		<Input id = "nombre" type = "text" name = "nombre"/>
		
		
		<Input type = "submit" >
		
		
		
	</Form >
	
		
		
	<%if(request.getSession().getAttribute("busqueda")!=null) {
		
		
		Busqueda busqueda= (Busqueda)request.getSession().getAttribute("busqueda");
		for(InfoPelicula p: busqueda.getPeliculas()){
	%>
		<h3><%=p.getTitulo() %></h3>
		<a href=/PracticaPeliculas/buscarpeliculaporid?id=<%=p.getId() %>>
		<img src="<%=p.getPoster()%>"></a>
		
		
	<%}} %>
	
	
	
	<% 
	
	if(request.getSession().getAttribute("pelicula")!=null) {
		InfoPelicula p= (InfoPelicula)request.getSession().getAttribute("pelicula");

		
			
	%>
		<h3><%=p.getTitulo() %></h3>
		<img src="<%=p.getPoster()%>">
		<h3><%=p.getAnio() %></h3>
		
		<Form method = "GET" action = "crearPuntuacion" id="formulario">
		
			<select id="npuntuacion" name="puntuacion">
			
	
				<%for (int i=0; i<11;i++){ %>
					<option value=<%=i%>><%=i%></option>
				
				<%}%>
				</select>
				
			<Input type="hidden" value="<%=p.getId() %>" name="id_peliculaAPI"/>
			<Input type="hidden" value="<%=p.getTitulo() %>" name="titulo"/>
			<Input type="hidden" value="<%=usu.getEmail()%>" name="email"/>
		
					
			<Input type = "submit" value="Puntuar Pelicula" >
		
		</Form>
		<br><br>
		
		
		
		<Form method = "GET" action = "guardarPelicula" id="formulario">
		
			
			<Input type="hidden" value="<%=p.getId() %>" name="id_peliculaAPI"/>
			<Input type="hidden" value="<%=p.getTitulo() %>" name="titulo"/>
			<Input type="hidden" value="<%=usu.getEmail()%>" name="email"/>
					
			<Input type = "submit" value="Guardar Pelicula" >
			
		</Form>
		
		<br><br>
		
		
		
		<Form method = "GET" action = "verPuntuadas" id="formulario">
		
			
			<Input type="hidden" value="<%=p.getId() %>" name="id_peliculaAPI"/>
			<Input type="hidden" value="<%=p.getTitulo() %>" name="titulo"/>
			<Input type="hidden" value="<%=usu.getEmail()%>" name="email"/>
					
			<Input type = "submit" value="Ver Puntuadas" >
			
		</Form>
		
		
		
		<Form method = "GET" action = "verGuardadas" id="formulario">
		
			
			<Input type="hidden" value="<%=p.getId() %>" name="id_peliculaAPI"/>
			<Input type="hidden" value="<%=p.getTitulo() %>" name="titulo"/>
			<Input type="hidden" value="<%=usu.getEmail()%>" name="email"/>
					
			<Input type = "submit" value="Ver Guardadas" >
			
		</Form>
		
		
		<%} %>

	

</body>
</html>
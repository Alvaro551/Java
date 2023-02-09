<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.sql.*" %>
	<%@ page import="java.util.ArrayList"%>
	<% 
	HttpSession sesion = request.getSession();
	ArrayList<String> Respuestas= (ArrayList<String>)sesion.getAttribute("Respuestas"); 
	String pregunta = (String) sesion.getAttribute("pregunta1");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario Checkbox</title>
</head>
<body>
	<form action="resultadosCheckbox.jsp">
		<input type="checkbox" name="opcion" value="<%= Respuestas.get(0) %>"><%= Respuestas.get(0) %><br>
		<input type="checkbox" name="opcion" value="<%= Respuestas.get(1) %>"><%= Respuestas.get(1) %><br>
		<input type="checkbox" name="opcion" value="<%= Respuestas.get(2) %>"><%= Respuestas.get(2) %><br>
		<input type="checkbox" name="opcion" value="<%= Respuestas.get(3) %>"><%= Respuestas.get(3) %><br>
		<input type="submit" value="Enviar">
	</form>
</body>
</html>
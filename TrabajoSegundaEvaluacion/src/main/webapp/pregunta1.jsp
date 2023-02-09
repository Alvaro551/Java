<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page
	import="java.util.ArrayList , java.util.LinkedHashMap , java.util.*"%>
<%@  page import="Clases.*"%>
<%
HttpSession sesion = request.getSession();
ArrayList<Pregunta> preguntas = (ArrayList<Pregunta>) sesion.getAttribute("preguntas");



int[] seleccionados = null;
String[] respuestas = (String[]) sesion.getAttribute("respuesta1");
if (respuestas != null) {
	seleccionados = new int[respuestas.length];
	for (int i = 0; i < seleccionados.length; i++) {
		seleccionados[i] = Integer.parseInt(respuestas[i]);
	}
	
	
}

sesion.setAttribute("seleccion1", seleccionados);





//String pregunta = (String) sesion.getAttribute("pregunta1");
int contador = (int) sesion.getAttribute("contador");
contador = 1;
sesion.setAttribute("contador", contador);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Checkbox</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<main id="container">
		<h1>Pagina 1</h1>
		<p>
			<%
			out.print(preguntas.get(0).getTexto());
			%>
		</p>
		<form action="Controlador" method="post">
			<p><%=Scriptlets.generaArrayCajasChequeo("respuestas" + contador, Datos.hacerMapa(preguntas, 0), seleccionados)%></p>
			<input type="submit" name="boton" value="Avanzar">
		</form>
	</main>
</body>
</html>
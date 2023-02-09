<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page
	import="java.util.ArrayList , java.util.LinkedHashMap , java.util.*"%>
<%@  page import="Clases.*"%>
<%
HttpSession sesion = request.getSession();
ArrayList<Pregunta> preguntas = (ArrayList<Pregunta>) sesion.getAttribute("preguntas");

//String pregunta = (String) sesion.getAttribute("pregunta1");
int contador = (int) sesion.getAttribute("contador");
contador = 1;
sesion.setAttribute("contador", contador);

int[] seleccionados = null;
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
		<h1>Resultados</h1>
		<form action="Controlador" method="post">
			
			<p>
				<%
				out.print(preguntas.get(0).getId());
				out.print(preguntas.get(0).getTexto());
				out.print("<br>");
				out.print("Has seleccionado la opcion : ");
				String[] respuestas = (String[]) sesion.getAttribute("respuesta1");
				if (respuestas != null) {
					seleccionados = new int[respuestas.length];
					for (int i = 0; i < seleccionados.length; i++) {
						seleccionados[i] = Integer.parseInt(respuestas[i]);
						out.print(seleccionados[i]);
					}
				}
				out.print("<br>");
				for (int i = 0; i < preguntas.size() - 2; i++) {
					for (int j = 0; j < preguntas.get(i).getRespuestas().size(); j++) {
						out.print(preguntas.get(i).getRespuestas().get(j).getRespuesta());
						out.print("<br>");
					}

				}
				%>
			</p>
			<br>
			<p>
				<%
				out.print(preguntas.get(1).getId());
				out.print(preguntas.get(1).getTexto());
				out.print("<br>");
				out.print("Has seleccionado la opcion : ");
				String[] respuestas2 = (String[]) sesion.getAttribute("respuesta2");
				if (respuestas2 != null) {
					seleccionados = new int[respuestas2.length];
					for (int i = 0; i < seleccionados.length; i++) {
						seleccionados[i] = Integer.parseInt(respuestas2[i]);
						out.print(seleccionados[i]);
					}
				}
				out.print("<br>");
				
				for (int i = 1; i < preguntas.size() - 1; i++) {
					for (int j = 0; j < preguntas.get(i).getRespuestas().size(); j++) {
						out.print(preguntas.get(i).getRespuestas().get(j).getRespuesta());
						out.print("<br>");
					}

				}
				%>
			</p>
			<br>
			<p>
				<%
				out.print(preguntas.get(2).getId());
				out.print(preguntas.get(2).getTexto());
				out.print("<br>");
				out.print("Has seleccionado la opcion : ");
				String[] respuestas3 = (String[]) sesion.getAttribute("respuesta3");
				if (respuestas3 != null) {
					seleccionados = new int[respuestas3.length];
					for (int i = 0; i < seleccionados.length; i++) {
						seleccionados[i] = Integer.parseInt(respuestas3[i]);
						out.print(seleccionados[i]);
					}
				}
				out.print("<br>");
				for (int i = 2; i < preguntas.size(); i++) {
					for (int j = 0; j < preguntas.get(i).getRespuestas().size(); j++) {
						out.print(preguntas.get(i).getRespuestas().get(j).getRespuesta());
						out.print("<br>");
					}

				}
				%>
			</p>
		</form>
	</main>
</body>
</html>
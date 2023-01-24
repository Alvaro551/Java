<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>

<body>
	<form action="Echo" method="POST" enctype="multipart/form-data">
		<input type="text" name="nombre" placeholder="Nombre"> <br>
		<input type="password" name="clave" placeholder="Contraseña">
		<br> <input type="radio" name="sexo" value="Hombre"> <label
			for="sexo">Hombre</label> <input type="radio" name="sexo"
			value="Mujer"> <label for="genero">Mujer</label> <br> <input
			type="date" name="fecha"> <br> <select name="select1"
			multiple>
			<option value="España">España</option>
			<option value="Argentina">Argentina</option>
			<option value="Francia">Francia</option>
		</select> <br>
		<textarea name="comentario" rows="6" cols="20"
			placeholder="Comentarios"></textarea>
		<br> <input type="checkbox" name="acepto"> <label
			for="acepto">Acepto las condiciones</label> <br> <input
			type="submit" value="Enviar">
	</form>

	<%
	String nombre = (String) request.getAttribute("nombre");
	String clave = (String) request.getAttribute("clave");
	String sexo = (String) request.getAttribute("sexo");
	String fecha = (String) request.getAttribute("date");
	String[] paises = (String[]) request.getAttribute("select1");
	String errors = (String) request.getAttribute("errors");
	%>

	<%
	if (nombre != null && nombre.length() != 0) {
		out.print("Tu nombre es " + nombre);
	%>
	<br>
	<%
	}
	%>

	<%
	if (clave != null && nombre.length() != 0) {
		out.print("Tu clave es " + clave);
	%>
	<br>
	<%
	}
	%>
	<%
	if (sexo != null && nombre.length() != 0) {
		out.print("Eres " + sexo);
	%>
	<br>
	<%
	}
	%>
	<%
	if (fecha != null && nombre.length() != 0) {
		out.print("La fecha introducida es " + fecha);
	%>
	<br>
	<%
	}
	%>
	<%
	if (paises != null && paises.length != 0) {
		out.print("El/Los país/países es/son: ");
		for (String pais : paises) {
	%>

	<li>
		<%
		out.println(pais);
		%>
	</li>
	<%
	}
	}
	%>
	<%
	if (errors != null) {
		out.print(errors);
	}
	%>
</body>

</html>
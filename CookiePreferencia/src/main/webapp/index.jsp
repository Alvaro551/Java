<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//Validaciones campos  vacios formulario
String mensajeErrorNombreNoEnviado = "";
String mensajeErrorContrasenaNoEnviada = "";
boolean nombreHaSidoEnviado;
boolean contrasenaHaSidoEnviada;
String nombre;
String contrasena;
if (request.getAttribute("nombreHaSidoEnviado") != null && !((boolean) request.getAttribute("nombreHaSidoEnviado"))) {
	nombreHaSidoEnviado = false;
	mensajeErrorNombreNoEnviado = "El campo nombre está vacío.";
} else if (request.getAttribute("nombreHaSidoEnviado") != null
		&& ((boolean) request.getAttribute("nombreHaSidoEnviado"))) {
	nombreHaSidoEnviado = true;
} else {
	nombreHaSidoEnviado = false;
}
if (request.getAttribute("contrasenaHaSidoEnviada") != null
		&& !((boolean) request.getAttribute("contrasenaHaSidoEnviada"))) {
	contrasenaHaSidoEnviada = false;
	mensajeErrorContrasenaNoEnviada = "El campo contraseña está vacío.";
} else if (request.getAttribute("contrasenaHaSidoEnviada") != null
		&& ((boolean) request.getAttribute("contrasenaHaSidoEnviada"))) {
	contrasenaHaSidoEnviada = true;
} else {
	contrasenaHaSidoEnviada = false;
}
//Validacion campos erroneos formularios
boolean usuarioValido;
boolean contrasenaValida;
if (request.getAttribute("usuarioValido") != null && !((boolean) request.getAttribute("usuarioValido"))) {
	usuarioValido = false;
	mensajeErrorNombreNoEnviado = "El nombre no es correcto.";
} else if (request.getAttribute("usuarioValido") != null && ((boolean) request.getAttribute("usuarioValido"))) {
	usuarioValido = true;
} else {
	usuarioValido = false;
}
if (request.getAttribute("contrasenaValida") != null && !((boolean) request.getAttribute("contrasenaValida"))) {
	contrasenaValida = false;
	mensajeErrorContrasenaNoEnviada = "La contraseña no es correcta.";
} else if (request.getAttribute("contrasenaValida") != null && ((boolean) request.getAttribute("contrasenaValida"))) {
	contrasenaValida = true;
} else {
	contrasenaValida = false;
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="contenedor">
		<form action="recepcion" method="post">
			<label for="nombre">Nombre:</label> <input type="text" name="nombre"
				class="campoTexto" /> <label for="contrasena">Contraseña:</label> <input
				type="password" name="contrasena" class="campoTexto" /> <input
				type="submit" class="boton" />
		</form>
	</div>
	<p class="mensajeError"><%=mensajeErrorNombreNoEnviado%></p>
	<p class="mensajeError"><%=mensajeErrorContrasenaNoEnviada%></p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//inicializo nombre a usuario e intento capturar nombre del objeto request si existe y no está vacío
String nombreUsuario = "usuario";
if (request.getAttribute("nombreUsuario") != null && !((String) request.getAttribute("nombreUsuario")).equals("")) {
	nombreUsuario = (String) request.getAttribute("nombreUsuario");
}
//Radiobuton seleccionado
String radio1 = "checked";
String radio2 = "";
String radio3 = "";
//Contador
int contador;
//Ver si hay cookie
Cookie[] cookies = request.getCookies();
Cookie ck = null;
if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals(nombreUsuario)) {
	ck = cookie;
	break;
		}
	}
}
//si encuentra la cookie
if (ck != null) {
	//Sacando los valores de la cookie
	String contenidoCk[] = ck.getValue().split("&");
	//Radiobuton seleccionado
	String checkBox = contenidoCk[1];
	switch (checkBox) {
	case "espanol":
		radio1 = "checked";
		radio2 = "";
		radio3 = "";
		break;
	case "ingles":
		radio1 = "";
		radio2 = "checked";
		radio3 = "";
		break;
	case "frances":
		radio1 = "";
		radio2 = "";
		radio3 = "checked";
		break;
	default:
		radio1 = "checked";
		radio2 = "";
		radio3 = "";
	}
	//Contador
	contador =(int) request.getAttribute("contador");
}else{
	contador=1;
}
//
%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link rel="stylesheet" href="style2.css" />
</head>
<body>
	<div class="contenedor">
		<p>
			Bienvenido <strong><%=nombreUsuario%> </strong>
		</p>
		<form action="guardaCookie" method="post">

			<input type="radio" id="espanol" name="idiomas" value="espanol"
				<%=radio1%> /> <label for="espanol">Español</label> <input
				type="radio" id="ingles" name="idiomas" value="ingles" <%=radio2%> />
			<label for="ingles">Inglés</label> <input type="radio" id="frances"
				name="idiomas" value="frances" <%=radio3%> /> <label for="frances">Francés</label>
			<input type="hidden" name="nombreUsuarioYContador"
				value="<%=nombreUsuario%>&<%=contador%>"> <input
				type="submit" value="Desconectar">

		</form>
		<p id="contador">
			Nº de visitas: <strong><%=contador%></strong>
		</p>
	</div>
</body>
</html>
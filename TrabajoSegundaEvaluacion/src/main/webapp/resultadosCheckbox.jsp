<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultados Checkbox</title>
</head>
<body>
	<%
		String[] opcionesSeleccionadas = request.getParameterValues("opcion");
		if (opcionesSeleccionadas != null) {
			for (String opcion : opcionesSeleccionadas) {
				out.println("Opción seleccionada: " + opcion + "<br>");
			}
		} else {
			out.println("No se seleccionó ninguna opción.");
		}
	%>
</body>
</html>
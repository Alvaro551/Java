
<!DOCTYPE>
<html>
<head>
<title>Scriptlets JSP</title>
</head>
<%@page import="java.util.*"%>
<%-- Esto en un comentario de JSP --%>
<%!private int cont = 0;
	private Date fecha = new Date();%>
<body>
	<p>
		Esta p�gina ha sido accedida
		<b><%=++cont%></b>
		veces.
	</p>
	<p>
		El �ltimo acceso ha sido con fecha
		<b><%=fecha%></b>
	</p>
	<%
	fecha = new Date();
	%>
</body>
</html>
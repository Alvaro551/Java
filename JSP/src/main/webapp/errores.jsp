<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>P´agina de errores en JSP</title>
</head>
<body >
<%@page isErrorPage="true"%>
<h1>P´agina de errores en JSP</h1>
<p>division.jsp ha reportado el siguiente error:
<b><%=exception%></b>
</p>
<p>El error que ha ocurrido es: <pre><% exception.printStackTrace(new java.io.PrintWriter(out)); %></pre></p>
</body>
</html>

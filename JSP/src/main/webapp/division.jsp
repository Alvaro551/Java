<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Manejo de errores de JSP</title>
</head>
<body >
<%@page errorPage="errores.jsp"%>
<h1>Ejemplo de manejo de errores en JSP</h1>
<%!
private double toDouble(String value)
{
return(Double.valueOf(value).doubleValue());
}
%>
<%
double op1 = toDouble(request.getParameter("op1"));
double op2= toDouble(request.getParameter("op2"));
double res = op1/op2;
%>
<table border=1>
<tr><th></th><th>Divisi´on</th></tr>
<tr><th>Operando 1: </th><td><%=op1%></td></tr>
<tr><th>Operando 2: </th><td><%=op2%></td></tr>
<tr><th>Resultado: </th><td><%=res%></td></tr>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="content">
		<b>Bienvenido al curso</b>
		<p>
			Hoy es
			<%=Calendar.getInstance().getTime()%>
		</p>
		<%
		String saludo;
		int horaDelDia = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (horaDelDia < 12) {
			saludo = "Buenos dias!";
		} else if (horaDelDia >= 12 && horaDelDia < 21) {
			saludo = "Buenos tardes!";
		} else {
			saludo = "Buenos noches!";
		}
		%>
		<p><%=saludo%></p>
		
		<%@include file="Contador.jsp"%>
	</div>
</body>
</html>
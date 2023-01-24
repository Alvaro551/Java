<html>
<body>
	<%
    Cookie[] cookies = request.getCookies();
    int viewCount = 1;
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("view_count")) {
                viewCount = Integer.parseInt(cookie.getValue());
            }
        }
    }
%>
	<p>
		El número de visitas de esta páginas es de:
		<%= viewCount %>.
	</p>
</body>
</html>
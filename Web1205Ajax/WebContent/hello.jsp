<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<html> <head> <title> hello.jsp</title> </head>
<body>
	<%
		request.setCharacterEncoding("euc-kr") ;
		String   name = request.getParameter("name") ;
	%>
	<h1> 안녕하세요 <font color=red>  <%= name %>  </font> 회원님!!! </h1>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<html> <head> <title> hello.jsp</title> </head>
<body>
	<%
		request.setCharacterEncoding("euc-kr") ;
		String   name = request.getParameter("name") ;
	%>
	<h1> �ȳ��ϼ��� <font color=red>  <%= name %>  </font> ȸ����!!! </h1>
</body>
</html>
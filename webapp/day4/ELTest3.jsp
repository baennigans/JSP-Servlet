<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("attr", "hello world");
%>
<%= request.getAttribute("attr") %><br/>
	${requestScope["attr"]}<br/>
	${requestScope.attr}<br/>
	${requestScope["attr2"]}<br/>
<%
	Map<String, String> map = new HashMap<>();
	map.put("one", "hello");
	map.put("two", "World");
	pageContext.setAttribute("map", map);
%>

${map.get("one")}, ${map["one"]}, ${map.one}<br/>
<!-- 
${(10*10) ne 10}<br/>
${3 div 4}<br/>
 -->
${(10*10) != 10}<br/>
${3 / 4}<br/>
${empty param.Add }<br/>
${pageContext.request.contextPath }<br/>
${header["host"] }
</body>
</html>
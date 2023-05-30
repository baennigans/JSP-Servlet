<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="day5.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BookVO book1 = new BookVO();
	book1.setTitle("성공");
	BookVO[] books1 = {book1};
	pageContext.setAttribute("books1",books1);
%>
<%
	Map<String, String> book2 = new HashMap<>();
	book2.put("title","성공");
	Map[] books2 = {book2};
	pageContext.setAttribute("books2",books2);
%>
<%
	BookVO book3 = new BookVO();
	book3.setTitle("성공");
	List<BookVO> books3 = new ArrayList<>();
	books3.add(book3);
	pageContext.setAttribute("books3", books3);
%>
<%
	Map<String, String> book4 = new HashMap<>();
	book4.put("title","성공");
	List<Map<String, String>> books4 = new ArrayList<>();
	books4.add(book4);
	pageContext.setAttribute("books4", books4);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 성공 출력 --%>
	성공/실패?? ${ books1[0].title }<br>
	성공/실패?? ${ books2[0].title }<br>
	성공/실패?? ${ books3[0].title }<br>
	성공/실패?? ${ books4[0].title }<br>
</body>
</html>
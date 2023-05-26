<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String username = (String) session.getAttribute("username"); %>

<!DOCTYPE html>
<html>
<head>
  <title>Main</title>
</head>
<body>
  <h2>* 로그인 완료 *</h2>
  <p><%= username %>님 안녕하세요!</p>
  <form method="post" action="logout.jsp">
    <input type="submit" value="Logout">
  </form>
</body>
</html>
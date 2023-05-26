<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String username = (String) session.getAttribute("username");
  if (username != null) {
    response.sendRedirect("main.jsp");
  }
%>
<!DOCTYPE html>
<html>
<head>
  <title>Login Page</title>
</head>
<body>
  <h2>* 로그인 *</h2>
  <form method="post" action="loginProcess.jsp">
    <div>
      <label for="username">ID : </label>
      <input type="text" id="username" name="username" required><br><br>
    </div>
    <div>
      <label for="password">PW : </label>
      <input type="password" id="password" name="password" required>
    </div>
    <div>
      <br><input type="submit" value="로그인">
    </div>
  </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String username = request.getParameter("username");
  String password = request.getParameter("password");
  
  String validUsername = "bae";
  String validPassword = "123";

  if (username.equals(validUsername) && password.equals(validPassword)) {
    	session.setAttribute("username", username);
    	response.sendRedirect("main.jsp");
  } else {
	    response.sendRedirect("error.jsp");
  }
%>
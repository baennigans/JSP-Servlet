<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Error</title>
</head>
<body>
  <h2>* 로그인 실패 *</h2>
  <p>ID 또는 PW가 일치하지 않습니다.</p>
  <button onclick="goBack()">돌아가기</button>
  <script>
    function goBack() {
      window.location.href = "login.jsp";
    }
  </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>검사</title>
</head>
<body>
<h2>암호와 수정할 내용을 입력하세요</h2>
<form action="login" method="post">
이메일: <input type="text" name="email" value=<%=request.getParameter("email")%> readonly><br>
암호: <input type="password" name="password"><br>
내용: <input type="text" name="contents" value=<%=request.getParameter("contents")%>><br>
<input type="submit" value="수정">
</form>
</body>
</html>
<%@ page import="value.RecordSet"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>방명록 수정</h1>
<%
ArrayList<RecordSet> records = (ArrayList<RecordSet>)request.getAttribute("records"); 
for(RecordSet record : records) {
%>
<%=record.getEmail() %>,
<%=record.getPwd() %>,
<form action='update' method='post'>
이메일: <input type='text' name='email' value='<%=record.getEmail() %>' readonly><br>
내용: <input type='text' name='contents' value='<%=record.getContents()%>'> <br>
<input type ='submit' value='수정'>
<input type = 'button' value='취소' onclick='location.href="list"'>
</form>
<% }%>
</body>
</html>
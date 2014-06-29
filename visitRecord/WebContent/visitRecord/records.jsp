<%@ page import="value.RecordSet"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 목록</title>
</head>
<body>
<h1>방명록 목록</h1>
<%
ArrayList<RecordSet> records = (ArrayList<RecordSet>)request.getAttribute("records"); 
for(RecordSet record : records) {
%>
<%=record.getEmail() %>,
<%=record.getPwd() %>,
<a href='update?email=<%=record.getEmail()%>&contents=<%=record.getContents()%>'><%=record.getContents()%></a><br>

<%} %>
</body>
</html>
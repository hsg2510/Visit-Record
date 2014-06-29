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
<center>
    <hr width="500" size="2" color="#5DC75D" noshade>
       <h2>방명록 리스트</h2>
    <hr width="500" size="2" color="#5DC75D" noshade>
 </center>
 <table border="1" width="500" align="center"  cellpadding="3" cellspacing="1" 
bordercolor="#5DC75D">
<%
ArrayList<RecordSet> records = (ArrayList<RecordSet>)request.getAttribute("records"); 
for(RecordSet record : records) {
%>
 <tr>
<td><a href='update?email=<%=record.getEmail()%>'> <%=record.getSubject() %></a> </td>
 </tr>

<%} %>
</body>
</html>


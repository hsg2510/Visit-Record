<%@ page import="value.RecordSet"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script language="javascript">
    function check()
    {
   
     //   if(document.input.elements[2].value != "ddd")
     if(document.input.elements[2].value != "ddd")
     {
        alert("모든 값을 입력 하셔야 합니다. ");
        
     return false;
     }
     
     document.input.submit();
    }
 </script>
</head>
<body>
<h1>방명록 수정</h1>
<%
RecordSet record = (RecordSet)request.getAttribute("records"); 
//ArrayList<RecordSet> records = (ArrayList<RecordSet>)request.getAttribute("records"); 
//for(RecordSet record : records) {
%>
<%=record.getEmail() %>,
<%=record.getPwd() %>,
<form action='update' method='post'>
이메일: <input type='text' name='email' value='<%=record.getEmail() %>' readonly><br>
내용: <input type='text' name='contents' value='<%=record.getContents()%>'> <br>
<input type='text' name='password' value='<%=record.getPwd()%>'> <br>
<input type ='submit' value='수정'>
<input type = 'button' value='취소' onclick='location.href="list"'>
</form>
</body>
</html>

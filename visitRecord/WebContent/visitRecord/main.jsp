<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>간단한 방명록</title>
 <script language="javascript">
    function check()
    {
        for(var i=0; i<document.input.elements.length; i++)
     {
        if(document.input.elements[i].value == "")
     {
        alert("모든 값을 입력 하셔야 합니다. ");
     return false;
     }
     }
     document.input.submit();
       }
 </script>
  </head>
  <body>
    <center>
    <hr width="500" size="2" color="#5DC75D" noshade>
       <h2>홍성곤's 방명록</h2>
    <hr width="500" size="2" color="#5DC75D" noshade>
 </center>
<form action='main' method='post'>
    <table border="1" width="500" align="center"  cellpadding="3" cellspacing="1" 

bordercolor="#5DC75D">
    <tr>
       <td align="center">이메일</td>
    <td><input type="text" name="email" size="30"></td>
    </tr>
          <tr>
       <td align="center">비밀번호</td>
    <td><input type="password" name="password" size="10"></td>
    </tr>
    <tr>
       <td align="center">제목</td>
    <td><input type="text" name="subject" size="40"></td>
    </tr>
    <tr>
       <td align="center">글내용</td>
    <td><textarea name="visitRecord" rows="5" cols="40"></textarea></td>
    </tr>
    <tr>
       <td align="center">
       <input type='submit' value='등록'>
    </td>
    </tr>
    </table>
    <br>
    <hr width="500" size="2" color="#5DC75D" noshade>
 </form>
  </body>
</html>
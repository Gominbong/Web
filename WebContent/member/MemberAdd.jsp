 <%@ page import="spms.vo.MemberDTO" %>
 <%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록22</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1>회원등록</h1>
<form action='add.do' method='post'>
이름 : <input type='text' name='name'><br>
이메일 : <input type ='text' name='email'><br>
암호 : <input type = 'text' name='password'><br>
<input type='submit' value='추가'>
<input type='reset' value='입력비우기'>
<input type='button' value='뒤로가기' onclick='location.href="list.do"'>
</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="spms.vo.MemberDTO" %>
 <%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1>회원목록</h1>
<p><a href='add'>신규회원</a></p>
<%-- <%
ArrayList<MemberDTO> members = (ArrayList<MemberDTO>)request.getAttribute("members");
for(MemberDTO member : members){
%><%=member.getNo() %>,<a href='update?no=<%=member.getNo() %>'><%=member.getName() %></a>,
<%=member.getEmail() %>,
<%=member.getCreatedDate() %>
<a href='delete?no=<%=member.getNo() %>'>[삭제]</a><br>
<%} %> --%>
<c:forEach var="member" items="${members}"> 
${member.no},
<a href='update?no=${member.no}'>${member.name}</a>,
${member.email},
${member.createdDate}
<a href='delete?no=${member.no}'>[삭제]</a><br>
</c:forEach>
<jsp:include page="/Tail.jsp"/>
</body>
</html>
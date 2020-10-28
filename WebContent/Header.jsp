<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="spms.vo.MemberDTO" %>
<% 
MemberDTO member = (MemberDTO)session.getAttribute("member");
%>

<div style="background-color: #2EFE2E"; color:#ffffff; height:20px; padding:5px;">
SPMS(Simple Project Management System)
<span style="float:right;">
<%=member.getName() %>
<a style="color:white;" href="<%=request.getContextPath() %>/auth/logout">로그아웃</a>
</span>
</div>
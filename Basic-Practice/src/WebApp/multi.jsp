<%@ page import="com.ll.exam.Rq" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    Rq rq = new Rq(request, response);
    int number = rq.getIntParam("number", 0);
    int limit = rq.getIntParam("limit", 0);
%>

<h1><%=number%>단</h1>

<% for(int i = 1; i <= limit; i++){ %>
<div><%=number%> x <%=i%> = <%=number * i%></div>
<% } %>
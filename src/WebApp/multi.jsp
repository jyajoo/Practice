<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    int number = Integer.parseInt(request.getParameter("number"));
    int limit = Integer.parseInt(request.getParameter("limit"));
%>

<h1><%=number%>단</h1>

<% for(int i = 1; i <= limit; i++){ %>
<div><%=number%> x <%=i%> = <%=number * i%></div>
<% } %>
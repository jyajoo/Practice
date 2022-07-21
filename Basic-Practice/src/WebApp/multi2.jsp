<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    int number = (int) request.getAttribute("number");
    int limit = (int) request.getAttribute("limit");
%>

<h1><%=number%>단</h1>

<% for ( int i = 1; i <= limit; i++ ) { %>
<div><%=number%> * <%=i%> = <%=number * i%></div>
<% } %>
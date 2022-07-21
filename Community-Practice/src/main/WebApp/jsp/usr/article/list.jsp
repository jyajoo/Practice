<%@ page import="Dto.ArticleDto" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
    List<ArticleDto> articleList = (List<ArticleDto>) request.getAttribute("articleList");
%>

<h1>게시물 리스트</h1>
<ul>
    <% for (ArticleDto articleDto : articleList) { %>
    <li><%=articleDto.getId()%>, <%=articleDto.getTitle()%></li>
    <% } %>
</ul>
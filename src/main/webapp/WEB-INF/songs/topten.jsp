<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lookify- Top Ten</title>
</head>
<body>
<h1> Top Ten Songs</h1>
<a href="/dashboard">Dashboard</a>
<table>
    <thead>
        <tr>
            <th>Rating</th>
            <th>Title</th>
            <th>Artist</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${topsongs}" var="s">
        <tr>
          	<td><c:out value="${s.rating}"/></td>
            <td> <a href="/songs/${s.id}"><c:out value="${s.title}"/></a></td>
          	<td><c:out value="${s.artist}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
	
</body>
</html>
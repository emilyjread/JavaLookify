<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Search Results</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<form action="/search" method="POST">
		<label>Search</label>
		<input type="text" name="query"/>
		<input type="submit" value="New Search">
	</form>
	
	<h1>Songs By Artist: <c:out value="${query}"/></h1>
	 <table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${artistsongs}" var="s">
        <tr>
            <td> <a href="/songs/${s.id}"><c:out value="${s.title}"/></a></td>
            <td><c:out value="${s.rating}"/></td>
            <td>
            	<form action="/songs/${s.id}" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <input type="submit" value="Delete"> 
				</form>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
	
</body>
</html>
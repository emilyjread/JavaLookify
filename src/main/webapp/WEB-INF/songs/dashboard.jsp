<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dashboard</title>
</head>
<body>
<h1>Dashboard</h1>
<a href="/songs/new">Add New</a>
<a href="/songs/topten">Top Songs</a>

<form action="/search" method="POST">
	<label>Search</label>
	<input type="text" name="query"/>
	<input type="submit" value="Search">
</form>

<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="s">
        <tr>
            <td> <a href="songs/${s.id}"><c:out value="${s.title}"/></a></td>
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
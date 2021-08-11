<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lookify- Add Song</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>
<h1> Add a Song</h1>
	<form:form action="/songs" method="post" modelAttribute="song">
 
    <p>
        <form:label path="title">Title: </form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="artist">Artist: </form:label>
        <form:errors path="artist"/>
        <form:input path="artist"/>
    </p>
    <p>
        <form:label path="rating">Rating (1-10): </form:label>
        <form:errors path="rating"/>
        <form:input type="number" path="rating"/>
    </p>
  
    <input type="submit" value="Submit"/>
</form:form>   
	
</body>
</html>
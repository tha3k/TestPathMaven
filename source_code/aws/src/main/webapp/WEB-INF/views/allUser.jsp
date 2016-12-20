<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<link rel="stylesheet" href="style.css" type="text/css"/>
<html>
<head>
	<title>All User</title>
</head>
<body>
<div class="container">
	<div id="nav">
		<a href="/geek">Home</a> |
		<a href="/geek">Users</a> |
		<a href="login/">Sign out</a>
		
	</div>
	<h1>All users</h1>
	
	
	<% 
	
		ArrayList allUserList =  (ArrayList)request.getAttribute("allUserList");
		out.print("<ul>");
		for (int i=0;i<allUserList.size();i++) {
			out.print("<li>");
			out.print("<a href=\"/users/14/\">"+allUserList.get(i)+"</a>");
			out.print("</li>");
		}
		
	%>

</div>
</body>
</html>

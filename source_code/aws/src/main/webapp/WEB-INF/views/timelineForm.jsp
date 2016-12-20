<%@page import="th.co.geek.model.Timeline"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<link rel="stylesheet" href="../style.css" type="text/css"/>
<html>
<head>
	<title>Register</title>
	
	<style>
.error {
	color: #ff0000;
}
.container {
	width: 800px;
	margin: 0px auto;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

table.microposts {
	table-layout: fixed;
	width: 700px;
}

table.microposts td {
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
	border-top: 1px solid #ccc;
	vertical-align: top;
	padding-top: 10px;
}

table.microposts td span.timestamp {
	display: block;
	font-size: 85%;
	color: #666;
}
</style>
</head>
<body>
<div class="container">
	<div id="nav">
		<a href="/geek">Home</a> |
		
			<a href="/users/">Users</a> |
			<a href="/logout/">Sign out</a>
		
	</div>
	<h1>Java Mini Twitter</h1>
	

	<p>Welcome boy!
	Here you can store and share bookmarks!</p>
	
	<p>Hi ${timelineForm.userName} !
      What is on your mind?</p>
    <form:form method="POST" commandName="timelineForm">
    <form:hidden path="userName"/>
	<p><label for="id_content">Say it:</label> 
	 <form:textarea path="message" cols="40" rows="5"/></p>
	 <input type="submit" name="Post" />
	
	<table class="microposts">
	
	 <c:forEach items="${timelineForm.userPosts}" var="userPost" >
	  	  <tr>
		    <td colspan="1">
		      <span class="user">
		        <a href="/users/2/">user1</a>
		      </span>
		      	<span class="content">${userPost.postContent}</span>
	 		 	<span class="timestamp">Posted July 6, 2013, 8:57 p.m.</span>
	 		</td>
	 		<td colspan="0">
	 		  <c:if test="${userPost.canDelete == true}"><a href="/microposts/15/delete/">delete</a></c:if>
		    </td>
	 		</tr>
	 </c:forEach>
	 
	
	      
	 </table>
</form:form>	


</div>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <link rel="stylesheet" href="../style.css" type="text/css"/>
<html>
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
</style>
<body>
	<div class="container">
	<div id="nav">
		<a href="/">Home</a> |
		
			<a href="/login/">Sign in</a>
		
	</div>
	<h1>
Registration Completed Successfully
</h1>
	
Thank you for registering. Your information has been
saved in the database. Now you can either
<a href="/geek/login/">login</a> or go back to the
<a href="/">main page</a>.

</div>
</body>
</html>
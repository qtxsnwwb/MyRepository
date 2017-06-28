<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>error</title> 
	<style type="text/css">
	* {
		margin: 0;
		padding: 0;
	}
	body {
		
		background-image: url('images/404.jpg');
		background-size: 100%;  
		background-repeat:no-repeat;
	}
	</style>
</head>
<body>
</body>
</html>
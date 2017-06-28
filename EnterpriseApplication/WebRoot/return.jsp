<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	if(session.getAttribute("user") == null){
		response.sendRedirect("login.jsp");
	}
	request.setCharacterEncoding("UTF-8");
	response.setHeader("refresh", "3,URL=userIndex.jsp");
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8"/>
    <title>投放简历成功</title>
	
	<style type="text/css">
		.box {
			width: 600px;
			height: 250px;
			margin: 0 auto;
			background-color: #e7fbfd; 
			padding-top: 50px;
		}
		p {
			font-size: 20px;
			text-align: center;
		}
	</style>
	
  </head>
  
  <body>
    <div class="box">
    	<p>简历投递成功！</p>
    	<p>3秒后将自动返回首页</p>
    	<p>若未返回，请 <a href="userIndex.jsp">点击</a> 此处</p>
    </div>
  </body>
</html>

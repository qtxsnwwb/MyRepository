<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	if(session.getAttribute("user") == null){
		response.sendRedirect("login.jsp");
	}
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>简历</title>
	<link href="http://js.51jobcdn.com/in/css/2016/base2016.css?20161025" rel="stylesheet" type="text/css" />
	<link href="http://js.51jobcdn.com/in/css/2016/form.css?20170314" rel="stylesheet" type="text/css" />
	<link href="http://js.51jobcdn.com/in/css/2016/panel-pop.css?20161025" rel="stylesheet" type="text/css" />
	<link href="http://js.51jobcdn.com/in/css/2016/imgareaselect.css" rel="stylesheet" type="text/css" />
	<link href="http://js.51jobcdn.com/in/css/2016/step.css?20161025" rel="stylesheet" type="text/css" />
	<link href="css/style2.css" rel="stylesheet" type="text/css"/> 
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"/>
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<script type="text/javascript" > /****添加新条目***/ /******点击添加input输入框JS******/
	function preImg(sourceId, targetId) {
	    if (typeof FileReader === 'undefined') {
	        alert('Your browser does not support FileReader...');
	        return;
	    }
	    var reader = new FileReader();
	
	    reader.onload = function(e) {
	        var img = document.getElementById(targetId);
	        img.src = this.result;
	
	    }
	    reader.readAsDataURL(document.getElementById(sourceId).files[0]);
	}
	
	function update(){
		var formpic = document.getElementById("formpic");
		formpic.submit();
	}

	</script>
</head>
	<body class="declare">
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid"> 
		    <div class="navbar-header">
				<img src="images/images/logo.png" style="height:50px;">
		    </div>
		    <div>
		        <!--向左对齐-->
				<p class="navbar-text navbar-left">个人基本信息</p>
		        <form class="navbar-form navbar-left" role="search">
		            <button type="submit" class="btn btn-default" style="width:100%;">
		               	头像
		            </button>
		        </form>
		        
		        <p class="navbar-text navbar-left">教育背景</p>
		        <p class="navbar-text navbar-left">实习经历</p>
		        <p class="navbar-text navbar-left">校内实践</p>
		        <p class="navbar-text navbar-left">技能证书</p>
		        <p class="navbar-text navbar-left">自我评价</p>
		        <!--向右对齐-->
		
		        <form class="navbar-form navbar-right" role="search">
		            <button type="submit" class="btn btn-default" style="width:100%;">
		               <a href="userIndex.jsp">首页</a>
		            </button>
		        </form>
		
		   		 </div>
			</div>
		</nav>
		<div class="wp Fm">

		<div class="sin">
			<div class="e gp">
			<p class="title t1"><strong>头像</strong></p>
			<div class="form-group col-sm-11">
				<div class="form-group">
					<form action="upload.action" method="post" enctype="multipart/form-data" id="formpic">
			    		<input type="file" name="pic" id="imgOne" onchange="preImg(this.id,'imgPre');" />
			    		<img id="imgPre" src="" style="display: block;" />  
					</form>
					<br/>
					<div class="btm">
						<span class="but" onclick="update()">提交</span>
					</div>
				</div> 
			</div>
			</div>
		</div>
		</div>
	</body>
</html>
		
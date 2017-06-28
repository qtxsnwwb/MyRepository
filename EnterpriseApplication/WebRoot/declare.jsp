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
	<link href="css/style2.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<script type="text/javascript" > /****添加新条目***/ /******点击添加input输入框JS******/
	function checkRowsLimit() 
	{  
	    var rowLimit = 10;  
	    var len=document.getElementById('filearea').rows.length;  
	    if(len==rowLimit)  {   alert('抱歉，为了您主页美观，只能添加这么多条目了。');   return false;  }  
	    else  {   return true;  } 
	}   

	function addNewRow() 
	{  
	    var obj=document.getElementById('filearea');    
	    var row=obj.insertRow(-1);  
	   	var c0=row.insertCell(0);  
	   	/*c0.innerHTML='<input type=text size="3" maxlength=8 name="question" value="" onpropertychange=changeFlagValue()/> ：';  */
	    //c0.align='right';   
	    var c1=row.insertCell(0); 
	    c1.innerHTML='<input class="form-control" type=text size=50 maxlength=50 name="answer" " value="" style="margin-top:10px;"/>';
	    //c1.align='left';    
	    var c2=row.insertCell(2);  
	    c2.innerHTML='<a href="#" onclick="removeRow(this)" style="margin-top:10px;position:">[删除]</a>';  
	    changeFlag = true;
	    try { 
	      comm_set_page_height();  
	    }catch (e){}
	}
    
    function removeRow(fontobj) {  
        if(confirm("确定取消该项吗?")){   
            var obj=document.getElementById('filearea');   
            var n=fontobj.parentNode.parentNode.rowIndex;   
            obj.deleteRow(n);  
        } 
     }  

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
		var person = document.getElementById("person");
		person.submit();
	}
	
	var test;
	function judge1(input){
		test = input
		var message = input.nextElementSibling;
		message.innerHTML = "";
		var x = input.value;  
		try{
			if(x.replace(/\s/g, '') === "") throw "为空!";
		}
		catch(err){
			message.innerHTML ="输入的内容" +err;
			message.style.color = "red";
		}
    }

	function judge_tell(input){
		var message;
		message = document.getElementById("message1");
		message.innerHTML = "";
		var x = input.value;   
		try{
			if(x.replace(/\s/g, '') === "") throw "为空!";
			if(isNaN(x)) throw "不是一串数字!";
		}
		catch(err){
			message.innerHTML ="输入的内容" +err;
			message.style.color = "red";
		}
	}
	
	function judge_mail(input){
		var m_mail;
		m_mail = document.getElementById("message_mail");
		m_mail.innerHTML="";
	  
	  	var x = input.value;
	  	var atpos=x.indexOf("@");
	  	var dotpos=x.lastIndexOf(".");
	  	try{
		   if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length || x.replace(/\s/g,'')=== "" )
		   throw "!";
	  	}catch(err){
		  m_mail.innerHTML = "邮箱格式不正确" +err;
		  m_mail.style.color = "red";
	  	}
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
		
		        <form class="navbar-form navbar-left" role="search">
		            <button type="submit" class="btn btn-default" style="width:100%;">
		                	个人基本信息
		            </button>
		        </form>
		        <p class="navbar-text navbar-left">头像</p>
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
			<p class="title t1"><strong>个人基本信息</strong></p>
			<form action="person.action" method="post" id="person">
				<div class="form-group col-sm-11">
					<label for="name">姓名</label>
					<input type="text" class="form-control" name="name" onblur="judge1(this)" placeholder="请输入">
					<p id="1message"></p>
				</div>
				<br>
						
				<div class="form-group col-sm-11">
					<label for="name">性别</label>
					<div class="radio">				
						<label>
						<input type="radio" name="sex" id="optionsRadios1" value="男" checked> 男  </label>		
						<label>
						<input type="radio" name="sex" id="optionsRadios2" value="女">女</label>
					</div> 
				</div>
		
				<div class="form-group col-sm-11">
					<label for="name">出生日期</label>
					<input type="date" class="form-control" name="date" onblur="Datetest()" placeholder="请输入">
					<p id="messagedate"></p>
				</div>
					
				<div class="form-group col-sm-11">
					<label for="name">身份证号码</label>
					<input type="text" class="form-control" name="idCard" onblur="judge1(this)" placeholder="请输入">
					<p id="2message"></p>
				</div>
					
				<div class="form-group col-sm-11">
					<label for="tel">移动电话</label>
					<input type="text" class="form-control" name="tel" onblur="judge_tell(this)" placeholder="请输入">
					<p id="message1"></p>
				</div>
				<div class="form-group col-sm-11">
					<label for="mail">电子邮箱</label>
					<input type="email" class="form-control" name="mail" onblur="judge_mail(this)" placeholder="请输入">
					<p id="message_mail"></p>
				</div>
				<div class="form-group col-sm-11">
					<label for="pos">意向职位</label>
					<input type="text" class="form-control" name="pos" onblur="judge1(this)" placeholder="请输入">
					<p id="3message"></p>
				</div>
				<div class="form-group col-sm-11">
					<label for="status">政治面貌</label>
					<input type="text" class="form-control" name="status" onblur="judge1(this)" placeholder="请输入">
					<p id="4message"></p>
				</div>
				<div class="form-group col-sm-11">
					<label for="address">住址</label>
					<input type="text" class="form-control" name="address" onblur="judge1(this)" placeholder="请输入">
					<p id="5message"></p>
				</div>
				<div class="form-group col-sm-11">
					<label for="edu">学历</label>
					<input type="text" class="form-control" name="edu" onblur="judge1(this)" placeholder="请输入">
					<p id="6message"></p>
				</div>
			</form>
					
			<div class="btm">
				<span class="but" onclick="update()">提交</span>
			</div>
		</div>
		</div>
		</div> 
	</body>
</html>
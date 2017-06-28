<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>

<link href="css/style.css" rel="stylesheet" type="text/css"/>
<script src="js/jquery.min.js"></script>
<script>
	function changeimg() {
		var img=document.getElementById("pic");
		img.setAttribute('src', "valCode.jsp"+'?'+Math.random());
	}
	
	function execute(){
		var userpwd = $("#userpwd").val();
		var ruserpwd = $("#ruserpwd").val();
		if(userpwd != ruserpwd){
			$("#userpwd").val("");
			$("#ruserpwd").val("");
			$("#error").text("密码两次输入不一致，请重新输入！");
			$("#userpwd").focus();
		}else{
			$("#error").text("");
		}
	}
	
	function validate(){
    	var code = $("#code").val();
    	var flag = false;
    	$.ajax({
    		type:"post",
    		url:"val.jsp",
    		async:false,
    		data:{"code":code},
    		success:function(message){
    			if(message == 2){	
	    			alert("验证失败！");		
					$("#code").val("");
					$("#code").focus();	
    			}
    			if(message == 1){
	    			flag = true;
    			}
    		}
    	});
    	return flag;
    }
</script>
</head>

<body class="login" style="background:url('images/background.png')">

<form action="regUser.action" method="post" onsubmit="return validate()">
<div class="login_m">
<!-- 	<div class="login_logo"><img src="images/logo.png" width="196" height="46"></div> -->
	<div class="login_boder">
		<div class="login_padding">

			<div class="clear"></div>
			<h2>用户名</h2>
			<label>
				<input type="text" name="userName" id="username" class="txt_input txt_input2" onfocus="if (value ==&#39;Your name&#39;){value =&#39;&#39;}" onblur="if (value ==&#39;&#39;){value=&#39;Your name&#39;}" value="Your name">
			</label>

			<h2>密码</h2>
			<label>
				<input type="password" name="userPass" id="userpwd" class="txt_input" onfocus="if (value ==&#39;******&#39;){value =&#39;&#39;}" onblur="if (value ==&#39;&#39;){value=&#39;******&#39;}" value="******">
			</label>
			<br/>
			<div id="error" style="color:red;font-size:12px;"></div>

			<h2>确认密码</h2>
			<label>
				<input type="password" name="re_password" id="ruserpwd" class="txt_input" onfocus="if (value ==&#39;******&#39;){value =&#39;&#39;}" onblur="execute()" value="******">
			</label>


			<h2>验证码</h2>
			<label>
				<input type="text" name="textfield" id="code" class="txt_input3" onfocus="if (value ==&#39;******&#39;){value =&#39;&#39;}" onblur="if (value ==&#39;&#39;){value=&#39;******&#39;}" value="">
				<div class='pic'>
					<img id="pic" src="valCode.jsp"/>
				</div>
			</label>
			<div class="clear"></div>
			<p class="forgot"><a href="javascript:void(0);" onclick="changeimg()">看不清?换一张</a></p>
			<div class="rem_sub">
				<div class="rem_sub_l">
					<input type="checkbox" name="checkbox" id="save_me" value="true"/>
					<label for="checkbox">记住</label>
				</div>
				<label>
					<input type="submit" class="sub_button" name="button" id="button" value="注册" style="opacity: 0.7;"/>
				</label>
			</div>
		</div>
	</div><!--login_boder end-->
</div><!--login_m end-->
</form>

<br />
<br />



</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<%@ page import="com.application.login.action.User" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	User user = (User) session.getAttribute("user");
	if(user == null || user.getRole() != 2){
		response.sendRedirect("login.jsp");
	}
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>设置职位信息</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script>
var test;
function judge1(input)
{
	test = input;
	var message = input.nextElementSibling;
	message.innerHTML = "";
	var x = input.value;  
	try{
		if(x.replace(/\s/g, '') === "") throw "为空!";
		
	}
	catch(err){
		message.innerHTML ="输入的内容" +err;
	}
}

</script>

</head>

<body style="line-height:50px">

    <div id="wrapper" style="margin-left:0px;">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               <img src="images/logo.png" class="navbar-brand" style="width:200px; height:100px">
            </div>
       	</nav>
            <!-- /.navbar-header -->

  		<div class="navbar-default sidebar" role="navigation" style="margin-top: 100px;z-index:1;">
      			<!-- 侧栏 -->
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        
                        <li>
                            <a href="showPos.jsp"><i class="fa fa-dashboard fa-fw"></i>显示职位</a>
                        </li>
                        
                        <li>
                            <a href="addPos.jsp"><i class="fa fa-table fa-fw"></i>新建职位</a>
                        </li>
                        <li>
                            <a href="checkApp.jsp"><i class="fa fa-edit fa-fw"></i> 查看简历</a>
                        </li>
                        <li>
                            <a href="index.html"><i class="fa fa-home fa-fw"></i> 返回首页</a>
                        </li>
                    </ul>
                </div>
                <img src="images/pic1.png" style="margin-top: 1150px;margin-left: 0px;">
  		</div>
	 </div>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">招聘信息</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row" >
                <div class="col-lg-12" style="width:1000px">
                    <div class="panel panel-default">
                        <div class="panel-body" style="width:900px" >
                            
                                   <div class="form-group col-sm-11" >
                                        
                                        <form action="job.action" method="post">
                                        
	                                        <label for="name"><code>*</code>职位名称</label>
	                                        <input type="text" id="name" class="form-control" name="jname" onblur="judge1(this)"
	                                        placeholder="请输入">
	                                        <p id="1message" style="color:red"></p>
	                                        
	                                        <label for="name"><code>*</code>所属部门</label>
	                                        <input type="text" id="name" class="form-control" name="partment" onblur="judge1(this)"
	                                        placeholder="请输入">
	                                        <p id="1message" style="color:red"></p>
	                                        
	                                        <label for="name"><code>*</code>工作性质</label>
	                                        <input type="text" id="name" class="form-control" name="worktype" onblur="judge1(this)"
	                                        placeholder="请输入">
	                                        <p id="1message" style="color:red"></p>
	                                        
	                                        <label for="name"><code>*</code>月薪范围</label>
	                                        <input type="text" id="name" class="form-control" name="salary" onblur="judge1(this)"
	                                        placeholder="请输入">
	                                        <p id="1message" style="color:red"></p>
	                                        
	                                        <label for="name"><code>*</code>学历要求</label>
	                                        <input type="text" id="name" class="form-control" name="jedu" onblur="judge1(this)"
	                                        placeholder="请输入">
	                                        <p id="1message" style="color:red"></p>
	                                        
	                                        <label for="name"><code>*</code>招聘人数</label>
	                                        <input type="text" id="name" class="form-control" name="pnum" onblur="judge1(this)"
	                                        placeholder="请输入">
	                                        <p id="1message" style="color:red"></p>
	                                        
	                                        <label for="name"><code>*</code>联系人</label>
	                                        <input type="text" id="name" class="form-control" name="jperson" onblur="judge1(this)"
	                                        placeholder="请输入">
	                                        <p id="1message" style="color:red"></p>
	                                        
	                                        <label for="name"><code>*</code>手机</label>
	                                        <input type="text" id="name" class="form-control" name="jtel" onblur="judge1(this)"
	                                        placeholder="请输入">
	                                        <p id="1message" style="color:red"></p>
	                                        
	                                        <label for="name"><code>*</code>邮箱</label>
	                                        <input type="text" id="name" class="form-control" name="jmail" onblur="judge1(this)"
	                                        placeholder="请输入">
	                                        <p id="1message" style="color:red"></p>
	                                        
	                                        
	                                        <label for="name"><code>*</code>详细信息</label>
	                                        <textarea class="form-control" rows="5" name="message"></textarea>
	                                        
	                                        <button type="submit" class="btn btn-default">提交</button>
                                        </form>
                                   </div>
				
                        </div>
                    </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
  	</div>
            
    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

</body>

</html>

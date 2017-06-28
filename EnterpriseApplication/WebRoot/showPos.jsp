<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<%@ page import="com.application.login.action.User" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

    <title>查看简历</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript">
    $("document").ready(function(){
    	var listfirst = $("#listfirst").text();
    	if(listfirst.length == 0){
    		$("#refresh").click();
    	}
    	
    	var a=false;
		$("span").click(function(){
		  	if(a==false){
			    $(this).parents("tr").next().children().css("display","block");
			    a=true;
		    }else{
			    $(this).parents("tr").next().children().css("display","none");
			    a=false;
		    }
		 });
    });
    
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
                <img src="images/pic1.png" style="margin-top: 500px;margin-left: 0px;">
  </div>
 </div>


         <!-- Page Content -->       
 		<div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">显示职位</h1>
                        
                    </div>
                    
                    <form action="checkjob.action" method="post" style="margin:20px;">
                    	<input type="text" name="checkmess" placeholder="请输入职位名称..." style="height:35px;"/>&nbsp;&nbsp;
                    	<input type="submit" value="查询" class="btn btn-default">
                    	<a href="consultjob!checkJob.action" style="margin:20px;"><span id="refresh" style="display:none;">刷新</span></a>
                    </form>
                    
                    <!-- /.col-lg-12 -->
                    <table class="table table-striped">
            <thead>
            <tr>
	            <th>职位</th>
	            <th>所属部门</th>
	            <th>学历要求</th>
	            <th>月薪范围</th>
	            <th>招聘人数</th>
	            <th>更新时间</th>
            </tr>
            </thead>
            <tbody>
	            <s:iterator value="list" id="joblist" status="st">
			     	 <tr <s:if test="#st.odd">style="background-color:#e1eae6"</s:if>>
				       	<td id="listfirst">${joblist.jname }</td>
				        <td>${joblist.partment }</td>
				        <td>${joblist.jedu }</td>
				        <td>${joblist.salary }</td>
				        <td>${joblist.pnum }</td>
				        <td>
				        	${joblist.jdate }
				        	<span style="margin-left: 100px;margin-right: 20px;">
				        		<a>更多</a>
				        	</span>
				        	<a href="consultjob!delJob.action?id=<s:property value="id"/>" id="delete">删除</a>
				        </td>
			         </tr>
			         <tr>
            			<td style="display: none;" colspan="2">
            				工作性质：${joblist.worktype }
            			</td>
            			<td style="display: none;" colspan="2">
            				联系人：${joblist.jperson }
            			</td>
            			<td style="display: none;" colspan="2">
            				手机：${joblist.jtel }
            			</td>
            			<td style="display: none;" colspan="2">
            				邮箱：${joblist.jmail }
            			</td>
            			<td style="display: none;" colspan="4" rowspan="4">
            				详细信息：${joblist.message }
            			</td>
            		</tr>      
	            </s:iterator>
            </tbody>
            </table>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

</body>

</html>
    
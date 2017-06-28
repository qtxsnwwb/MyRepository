<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
    <script type="text/javascript">
    $("document").ready(function(){
    	var listfirst = $("#listfirst").text();
    	if(listfirst.length == 0){
    		$("#refresh").click();
    	}
		 
		 $("span").click(function(){
		 	$(".content").css("display","none");
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
                        <h1 class="page-header">查看简历</h1>
                    </div>
                    
                    <a href="consultapp!checkApp.action"><span id="refresh" style="display:none;">刷新</span></a>
                    
                    <div class="btn-group">
					    <button type="button" class="btn btn-default">筛选</button>
					    <button type="button" class="btn btn-default dropdown-toggle" 
					            data-toggle="dropdown">
					        <span class="caret"></span>
					        <span class="sr-only">切换下拉菜单</span>
					    </button>
					    <ul class="dropdown-menu" role="menu">
					        <li><a href="consultapp!orderDate.action">按出生日期排序</a></li>
					        <li><a href="consultapp!orderEdu.action">按学历排序</a></li>
					        <li><a href="consultapp!orderPos.action">按意向职位排序</a></li>
					    </ul>
					</div>
                    
	    			

	    
                    
                    
                    <!-- /.col-lg-12 -->
                    <table class="table table-striped">
			            <thead>
				            <tr>
					            <th>姓名</th>
					            <th>性别</th>
					            <th>出生日期</th>
					            <th>政治面貌</th>
					            <th>学历</th>
					            <th>意向职位</th>
				            </tr>
			            </thead>
			            <tbody>
			            	<s:iterator value="list" id="personlist" status="st">
					            <tr <s:if test="#st.odd">style="background-color:#e1eae6"</s:if>>
						            <td id="listfirst">${personlist.name }</td>
						            <td>${personlist.sex }</td>
						            <td>${personlist.date }</td>
						            <td>${personlist.status }</td>
						            <td>${personlist.edu }</td>
						            <td>
						            	${personlist.pos }
						            	<span style="margin-left: 100px;margin-right: 20px;">
							        		<a href="consultapp!getWholeAppMessage.action?id=<s:property value="id"/>">更多</a>
							        	</span>
							        	<span>
							        		<a>隐藏</a>
							        	</span>
							        	
						            </td>
						            <s:iterator value="elist" id="edulist">
						            <s:iterator value="plist" id="pralist">
						            <s:iterator value="shlist" id="shplist">
						            <s:iterator value="sklist" id="skilist">
						            <s:iterator value="selist" id="sellist">
						            <tr class="content">
				            			<td style="border:4px outset #b9c5c4">身份证号码：${personlist.idCard }</td>
				            			<td style="border:4px outset #b9c5c4">电话：${personlist.tel }</td>	
				            			<td style="border:4px outset #b9c5c4">邮箱：${personlist.mail }</td>
				            			<td style="border:4px outset #b9c5c4">住址：${personlist.address }</td>
				            		</tr>
				            		<tr class="content">
				            			<td style="border:4px outset #b9c5c4">毕业时间：${edulist.endTime }</td>
				            			<td style="border:4px outset #b9c5c4">学校：${edulist.school }</td>
				            			<td style="border:4px outset #b9c5c4">专业：${edulist.major }</td>
				            			<td style="border:4px outset #b9c5c4">学位：${edulist.degree }</td>
				            			<td style="border:4px outset #b9c5c4">主修课程：${edulist.subject }</td>
				            		</tr>
				            		<tr class="content">
				            			<td style="border:4px outset #b9c5c4">实习单位：${pralist.porgan }</td>
				            			<td style="border:4px outset #b9c5c4">实习岗位：${pralist.ppos }</td>
				            			<td style="border:4px outset #b9c5c4">实习内容：${pralist.pcontent }</td>
				            		</tr>
				            		<tr class="content">
				            			<td style="border:4px outset #b9c5c4">实践单位：${shplist.sorgan }</td>
				            			<td style="border:4px outset #b9c5c4">实践职务：${shplist.sduty }</td>
				            			<td style="border:4px outset #b9c5c4">实践内容：${shplist.scontent }</td>
				            		</tr>
				            		<tr class="content">
				            			<td colspan="4" rowspan="4" style="border:4px outset #b9c5c4">技能证书：${skilist.skcontent }</td>
				            		</tr>
				            		<tr class="content">
				            			<td colspan="4" rowspan="4" style="border:4px outset #b9c5c4">自我评价：${sellist.secontent }</td>
				            		</tr>
			            			</s:iterator>
			            			</s:iterator>
			            			</s:iterator>
			            			</s:iterator>
			            			</s:iterator>
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

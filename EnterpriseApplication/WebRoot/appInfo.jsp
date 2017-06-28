<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page errorPage="error.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	if(session.getAttribute("user") == null){
		response.sendRedirect("login.jsp");
	}
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>职位投递</title>

	<link href="css/style.css" rel="stylesheet" type="text/css"/> 
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"/>  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
<body>
<nav class="navbar navbar-default" role="navigation" style="margin-bottom:0;">
	<div class="container-fluid"> 
    <div class="navbar-header">
<!--         <a class="navbar-brand" href="#">菜鸟教程</a> -->
		<img src="images/logo.png" style="height:50px;"/>
    </div>
    <div>
        <!--向左对齐-->

		<form class="navbar-form navbar-left" role="search">
            <button type="submit" class="btn btn-default" >
                	职位信息
            </button>
        </form>
        <p class="navbar-text navbar-left"><a href="declare.jsp">简历投递</a></p>

        <!--向右对齐-->

        <form class="navbar-form navbar-right" role="search">
            <button type="submit" class="btn btn-default">
               <a href="userIndex.jsp">首页</a>
            </button>
        </form>

   	</div>
	</div>
</nav>

	<img src="images/pic2.png" style="width: 100%;"/>
	<div class="container" style="width:70%;maigin:0 auto;">
	<h2>职位信息</h2>
	
	<form action="showjob.action" method="post" style="margin:20px;">
      	<input type="text" name="checkmess" placeholder="请输入职位名称..." style="height:35px;"/>&nbsp;&nbsp;
        <input type="submit" value="查询" class="btn btn-default"/>
        <a href="showjob!checkJob.action" style="margin:20px;"><span id="refresh" style="display:none;">刷新</span></a>
    </form>
                    
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

        </body>
</html>
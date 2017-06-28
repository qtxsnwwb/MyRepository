<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String code = request.getParameter("code");
	String sessionCode = session.getAttribute("valcode").toString();
	if(code.equals(sessionCode)){
		out.print(1);
	}else{
		out.print(2);
	}
%>


<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.application.validate.util.*" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	response.setContentType("image/jpeg");
	
	String[] codes = {"温文尔雅","风花雪月","谦谦君子","礼贤下士","闻鸡起舞","凿壁偷光","囊萤映雪","悬梁刺股"};
	String code = codes[new Random().nextInt(8)];
	BufferedImage buf = ValidateCodeUtil.getValidateCode(code);
	session.setAttribute("valcode", code);
	ImageIO.write(buf, "jpeg", response.getOutputStream());
	out.clear();
	out = pageContext.pushBody();
%>


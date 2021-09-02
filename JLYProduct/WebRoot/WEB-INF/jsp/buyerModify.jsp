<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Cookie[] cookies = request.getCookies();
	String loginName = "";
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("LOGINNAME")) {
			loginName = cookie.getValue();
		}
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'buyerModify.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form  method="post" action="product/modify.action" enctype="multipart/form-data">
  
    <input type="hidden" id="u_username" name="u_username"  value="${userInfo.u_username} "> <br>
    <input type="password" id="u_password" name="u_password" value="${userInfo.u_password}"> <br>
    <input type="text" id="u_nickname" name="u_nickname" value="${userInfo.u_nickname}"> <br>
    <img alt="" src="${userInfo.u_head_old }"><br/>
    <input type="file" id="u_head" name="u_head" > <br>
    <input type="submit" value="修改"> <br>
    <a href="product/toAddressMenager.action?username=<%=loginName %>">管理地址 </a>
  
  </form>
  
  </body>
</html>

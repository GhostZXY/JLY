<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'toAddressAdd.jsp' starting page</title>
    
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
    <form method="post" action="product/addressAdd.action">
    	地址<input type="text" id="a_address" name="a_address">
    	电话<input type="text" id="a_tel" name="a_tel">
    	收件人<input type="text" id="a_name" name="a_name">
    	是否默认<input type="radio" id="a_default" name="a_default">是
    	<input type="radio" id="a_default" name="a_default">否
    	<input type="submit" value="保存地址">
    </form> <br>
  </body>
</html>

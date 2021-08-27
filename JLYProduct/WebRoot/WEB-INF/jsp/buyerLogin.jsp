<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'buyerLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery-3.0.0.js" type="text/javascript"></script>
	<script type="text/javascript" >
		$(function(){
			$("#login_btn").click(function(){
				var username = $("#u_username").val();
				var password = $("#u_password").val();
				$.ajax({
					url:"product/login.action",
					data:{
						"u_username":username,
						"u_password":password
					},
					success:function(result){
						if(result =="success"){
							window.location.href="product/buyerhome.action"
						}else{
							$(".tip").html("登录失败")
						}
					}
				
				})
			})
		})
	</script>
  </head>
  
  <body>
   		
   		<input type="text" name="u_username" id="u_username"><br/>
   		<input type="text" name="u_password" id="u_password"><br/>
   		<input type="button" id="login_btn" value="登录"><br/>
   		<a href="product/register.action">注册</a>
			
   		<span class="tip"></span>
  </body>
</html>

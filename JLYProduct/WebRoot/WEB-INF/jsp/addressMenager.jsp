<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addressMenager.jsp' starting page</title>
    
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
  	
    <table>
    	<tr><th>地址</th><th>电话</th><th>收件人</th><th>是否默认</th><th>删除</th></tr>
    	<c:forEach items="${addressList}" var="address">
    	<tr>
    		<td>
    			${address.a_address}
    		</td>
    		<td>
    			${address.a_tel}
    		</td>
    		<td>
    			${address.a_name}
    		</td>
    		<td>
    			<c:if test="${address.a_isdefault=='1'}">
    			   	<button disabled="disabled">设为默认</button>
    			</c:if>
				<c:if test="${address.a_isdefault=='0'}">
    			   	<a href="product/setDefault.action?a_id=${address.a_id}&u_id=${address.u_id}" >设为默认</a>	
    			</c:if>
    		</td>
    		<td>
    			<a href="product/AddressDel.action?a_id=${address.a_id}">删除</a>
    		</td>
    	</tr>
    	</c:forEach>
       </table>
        <a href="product/toAddressAdd.action">添加</a>
  </body>
</html>

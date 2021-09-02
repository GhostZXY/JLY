<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'sellerHome.jsp.jsp' starting page</title>

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
	
	<h1>我的店铺</h1>
	<table>
		<tr>
			<th>商品名</th>
			<th>商品价格</th>
			<th>商品产地</th>
			<th>商品详情</th>
			<th>商品库存</th>
			<th>操作</th>
		</tr>
		
		<c:forEach items="${productList}" var="product"> 
			<tr>
				<td>${product.p_name}</td>
				<td>${product.p_price}</td>
				<td>${product.p_local}</td>
				<td>${product.p_info}</td>
				<td>${product.p_inventory}</td>
				<td>
					
						<c:if test='${product.p_status=="1"}'>
							<button>下架</button> 
						</c:if> 
						<c:if test='${product.p_status=="0"}'>
							<button>上架</button>
						</c:if> 
					
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="#">添加商品</a>
		
			
</body>
</html>

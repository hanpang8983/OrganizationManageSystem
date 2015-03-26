<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'pager.jsp' starting page</title>

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


	<pg:pager items="${param.items }" url="${param.url }" maxPageItems="${10 }"
		export="currentPageNumber=pageNumber">
		
		<pg:first>
			<a href="${pageUrl}">首页</a>
		</pg:first>
		<pg:prev>
			<a href="${pageUrl }">上一页</a>
		</pg:prev>
		<pg:pages>
			<c:choose>
				<c:when test="${currentPageNumber eq pageNumber}">
					<font color="red">${pageNumber }</font>
				</c:when>
				<c:otherwise>
					<a href="${pageUrl }">${pageNumber }</a>
				</c:otherwise>
			</c:choose>
		</pg:pages>
		<pg:next>
			<a href="${pageUrl }">下一页</a>
		</pg:next>
		<pg:last>
			<a href="${pageUrl }">尾页</a>
		</pg:last>
	</pg:pager>


</body>
</html>

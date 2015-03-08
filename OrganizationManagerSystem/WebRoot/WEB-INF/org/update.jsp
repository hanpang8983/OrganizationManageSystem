<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>更新机构</title>
<link href="style/css/oa.css" rel="stylesheet" type="text/css">
<script>
    	function cancelUpdate(parentId) {
    		window.location="org_toIndex.action?orgId="+parentId;
    		alert("不加alert,请求跳转不过去，不知道为什么。");
    	}
    </script>
</head>
<body>

	<jsp:include page="../common/_header.jsp"></jsp:include>

	<div class="content">
		<div class="content">
			<div class="org-wrap">
				<div class="menu-title">
					<span>组织管理</span>
					<hr class="hr" />
				</div>
				<div class="org-add">
					<div class="add">
						<span><a href="javascript:history.go(-1)">返回</a></span>
					</div>
				</div>
				<div class="org-data">
					<c:if test="${!empty org }">


						<form action="org_update.action" method="post" class="add-input">
							<input type="hidden" name="parentId" value="${parentId }" />
							<input type="hidden" name="org.id" value="${org.id }" /> 
							<input type="text" name="org.name" placeholder="${org.name }" class="input-add-org" /><br /> 
							<input type="text" name="org.description" placeholder="${org.description }" class="input-add-org" /><br /> 
							<input type="submit" value="保 存" class="btn-add-org-right" />
							<button class="btn-add-org-waring" onclick="cancelUpdate(${parentId })">取 消</button>
						</form>


					</c:if>
				</div>
			</div>
		</div>

		<jsp:include page="../common/_footer.jsp"></jsp:include>
</body>
</html>
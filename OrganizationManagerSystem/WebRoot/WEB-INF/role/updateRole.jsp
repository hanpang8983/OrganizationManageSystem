<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>更新角色</title>

</head>
<body>

	<jsp:include page="../common/_header.jsp"></jsp:include>

	<!--start content-->
	<div class="content">
		<div class="content">
			<div class="org-wrap">
				<div class="menu-title">
					<span>更新角色</span>
					<hr class="hr" />
				</div>
				<div class="org-add">
					<div class="add">
						<span><a href="javascript:history.go(-1)">返回</a></span>
					</div>
				</div>
				<div class="org-data">
					<form action="role_updateRole.action" method="post"
						class="add-input">
						<c:if test="${!empty role }">
							<input type="hidden" name="role.id" value="${role.id }" />
							<input type="text" name="role.name" placeholder="${role.name }" class="input-add-org" />
							</br>
						</c:if>
						<input type="submit" value="保 存" class="btn-sub" />

					</form>
				</div>
			</div>
		</div>
		<!--end content-->

		<jsp:include page="../common/_footer.jsp"></jsp:include>
</body>
</html>
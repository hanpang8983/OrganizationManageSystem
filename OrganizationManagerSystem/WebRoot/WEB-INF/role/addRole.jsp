<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>添加角色</title>

</head>
<body>

	<jsp:include page="../common/_header.jsp"></jsp:include>

	<!--start content-->
	<div class="content">
		<div class="content">
			<div class="org-wrap">
				<div class="menu-title">
					<span>添加角色</span>
					<hr class="hr" />
				</div>
				<div class="org-add">
					<div class="add">
						<span><a href="javascript:history.go(-1)">返回</a></span>
					</div>
				</div>
				<div class="org-data">
					<form action="role_addRole.action" method="post" class="add-input">
						<input type="text" name="role.name" placeholder="角色名称"
							class="input-add-org" /></br> 
							
						<input type="submit" value="保 存" class="btn-sub" />
					</form>
				</div>
			</div>
		</div>
		<!--end content-->

		<jsp:include page="../common/_footer.jsp"></jsp:include>
</body>
</html>
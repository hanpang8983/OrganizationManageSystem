<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>添加机构</title>
<link href="style/css/oa.css" rel="stylesheet" type="text/css">
<script>
	    function toIndex() {
			window.location="org_toIndex.action?orgId="+0;
			alert("不知道为什么");
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
					<form action="org_add.action" method="post" class="add-input">
						<input type="hidden" name="orgId" value="${orgId }" /> 
						<input type="text" name="org.name" placeholder="机 构 名 称" class="input-add-org" /><br /> 
						<input type="text" name="org.description" placeholder="机 构 描 述" class="input-add-org" /><br /> 
						<input type="submit" value="保 存" class="btn-add-org-right" />
						<button class="btn-add-org-waring" onclick="toIndex();">取 消</button>
					</form>
				</div>
			</div>
		</div>

		<jsp:include page="../common/_footer.jsp"></jsp:include>
</body>
</html>
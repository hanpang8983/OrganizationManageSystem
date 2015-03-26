<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>用户首页</title>
<jsp:include page="../common/_dwr.jsp"></jsp:include>

<script type="text/javascript">
	
	function distributeAccount(id) {
		window.location = "user_toDistributeAccount.action?person.id=" + id;
	}
	
	function deleteAccount(id, name) {
		if(confirm("确认删除账号: "+name+" ？")) {
			window.location="user_deleteAccount?user.id=" + id;
		}else {
    		return false;
    	}
	}
	
	function updateAccount(id) {
		window.location = "user_toUpdateAccount?user.id=" + id;
	}
	
</script>
</head>
<body>

	<jsp:include page="../common/_header.jsp"></jsp:include>

	<!--start content-->
	<div class="content">
		<div class="org-wrap">
			<div class="menu-title">
				<span>用户管理</span>
				<hr class="hr" />
			</div>
			<div class="org-add"></div>
			<div class="org-data">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>序号</th>
							<th>姓名</th>
							<th>所在机构</th>
							<th>登陆账号</th>
							<th>失效时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${!empty pm.datas }">
							<c:forEach items="${pm.datas }" var="pm">

								<tr>
									<td>${pm.id }</td>
									<td>${pm.name }</td>
									<td>${pm.organization.name }</td>
									<td>${pm.user.name }</td>
									<td>${pm.user.expireTime }</td>
									<td>
										<center>
										<button class="label label-primary" onclick="distributeAccount(${pm.id })">分配账号</button>
										<button class="label label-danger" onclick="deleteAccount(${pm.id }, '${pm.user.name }')">删除账号</button>
										<button class="label label-warning" onclick="updateAccount(${pm.user.id })">修改账号</button>
										<button class="label label-info">分配角色</button>
										<button class="label label-success">用户授权</button>
										<%-- 	
											<a href="user_toDistributeAccount.action?person.id=${pm.id }">分配账号</a> 
											<a href="javascript:void(0);" onclick="deleteAccount(${pm.user.id }, '${pm.user.name }');">删除账号</a> 
											<a href="user_toUpdateAccount.action?user.id=${pm.user.id }">修改账号</a>
											<a href="#">分配角色</a> 
											<a href="#">用户授权</a> 
										--%>
										</center>
									</td>
								</tr>

							</c:forEach>
						</c:if>

					</tbody>
				</table>
			</div>

			<div class="pager">
				<jsp:include page="../common/_pager.jsp">  
				    <jsp:param value="user_toIndex.action" name="url"/>  
				    <jsp:param value="${pm.total }" name="items"/>  
				</jsp:include>
			</div>

		</div>
	</div>
	<!--end content-->

	<jsp:include page="../common/_footer.jsp"></jsp:include>

</body>
</html>
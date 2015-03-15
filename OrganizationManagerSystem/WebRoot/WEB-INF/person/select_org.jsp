<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>选择机构</title>
<link href="style/css/oa.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
    	
    	function selectEnd(id, name) {
    		
    		window.opener.document.all.orgId.value = id;
    		window.opener.document.all.orgName.value = name;
    		window.close();
    	}
    </script>
</head>
<body>


	<!--start content-->
	<div class="content">
		<div class="org-wrap">
			<div class="menu-title">
				<span>选择机构</span>
				<hr class="hr" />
			</div>
			<div class="org-add">
				<div class="add">

					<span><a href="person_selectOrg.action">返回</a></span>
				</div>
			</div>
			<div class="org-data">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>选择</th>
							<th>序号</th>
							<th>机构名称</th>
							<th>机构描述</th>
							<th>父机构名称</th>
						</tr>
					</thead>
					<tbody>

						<c:if test="${!empty orgList }">
							<c:forEach items="${orgList }" var="org">

								<tr>
									<td><input type="radio" name="orgId" value="${org.id }"
										onclick="selectEnd(${org.id }, '${org.name }')" /></td>
									<td>${org.id }</td>
									<td><a href="person_selectOrg.action?orgId=${org.id }">${org.name }</a></td>
									<td>${org.description }</td>
									<td>${org.parent.name }</td>

								</tr>

							</c:forEach>
						</c:if>

						<c:if test="${empty orgList }">


						</c:if>


					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!--end content-->

</body>
</html>
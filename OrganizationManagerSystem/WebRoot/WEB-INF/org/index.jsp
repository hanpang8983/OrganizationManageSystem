<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>机构管理</title>
    <script>
        function updateOrg(id, parentId) {
        	window.location="org_toUpdate.action?orgId="+id+"&&parentId="+parentId;
        }
        function deleteOrg(id, parentId,name) {
        	if(confirm("确认删除机构: "+name+" ？")) {
        		window.location="org_delete.action?orgId="+id+"&&parentId="+parentId;
        	}else {
        		return false;
        	}
        }
    </script>
</head>
<body>


<jsp:include page="../common/_header.jsp"></jsp:include>

<!--start content-->
<div class="content">
    <div class="org-wrap">
        <div class="menu-title">
            <span>组织管理</span>
            <hr class="hr"/>
        </div>
        <div class="org-add">
            <div class="add">
                <span><a href="org_toAdd.action?orgId=${orgId }">添加机构信息</a></span>
                <span><a href="org_toIndex.action?orgId=${0 }">返回</a></span>
            </div>
        </div>
        <div class="org-data">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>序号</th><th>机构名称</th><th>机构描述</th><th>父机构名称</th><th>操作</th>
                    </tr>
                </thead>
                <tbody>
                
                <c:if test="${!empty orgList }">
                	<c:forEach items="${orgList }" var="org">
                	
                	<tr>
                        <td>${org.id }</td><td><a href="org_toIndex.action?orgId=${org.id }">${org.name }</a></td><td>${org.description }</td><td>${org.parent.name }</td>
                        <td>
                        <center>
                            <button class="label label-success" onclick="updateOrg(${org.id }, ${orgId })">更新</button>
                            <button class="label label-danger" onclick="deleteOrg(${org.id }, ${orgId } , '${org.name }')">删除</button>
                        </center>
                        </td>
                    </tr>
                	
                	</c:forEach>
                </c:if>
                
                
                
                    
                </tbody>
            </table>
        </div>
    </div>
</div>
<!--end content-->

<jsp:include page="../common/_footer.jsp"></jsp:include>

</body>
</html>
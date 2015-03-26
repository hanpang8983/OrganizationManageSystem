<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>角色首页</title>
    <script type="text/javascript">
    	function role_toUpdateRole(id) {
    		window.location = "role_toUpdateRole.action?role.id=" + id;
    	}
    	function role_deleteRole(id, name) {
    		if(confirm("确认删除角色: "+name+" ？")) {
    			window.location="role_deleteRole?role.id=" + id;
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
            <span>角色管理</span>
            <hr class="hr"/>
        </div>
        <div class="org-add">
			<div class="add">
                <span><a href="role_toAddRole.action">添加角色信息</a></span>
            </div>
        </div>
        <div class="org-data">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>序号</th><th>角色名称</th><th>相关操作</th>
                    </tr>
                </thead>
                <tbody>
                
                <c:if test="${!empty roleList }">
				<c:forEach items="${roleList }" var="role">              
                    <tr>
                        <td>${role.id }</td><td>${role.name }</td>
                        <td>
                            <center>
                            <button class="label label-success" onclick="role_toUpdateRole(${role.id })">更新角色信息</button>
                            <button class="label label-danger"  onclick="role_deleteRole(${role.id }, '${role.name }')">删除角色</button>
                            <button class="label label-info">角色授权</button>
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
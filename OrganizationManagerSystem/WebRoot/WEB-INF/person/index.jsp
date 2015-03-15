<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>人员管理</title>
    <link href="style/css/oa.css" rel="stylesheet" type="text/css">
    <script>
        function toUpdate(id) {
        	window.location = "person_toUpdate.action?person.id=" + id;
        	
        }
        
		function deletePerson(id, name) {
        	if(confirm("确认删除人员: "+name+" ？")) {
        		window.location="person_delete.action?person.id="+id;
        		
        		return;
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
            <span>人员管理</span>
            <hr class="hr"/>
        </div>
        <div class="org-add">
            <div class="add">
                <span><a href="person_toAdd.action">添加人员信息</a></span>
                <span><a href="person_toIndex.action">返回</a></span>
            </div>
        </div>
        <div class="org-data">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>序号</th><th>姓名</th><th>性别</th><th>职务</th><th>生日</th>
                        <th>家庭地址</th><th>电话</th><th>所属机构</th><th>操作</th>
                        
                    </tr>
                </thead>
                <tbody>
                
                <c:if test="${!empty personList }">
                <c:forEach items="${personList }" var="person">
                
                    <tr>
                        <td>${person.id }</td><td>${person.name }</a></td><td>${person.sex }</td><td>${person.duty }</td>
                        <td>${person.birthday }</td><td>${person.address }</td><td>${person.phone }</td><td>${person.organization.name }</td>
                        <td>
                            <button class="btn-org-update" onclick="toUpdate(${person.id })">更新</button>
                            <button class="btn-org-delete" onclick="deletePerson(${person.id }, '${person.name }')">删除</button>
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
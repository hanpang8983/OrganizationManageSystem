<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>模块首页</title>
    
</head>
<body>

<jsp:include page="../common/_header.jsp"></jsp:include>

<!--start content-->
<div class="content">
    <div class="org-wrap">
        <div class="menu-title">
            <span>模块管理</span>
            <hr class="hr"/>
        </div>
        <div class="org-add">
			<div class="add">
                <span><a href="org_toAdd.action?orgId=${orgId }">添加模块信息</a></span>
                <span><a href="org_toIndex.action?orgId=${0 }">返回</a></span>
            </div>
        </div>
        <div class="org-data">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>序号</th><th>模块名称</th><th>父模块名称</th><th>模块地址</th><th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td><td>组织模块</td><td>权利最大的机构</td><td>user_toIndex.acthion</td>
                        <td>
                            <center>
                            <button class="label label-success">更新</button>
                            <button class="label label-danger">删除</button>
                            
                            </center>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!--end content-->

<jsp:include page="../common/_footer.jsp"></jsp:include>

</body>
</html>
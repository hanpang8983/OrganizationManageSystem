<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link href="style/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="style/css/oa.css" rel="stylesheet" type="text/css">
</head>
<body>

<!--start header-->
<div class="header">
    <div class="wrap">
        
        <div class="logo">
            <a href="index.jsp">
                <img src="style/img/logo.png" />
            </a>
        </div><div class="menu">
            <ul>
                <li><a href="org_toIndex.action?orgId=${0 }">组织管理</a></li>
                <li><a href="person_toIndex.action">人员管理</a></li>
                <li><a href="user_toIndex.action">用户管理</a></li>
                <li><a href="role_toIndex.action">角色管理</a></li>
                <li><a href="module_toIndex.action">模块管理</a></li>
            </ul>
        </div>
    </div>
</div>
<!--end header-->



</body>
</html>
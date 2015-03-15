<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link href="style/css/oa.css" rel="stylesheet" type="text/css">
</head>
<body>



<div class="login">
    <div class="content">
        <h1>Organization Manager</h1>
        <form action="user_toIndex.action" method="post" class="form-login">
            <input type="text" name="user.username" id="username" placeholder="账 号" class="input-login"/><br/>
            <input type="password" name="user.userpass" id="userpass" placeholder="密 码" class="input-login" /><br/>
            <input type="submit" value="登 陆" class="btn-sub" />
        </form>
    </div>
</div>

<!-- start footer -->
<div class="footer">
    <p>Copyright &copy; 2014.<a href="http://www.isunmoon.com">ISUNMOON</a> All rights reserved.</p>
</div>
<!-- end footer -->



</body>
</html>
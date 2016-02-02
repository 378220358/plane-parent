<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/1/28
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/modules/common/jsp/taglibs.jsp"%>
<html>
<head>
    <title>用户注册界面</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/modules/common/css/com.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/login.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/bootstrap.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/bootstrap-theme.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/validate.css"/> ">

</head>
<body>
  <div class="bodyTop" >
    <div class="menu">
        <a>首页</a>
    </div>
  </div>
  <div class="bodyCenter">
    <div class="register">
        <div class="panel panel-danger" style="width:400px;">
            <div class="panel-heading" >
                <h3 class="panel-title" ><font style="font-family:Tahoma, Geneva, sans-serif">快速注册</font></h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" action="login.do" enctype="application/x-www-form-urlencoded" role="form" id="myForm">
                    <div class="input-group">
                        <span class="input-group-addon" id="userName">用&nbsp 户&nbsp&nbsp名：</span>
                        <input type="text" class="form-control" placeholder="请输入用户名" aria-describedby="basic-addon1">
                    </div>
                    <p></p>
                    <div class="input-group">
                        <span class="input-group-addon" id="userPwd">密&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp码：</span>
                        <input type="text" class="form-control" placeholder="请输入密码" aria-describedby="basic-addon1">
                    </div>
                    <p></p>
                    <div class="input-group">
                        <span class="input-group-addon" id="userSurePwd">确认密码：</span>
                        <input type="text" class="form-control" placeholder="请再次输入密码" aria-describedby="basic-addon1">
                    </div>
                    <p></p>
                    <div>
                        &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                        <button type="button" class="btn btn-primary" id="registerSubmit">注册</button>
                        &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                        <button type="reset" class="btn btn-primary" id="reset">重置</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
  </div>
</body>
</html>

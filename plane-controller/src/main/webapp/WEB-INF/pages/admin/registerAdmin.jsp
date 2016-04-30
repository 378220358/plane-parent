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
    <script language="javascript" type="text/javascript" src="<c:url value="/modules/common/js/jquery-2.1.4.min.js"/>"></script>
    <script type="text/javascript" language="javascript">
        function checkUser(){
            $.ajax({
                type:"GET",
                url: "/plane/bg/getBGUserInfo.do?BGName="+$("#userName").val(),
                contentType: "application/json; charset=utf-8",
                timeout: 60000 * 3,
                dataType:"json",
                success:function(data){
                    if(data == 'exist'){
                        alert("该用户名以及存在");
                    }
                }
            });
            $("#userName")
        }

        function validateRegister(){
            var userName = $("#userName").val();
            var userPwd = $("#userPwd").val();
            var userSurePwd = $("#userSurePwd").val();
            var flag = true;
            if($.trim(userName) == null || $.trim(userName) == ""){
                alert("请输入用户名");
            }
            if($.trim(userPwd) == null || $.trim(userPwd) == ""){
                alert("请输入密码");
                if($.trim(userSurePwd) == null || $.trim(userSurePwd) == ""){
                    alert("请再次输入密码");
                }else{
                    flag = true;
                }
            }
            return flag;
        }
        function surePwd(){
            var userPwd = $("#userPwd").val();
            var userSurePwd = $("#userSurePwd").val();
            if(userPwd != userSurePwd){
                alert("密码不一致，请重新输入");
            }
        }
    </script>
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
                <form class="form-horizontal" method="post" action="/plane/bg/addBGUser.do" enctype="application/x-www-form-urlencoded" role="form" id="myForm" onsubmit="return validateRegister()" >
                    <c:if test="${error != null}">
                        <span style="color: red">${error}</span>
                    </c:if>
                    <div class="input-group">
                        <span class="input-group-addon">用&nbsp 户&nbsp&nbsp名：</span>
                        <input type="text" name="BGName"  id="userName" class="form-control" placeholder="请输入用户名" aria-describedby="basic-addon1" onblur="checkUser()">
                    </div>
                    <p></p>
                    <div class="input-group">
                        <span class="input-group-addon" >密&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp码：</span>
                        <input type="password" id="userPwd" name="BGPwd" class="form-control" placeholder="请输入密码" aria-describedby="basic-addon1">
                    </div>
                    <p></p>
                    <div class="input-group">
                        <span class="input-group-addon">确认密码：</span>
                        <input type="password" id="userSurePwd" name="userSurePwd" class="form-control" placeholder="请再次输入密码" aria-describedby="basic-addon1" onblur="surePwd()">
                    </div>
                    <p></p>
                    <div class="input-group">
                        <span class="input-group-addon">用户权限：</span>
                        <select class="form-control" name ="BGRole">
                            <option value="-1">请选择</option>
                            <option value="ADMIN">管理员</option>
                            <option value="COMMON">普通管理员</option>
                            <option value="READ">运营人员</option>
                        </select>
                    </div>
                    <p></p>
                    <div>
                        &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                        <button type="submit" class="btn btn-primary" id="registerSubmit">注册</button>
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

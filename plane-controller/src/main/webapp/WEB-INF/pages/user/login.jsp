
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/modules/common/jsp/taglibs.jsp"%>
<html>
<head>
  <title>用户登录</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/login.css"/> ">
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/bootstrap.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/bootstrap-theme.min.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/validate.css"/> ">
  <script language="javascript" type="text/javascript" src="<c:url value="/modules/common/js/jquery-2.1.4.min.js"/>"></script>
  <script language="javascript" type="text/javascript" src="<c:url value="/modules/common/js/jquery.validate.js"/> "></script>
  <script language="javascript" type="text/javascript" src="<c:url value="/modules/common/js/validate.js"/> "></script>
  <script type="text/javascript" language="javascript">
    $(function(){
      $("#loginSubmit").click(function(){
        var flag = true;
        if($("#userName").val() == ''){
          flag = false;
          alert("用户名不能为空");
          $("#userName").focus();
        }else if($("#userPwd").val() == ''){
          flag = false;
          alert("密码不能为空！");
          $("#userPwd").focus();
        }
      });
    })
  </script>
</head>

<body style="background:url(<c:url value="/modules/common/images/login_bg.jpg" />) top center no-repeat;">

</div>
<div style="width:670px; height:550px; position:absolute; top:30%; left:55%;">
  <div class="panel panel-danger" style="width:400px;">
    <div class="panel-heading" >
      <h3 class="panel-title" ><font style="font-family:Tahoma, Geneva, sans-serif">用户登录界面</font></h3>
    </div>
    <div class="panel-body">
      <form class="form-horizontal" method="post" action="/plane/user/login.do" enctype="application/x-www-form-urlencoded" role="form" id="myForm">
        <table>
          <tr>
            <center><span id="showInfo" style="display: none;color: red"></span></center>
            <td>用户名：</td>
            <td width="220"><input type="text" class="form-control" id="userName"placeholder="请输入用户名" name="userName" value="${account}"></td>
            <td></td>
          </tr><tr><td>　</td></tr>
          <tr>
            <td>密 码：</td>
            <td><input type="password" class="form-control" id="userPwd"placeholder="请输入密码" name="userPwd"></td>
            <td><a href="/plane/user/registerIndex.do" >注册</td>
          </tr><tr><td class="text-center"><font size="1.5" color="red">${loginInfo}</font>　</td></tr>
          <tr>
            <td></td>
            <td>
              <button type="submit" class="btn btn-primary" id="loginSubmit">登录</button>
              &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
              <a href="index.html">
                <button type="reset" class="btn btn-primary">重置</button>
              </a>
            </td>
            <td></td>
          </tr>
        </table>
      </form>
    </div>


  </div>
</div>
</body>
</html>

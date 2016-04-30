<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/20
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/modules/common/jsp/taglibs.jsp"%>
<html>
<head>
    <title>用户中心</title>
  <link type="text/css" rel="stylesheet" href="<c:url value="/modules/common/css/com.css" />">
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/bootstrap.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/bootstrap-theme.min.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/validate.css"/> ">
  <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/modules/common/css/jquery.autocomplete.css'/>" />
  <script type="text/javascript" src="<c:url value="/modules/common/My97DatePicker/WdatePicker.js"/> "></script>
  <script type="text/javascript" src="<c:url value="/modules/common/js/jquery-2.1.4.min.js"/> "></script>
  <script type="text/javascript" language="javascript">

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
  <c:if test="${userInfo != null}">
    <div class="userCenter">
      <font color="#da70d6"><span>欢迎： <a href="/plane/user/userCenter.do">${userInfo.userName}</a> 来到纲纲订票系统 </span></font>
    </div>
  </c:if>
  <div class="menu">
    <a href="/plane/ticket/ticketMain.do">机票预订</a>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
    <a href="/plane/user/userCenter.do">用户中心</a>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
    <a href="/plane/ticket/userTicketCenter.do">订单中心</a>
  </div>
</div>
<div class="bodyCenter">
  <div class="register">
    <div class="panel panel-danger" style="width:400px;">
      <div class="panel-heading" >
        <h3 class="panel-title" ><font style="font-family:Tahoma, Geneva, sans-serif">用户中心</font></h3>
      </div>
      <div class="panel-body">
        <form action="/plane/user/updateUser.do" onsubmit="return validateRegister()" method="post">
          <input type="hidden" name="userId" value="${userInfo.userId}">
        <div class="input-group">
          <span class="input-group-addon">用&nbsp 户&nbsp&nbsp名：</span>
          <input type="text" name="userName" readonly id="userName" class="form-control" placeholder="请输入用户名" aria-describedby="basic-addon1" value="${userInfo.userName}">
        </div>
          <p></p>
          <div class="input-group">
            <span class="input-group-addon">用&nbsp 户&nbsp&nbspIP：</span>
            <input type="text" name="userIp" readonly id="userIp" class="form-control" placeholder="请输入用户名" aria-describedby="basic-addon1" value="${userInfo.userIp}">
          </div>
          <p></p>
          <div class="input-group">
            <span class="input-group-addon">登录时间：</span>
            <input type="text" name="dateTimeString" readonly id="userTime" class="form-control" placeholder="请输入用户名" aria-describedby="basic-addon1" value="<fmt:formatDate value="${userInfo.userTime}" pattern="yyyy-MM-dd HH:mm:ss"/>">
          </div>
        <p></p>
        <div class="input-group">
          <span class="input-group-addon" >密&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp码：</span>
          <input type="password" id="userPwd" name="userPwd" class="form-control" placeholder="请输入密码" aria-describedby="basic-addon1" value="${userInfo.userPwd}">
        </div>
        <p></p>
        <div class="input-group">
          <span class="input-group-addon" >确认密码：</span>
          <input type="password" id="userSurePwd" name="userSurePwd" class="form-control" placeholder="请输入密码" aria-describedby="basic-addon1" value="${userInfo.userPwd}">
        </div>
        <p></p>
        <div>
          &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <button type="submit" class="btn btn-primary" id="registerSubmit">修改密码</button>
          &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <button type="reset" class="btn btn-primary" id="reset">重置</button>
        </div>
        </form>
      </div>
    </div>
  </div>
</div>
</div>
</body>
</html>

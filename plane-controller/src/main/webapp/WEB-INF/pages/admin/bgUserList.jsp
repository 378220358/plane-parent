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
  <title>开通城市列表</title>
  <link type="text/css" rel="stylesheet" href="<c:url value="/modules/common/css/com.css" />">
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/login.css"/> ">
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/bootstrap.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/bootstrap-theme.min.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/validate.css"/> ">
  <script language="javascript" type="text/javascript" src="<c:url value="/modules/common/js/jquery-2.1.4.min.js"/>"></script>
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
  <div class="menu">
    <a href="/plane/admin/adminMainIndex.do">后台首页</a>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
    <a href="/plane/admin/addCityIndex.do">开通城市</a>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
    <a href="/plane/admin/addPlaneTicketIndex.do">增加航班信息</a>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
    <a href="/plane/admin/getAllCity.do">城市列表</a>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
    <a href="/plane/admin/getAllPlaneTicket.do">所有航班信息</a>
    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
    <a href="/plane/admin/planeInfoList.do">所有航班售卖信息</a>
  </div>
</div>
<div class="bodyCenter">
  <div class="register">
    <div class="panel panel-danger" style="width:500px;">
      <div class="panel-heading" >
        <h3 class="panel-title" ><font style="font-family:Tahoma, Geneva, sans-serif">开通城市列表</font></h3>
      </div>
      <table cellspacing="0" summary="" class="tab" id="pollTab">
        <thead>
        <th style="text-align:center;" width="100px">管理员ID</th>
        <th style="text-align: center;" width="100px">用户名</th>
        <th style="text-align:center;" width="100px">用户角色</th>
        <th style="text-align:center;" width="50px"> 修改</th>
        <th style="text-align:center;" width="50px">删除</th>
        </thead>
        <tbody>
        <c:forEach items="${adminList}" var="admin">
          <tr>
            <td style="text-align:center;"><c:out value='${admin.BGId}'/></td>
            <td style="text-align:center;"><c:out value='${admin.BGName}'/></td>
            <td style="text-align:center;"><c:choose><c:when test="${admin.BGRole == 'COMMON'}">普通运营人员</c:when><c:otherwise>运营人员</c:otherwise></c:choose> </td>
            <td style="text-align:center;"><a href="/plane/bg/updateBgUserInfo.do?BGId=${admin.BGId}">修改</a> </td>
            <td style="text-align:center;"><a href="/plane/bg/deleteBGUser.do?BGId=${admin.BGId}">删除</a> </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>

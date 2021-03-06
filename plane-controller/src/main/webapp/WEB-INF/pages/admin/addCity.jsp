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
    <title>开通城市</title>
  <link type="text/css" rel="stylesheet" href="<c:url value="/modules/common/css/com.css" />">
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/bootstrap.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/bootstrap-theme.min.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/validate.css"/> ">
  <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/modules/common/css/jquery.autocomplete.css'/>" />
  <script type="text/javascript" src="<c:url value="/modules/common/My97DatePicker/WdatePicker.js"/> "></script>
  <script type="text/javascript" src="<c:url value="/modules/common/js/jquery-2.1.4.min.js"/> "></script>
  <script type="text/javascript" language="javascript">

    function validateRegister(){
      var cityName = $("#cityName").val();
      var cityCode = $("#cityCode").val();
      var userSurePwd = $("#userSurePwd").val();
      var flag = true;
      if($.trim(cityName) == null || $.trim(cityName) == ""){
        flag = false;
        alert("请输入城市名称");
      }
      if($.trim(cityCode) == null || $.trim(cityCode) == ""){
        flag = false;
        alert("请输入城市编码");
      }
      return flag;
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
    <div class="panel panel-danger" style="width:400px;">
      <div class="panel-heading" >
        <h3 class="panel-title" ><font style="font-family:Tahoma, Geneva, sans-serif">开通城市</font></h3>
      </div>
      <div class="panel-body">
        <form action="/plane/admin/addCity.do" onsubmit="return validateRegister()" method="post">
          <input type="hidden" name="userId" value="${userInfo.userId}">
        <div class="input-group">
          <span class="input-group-addon">开通城市：</span>
          <input type="text" name="cityName"  id="cityName" class="form-control" placeholder="请输入城市名称" aria-describedby="basic-addon1" value="${userInfo.userName}">
        </div>
          <p></p>
          <div class="input-group">
            <span class="input-group-addon">城市编码：</span>
            <input type="text" name="cityCode" id="cityCode" class="form-control" placeholder="请输入城市编码" aria-describedby="basic-addon1" value="${userInfo.userName}">
          </div>
        <p></p>
        <div>
          &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
          <button type="submit" class="btn btn-primary" id="registerSubmit">开通</button>
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

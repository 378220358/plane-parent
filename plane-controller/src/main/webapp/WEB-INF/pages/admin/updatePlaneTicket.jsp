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
    <title>修改航班信息</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/modules/common/css/com.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/login.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/bootstrap.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/bootstrap-theme.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/validate.css"/> ">
    <script language="javascript" type="text/javascript" src="<c:url value="/modules/common/js/jquery-2.1.4.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/modules/common/My97DatePicker/WdatePicker.js"/> "></script>
    <script type="text/javascript" language="javascript">
        $(function(){
            $("#planeName").onfocus().style.imeMode = 'disabled';
        });

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
        <div class="panel panel-danger" style="width:400px;">
            <div class="panel-heading" >
                <h3 class="panel-title" ><font style="font-family:Tahoma, Geneva, sans-serif">修改航班信息</font></h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" action="/plane/admin/updatePlaneTicket.do" enctype="application/x-www-form-urlencoded" role="form" id="myForm" onsubmit="return validateRegister()" >
                    <c:if test="${error != null}">
                        <span style="color: red">${error}</span>
                    </c:if>
                    <div class="input-group">
                        <input type="hidden" name="planeId" value="${plane.planeId}">
                        <span class="input-group-addon">航班名称：</span>
                        <input type="text" name="planeName" style="ime-mode:disabled"  id="planeName" class="form-control" placeholder="请输入航班名称" aria-describedby="basic-addon1" value="<c:out value='${plane.planeName}'/>">
                    </div>
                    <p></p>
                    <div class="input-group">
                        <span class="input-group-addon" >航空公司：</span>
                        <input type="text" id="planeAirline" name="planeAirline" class="form-control" placeholder="请输入航空公司" aria-describedby="basic-addon1" value="<c:out value='${plane.planeAirline}'/>">
                    </div>
                    <p></p>
                    <div class="input-group">
                        <span class="input-group-addon">起飞时间：</span>
                        <input type="text" id="planeStartTimeString" name="planeStartTimeString" class="form-control" placeholder="请输入起飞时间" aria-describedby="basic-addon1" onfocus="WdatePicker({alwaysUseStartDate:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})"  class="text20 gray date medium" size="22"  value="<fmt:formatDate value="${plane.planeStartTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" >
                    </div>
                    <p></p>
                    <div class="input-group">
                        <span class="input-group-addon">到达时间：</span>
                        <input type="text" id="planeEndTimeString" name="planeEndTimeString" class="form-control" placeholder="请输入到达时间" aria-describedby="basic-addon1" value="<fmt:formatDate value="${plane.planeEndTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" onfocus="WdatePicker({alwaysUseStartDate:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})"  class="text20 gray date medium" size="22" >
                    </div>
                    <p></p>
                    <div class="input-group">
                        <span class="input-group-addon">起飞地点：</span>
                        <select name="planeStartPlace" class="form-control">
                            <option value="1">请输入出发城市</option>
                            <c:if test="${cityList != null}">
                                <c:forEach items="${cityList}" var="city">
                                    <option value="${city.cityId}" <c:if test="${plane.planeStartPlace == city.cityId}">selected</c:if>>${city.cityName}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </div>
                    <p></p>
                    <div class="input-group">
                        <span class="input-group-addon">到达地点：</span>
                        <select name="planeEndPlace" class="form-control">
                            <option value="1">请输入到达地点</option>
                            <c:if test="${cityList != null}">
                                <c:forEach items="${cityList}" var="city">
                                    <option value="${city.cityId}" <c:if test="${plane.planeEndPlace == city.cityId}">selected</c:if>>${city.cityName}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </div>
                    <p></p>
                    <div>
                        &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                        <button type="submit" class="btn btn-primary" id="registerSubmit">提交</button>
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

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/2/2
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/modules/common/jsp/taglibs.jsp"%>
<html>
<head>
    <title>订票界面</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/modules/common/css/com.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/bootstrap.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/bootstrap-theme.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/modules/common/css/validate.css"/> ">
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/modules/common/css/jquery.autocomplete.css'/>" />
    <script type="text/javascript" src="<c:url value="/modules/common/My97DatePicker/WdatePicker.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/modules/common/js/jquery-2.1.4.min.js"/> "></script>
    <script language="javascript" type="text/javascript" src="<c:url value='/modules/common/js/jquery.autocomplete.js'/>"></script>
    <script type="text/javascript">
        $(function(){
            autocomplete();
        });
        //自动补全
        function autocomplete(){
            $(".autocomplete").each(function(){
                var data = [];
                //楼盘标签
                if($(this).attr("name")=="startCity" || $(this).attr("name") == "endCity"){
                    //需要采用Ajax进行数据传送
                    var addressLabelData = [];
                    <c:forEach items='${allCity}' var="city">
                        addressLabelData.push('${city.cityName}');
                    </c:forEach>
                    data = addressLabelData;
                }

                $(this).AutoComplete({
                    'data': data ,
                    'itemHeight': 20,
                    'width': 195
                });
                $(this).focus(function(){
                    $(this).AutoComplete('show');
                });
            });
        }
    </script>
</head>
<body>
<div class="bodyTop" >
  <div class="menu">
    <a>机票预订</a>
  </div>
  </div>
  <div class="bodyCenter">
    <div class="register">
        <div class="panel panel-danger" style="width:300px;">
            <div class="panel-heading" >
                <h3 class="panel-title" ><font style="font-family:Tahoma, Geneva, sans-serif">机票预订</font></h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" action="/plane/user/register.do" enctype="application/x-www-form-urlencoded" role="form" id="myForm" onsubmit="return validateRegister()" >
                    <c:if test="${error != null}">
                        <span style="color: red">${error}</span>
                    </c:if>
                    <div class="input-group">
                        <span class="input-group-addon">出发城市：</span>
                        <input type="text" name="startCity"  id="startCity" class="text state autocomplete" placeholder="请输入出发城市" aria-describedby="basic-addon1" autocomplete="off">
                    </div>
                    <p></p>
                    <div class="input-group">
                        <span class="input-group-addon" >目的城市：</span>
                        <input type="text" id="endCity" name="endCity" class="text state autocomplete" placeholder="请输入目的城市" aria-describedby="basic-addon1" autocomplete="off">
                    </div>
                    <p></p>
                    <div class="input-group">
                        <span class="input-group-addon">出发时间：</span>
                        <input type="text" id="startTime" name="startTime" onfocus="WdatePicker({alwaysUseStartDate:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})"  class="text20 gray date medium" size="22">
                    </div>
                    <p></p>
                    <div>
                        &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                        <button type="submit" class="btn btn-primary" id="registerSubmit">查询</button>
                        &nbsp &nbsp &nbsp &nbsp &nbsp
                        <button type="reset" class="btn btn-primary" id="reset">重置</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
  </div>
</body>
</html>

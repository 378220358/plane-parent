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
    <title>管理员登录主界面</title>
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

            <div class="userCenter">
                <font color="#da70d6"><span>欢迎： admin登录陈刚刚飞机售票管理系统 </span></font>
            </div>

  <div class="menu">

  </div>
  </div>
  <div class="bodyCenter">
    <div class="register">
        <div class="panel panel-danger" style="width:300px;">
            <div class="panel-heading" >
                <h3 class="panel-title" ><font style="font-family:Tahoma, Geneva, sans-serif">机票预订</font></h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" action="/plane/ticket/queryTicket.do" enctype="application/x-www-form-urlencoded" role="form" id="myForm" onsubmit="return validateRegister()" >
                    <div>
                        &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                        <a href="/plane/admin/addCityIndex.do"> <button type="button" class="btn btn-primary" id="registerSubmit">开通城市</button></a>
                        &nbsp &nbsp &nbsp &nbsp &nbsp
                        <button type="button" class="btn btn-primary" id="reset">增加航班</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <c:if test="${ticketList != null}">
        <div class="ticketList">
            <c:forEach items="${ticketList}" var="ticket">
                <div class="panel panel-danger" style="width:600px;">
                    <div class="panel-heading" >
                        <h3 class="panel-title" ><font style="font-family:Tahoma, Geneva, sans-serif">机票列表</font></h3>
                    </div>
                    <div class="panel-body">
                        <table cellspacing="0" summary="" class="tab" id="pollTab">
                            <thead>
                                <th style="text-align:center;" width="4%">航班</th>
                                <th style="text-align: center;" width="15%">航空公司</th>
                                <th style="text-align:center;">出发时间</th>
                                <th style="text-align:center;">到达时间</th>
                                <th style="text-align:center;">订票</th>
                            </thead>
                            <tbody>
                                <tr>
                                    <td style="text-align:center;"><c:out value='${ticket.planeName}'/></td>
                                    <td style="text-align:center;"><c:out value='${ticket.planeAirline}'/></td>
                                    <td style="text-align:center;"><fmt:formatDate value="${ticket.planeStartTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                    <td style="text-align:center;"><fmt:formatDate value="${ticket.planeEndTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                    <td style="text-align:center;"><a href="/plane/ticket/selectSeat.do?ticketPoolId=${ticket.ticketPoolId}">订票</a> </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
  </div>
</body>
</html>

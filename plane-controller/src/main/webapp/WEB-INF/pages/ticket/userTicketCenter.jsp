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
    <title>用户订单中心</title>
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
        <a>首页</a>
    </div>
  </div>
  <div class="bodyCenter">
    <div class="register">
        <div class="panel panel-danger" style="width:400px;">
            <div class="panel-heading" >
                <h3 class="panel-title" ><font style="font-family:Tahoma, Geneva, sans-serif">订单<中心/font></h3>
            </div>
            <div class="panel-body">
                <table cellspacing="0" summary="" class="tab" id="pollTab">
                    <thead>
                        <th style="text-align:center;" width="4%">姓名</th>
                        <th style="text-align: center;" width="15%">身份证号码</th>
                        <th style="text-align:center;">订单时间</th>
                        <th style="text-align:center;">订单IP</th>
                        <th style="text-align:center;">订单金额</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${ticketList}" var="ticket">
                            <tr>
                                <td style="text-align:center;"><c:out value='${ticket.ticketName}'/></td>
                                <td style="text-align:center;"><c:out value='${ticket.ticketCard}'/></td>
                                <td style="text-align:center;"><fmt:formatDate value="${ticket.ticketTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td style="text-align:center;"><c:out value='${ticket.ticketIp}'/></td>
                                <td style="text-align:center;"><c:out value='${ticket.ticketMoney}'/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
  </div>
</body>
</html>

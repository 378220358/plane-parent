<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/modules/common/jsp/taglibs.jsp"%>
<head>
    <title>无权限提醒</title>

          
     <style type="text/css">	
		body{text-align:center}	
		a{color:#06c;text-decoration:none}
		a:hover{color:#f00;text-decoration:underline}
		a:active{color:#800080}
		a:focus{outline:none}
		
		a.u{text-decoration:underline}
		a.u:hover{text-decoration:none}
	
		.errBack{margin:0 auto;width:950px;height:415px;background:url(<c:url value="/modules/common/images/err_403.gif"/>) no-repeat center 35px}
		.errBack h2{color:#f9b023;font:bold 24px "微软雅黑";text-indent:270px;padding-top:140px}
		.errBack dl{padding:20px 0 0 490px;height:100px;position:relative}
		.errBack dl dt{width:250px;position:absolute;top:30px;left:350px}
		.errBack dl dd{padding-top:10px;text-align:left}
	</style>
</head>
<body id="main">

<!--con begin-->
<div class="errBack">
	<h2>抱歉，您请求的页面您无权限访问！</h2>
	<dl>
		<dt>您可以：</dt>
		<dd>1.检查网页地址是否正确;</dd>
		<dd>2.稍后再试或者联系管理员;</dd>
	</dl>
</div>
<!--con end-->

</body>
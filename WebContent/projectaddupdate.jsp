<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目更新</title>
<style type="text/css">
	body{
				font-family: "微软雅黑";
				font-size: 12px;
				
			}
			.container{
				min-height: 500px;
			}
			div{
				display: block;
			}
			.header{
				height: 62px;
				border-bottom: 1px solid #d6dfea;
				overflow: hidden;
				display: block;
				background-color: #eff4fa ;
				
			}
			#logo{
				color: #1d5494;
				width: 280px;
				height: 35px;
				float:left;
				margin-top: 14px;
				margin-left: 17px;
				background-image:url(img/logo.png);
				/*background-size: 182px 35px;*/
				background-repeat:no-repeat;
				background-position: left center;
				text-decoration: none;
				text-indent: -9999em;
				
			}
			.header_link{
				overflow: hidden;
				margin-top: 16px;
				padding-right: 17px;
				line-height: 30px;
				text-align: right;
				color: #b6b6b6;	
			}
			.header_link_a{
				color: #1D5494;
				text-decoration: none;
				
			}
			
			
			
			.footer{
				position: static;
				margin-bottom: 0px;
				margin-left: 0px;
				margin-right: 0px;
				line-height: 36px;
				text-align: center;
				color: #b6b6b6;
				background-color: #EFF4FA;
				border-top: 1px solid #d6dfea;
				
				
			}

</style>
</head>
<body>
	<div class="container">
		<div class="header">
				<a href="#" id="logo">项目管理系统</a>
			
			<div class="header_link">
				<a href="#" class="header_link_a">基本版&nbsp;</a>|
				<a href="#" class="header_link_a">&nbsp;English&nbsp;</a>|
				<a href="#" class="header_link_a">&nbsp;手机版&nbsp;</a>|
				<a href="#" class="header_link_a">&nbsp;企业版</a>
			</div>
		</div>
			<c:if test="${empty requestScope.project}">
				<h1>添加页面</h1>
			</c:if>
			
			
			<c:if test="${not empty requestScope.project}">
				<h1>更新页面</h1>
			</c:if>


			<h1>项目管理</h1>
			<form action="ProjectsServlet" method="post">
			
			<c:if test="${empty requestScope.project}">
				<input type="hidden" name="flag" value="addProject">
			</c:if>
			
			<c:if test="${not empty requestScope.project}">
				<input type="hidden" name="flag" value="updateProject">
				<input type="hidden" name="proid" value="${requestScope.project.proid}">
			</c:if>
			
			
			项目名称 <input type="text" name="proname"  <c:if test="${not empty requestScope.project}"> value="${requestScope.project.proname}"</c:if> ><br><br>
			周期 <input type="text" name="start_time"  <c:if test="${not empty requestScope.project}"> value="${requestScope.project.start_time}"</c:if>  >
			-
			<input type="text" name="end_time"   <c:if test="${not empty requestScope.project}"> value="${requestScope.project.end_time}"</c:if>   ><br><br>
			负责人 <select name="header">
				<c:if test="${empty requestScope.project}">
					<option>-请选择-</option>
				</c:if>
				
				<c:forEach items="${sessionScope.list2}" var="users">
					<option value="${users.id}" <c:if test="${requestScope.list.header == users.id}"> selected="selected"</c:if> >
						${users.name}
					</option>
				</c:forEach>
				
			</select>
			<br><br>
			<input type="submit" value="提   交">
			</form>
			<div class="footer">
		<a href="#" class="header_link_a">关于我们</a>&nbsp;|&nbsp;
		<a href="#" class="header_link_a">服务条款</a>&nbsp;|&nbsp;
		<a href="#" class="header_link_a">客服中心</a>&nbsp;|&nbsp;
		<a href="#" class="header_link_a">联系我们</a>&nbsp;|&nbsp;
		<a href="#" class="header_link_a">帮助中心</a>&nbsp;|&nbsp;@2017-2017 Zzing95 Inc.All Rights Reserved.
	</div>
			</div>
</body>
</html>
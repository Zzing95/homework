<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目更新</title>
</head>
<body>
			<c:if test="${empty requestScope.project}">
				<h1>添加页面</h1>
			</c:if>
			
			
			<c:if test="${not empty requestScope.project}">
				<h1>更新页面</h1>
			</c:if>


			<h1>项目管理系统</h1>
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
</body>
</html>
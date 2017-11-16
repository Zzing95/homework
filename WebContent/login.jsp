<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目管理</title>
<style type="text/css">
			body{
				font-family: "微软雅黑";
				font-size: 12px;
				
			}
			.container{
				min-height: 870px;
				background-color: #eff4fa;
				
			
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
			
			.content{
				width: 960px;
				margin: 32px auto;
				padding: 0px 24px ;
				
			}
			.content_wrapper{
				min-height: 372px;
				padding-top: 40px;
				margin: 0px 20px 60px 25px;
				
			}
			.login_pictures{
				position: relative;
				margin-right: 395px;
				
			}
			.login_container{
				width: 334px;
				height: 387px;
				visibility: visible;
				float: right;
				border: 1px solid #a0b1c4;
				background-color: #FFFFFF
				position: relative;
				padding: 0px;
				border-radius: 5px;
				overflow: hidden;
				z-index: 12px;
				text-align: center;
				
				
			}
			.login_pictures_picture{
				position: absolute;
				margin-left: -130px;
				margin-right: 0px;
				margin-top: 0px;
				height: 400px;
				background-size: auto;
				background-repeat:no-repeat ;
				background-position: right 20px;  
			}
			.login{
				text-align: center;
				font-size: 20px;
				border: 1px solid ;
			}
		
			.footer{
				position: static;
				margin-bottom: 50px;
				margin-left: 0px;
				margin-right: 0px;
				line-height: 40px;
				text-align: center;
				color: #b6b6b6;
				background-color: #EFF4FA;
				border-top: 1px solid #d6dfea;
				margin-top: -70px;
				
				
			}
			#kuaisu{
				float: left;
				margin-left: 70px ;
				margin-top: 15px;
				font-size:14px ;
				
			
			}
			.z{
				margin-top: 60px;
				
			}
			.z input{
				color: gray;
				width: 250px;
				height: 25px;
			}
			#checkbox{
				margin-left: -90px;
				font-size: 13px;
			}
			#login{
				margin-top: 30px;
				width: 180px;
				height: 35px;
				background-color: cornflowerblue;
				color: white;
			}
			.ss{
				float: right;
				margin-top: 50px;
				margin-right: 10px;
			}
			#a1{
				height: 50px;
				border-bottom: 1px solid #d6dfea;
				background-color: #eff4fa;
			}
		</style>
	</head>
	<body>
		
		<div class="container">
			<div class="header">
				<a href="#" id="logo"></a>
			
			<div class="header_link">
				<a href="#" class="header_link_a">基本版&nbsp;</a>|
				<a href="#" class="header_link_a">&nbsp;English&nbsp;</a>|
				<a href="#" class="header_link_a">&nbsp;手机版&nbsp;</a>|
				<a href="#" class="header_link_a">&nbsp;企业版</a>
			</div>
		</div>

	
	<div class="content">
		<div class="content_wrapper">
			<div class="login_pictures">
				<div class="login_pictures_picture">
					<img src="img/img.jpg"/>
				</div>
			</div>
			<div class="login_container">
				
				<div class="login_box">
					<h1>项目管理</h1>
				</div>
					<form action="UsersServlet" method="post">
						<br><br><br>
						账号 ：  <input type="text" name="username" ><br><br>
						密码 ： <input type="text" name="password" ><br>
						<input type="submit" id=login value="登    录">
					</form>
					
					<br>
					<div id="checkbox">
					<input type="checkbox"/>&nbsp;&nbsp;下次自动登陆
				</div>
				
				
				
				<div class="ss">
					<a href="#" class="header_link_a">忘了密码？</a>&nbsp;|&nbsp;
					<a href="addUsers.jsp" class="header_link_a">注册账号</a>
				</div>
				</div>
				
				
			</div>
		</div>
	</div>
	
	
	<div class="footer">
		<a href="#" class="header_link_a">关于我们</a>&nbsp;|&nbsp;
		<a href="#" class="header_link_a">服务条款</a>&nbsp;|&nbsp;
		<a href="#" class="header_link_a">客服中心</a>&nbsp;|&nbsp;
		<a href="#" class="header_link_a">联系我们</a>&nbsp;|&nbsp;
		<a href="#" class="header_link_a">帮助中心</a>&nbsp;|&nbsp;@2017-2017 Zzing95 Inc.All Rights Reserved.
	</div>
	
		
	</body>
</html>

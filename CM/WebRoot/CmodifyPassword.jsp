<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>修改密码</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="CSS/main.css">
		<script src="js/jquery-1.2.1.min.js" type="text/javascript"></script>
		<script src="js/menu.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="CSS/style.css" />
		<script type="text/javascript">
			if('${msg }'!="") alert('${msg }');
		</script>
	<script type="text/javascript">if('${IsLogin }'==false){location.href="login.jsp";}</script></head>

	<body background="image/bg1.png">
		<div id="block">
			<div id="top">
				<img src="image/0.jpg" height="100%" width="100%">
			</div>
			<div id="left">
				<div class="menu">
					&nbsp;
				</div>
				<ul id="menu">
					<li>
						<a href="CcheckList.jsp" >查看流水单</a>
						<ul>
							<li>
								<a href="ViewBill?type=NotFinished" >未完成流水单</a>
							</li>
							<li>
								<a href="ViewBill?type=Finished" >维修历史</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="CpersonalInfo.jsp" >个人信息</a>
						<ul>
							<li>
								<a href="ViewUserInfo?type=Info" >查看信息</a>
							</li>
							<li>
								<a href="ViewUserInfo?type=password" >修改密码</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="carsManagement.jsp">车辆管理</a>
						<ul>
							<li>
								<a href=" ManageCar?type=Search">查看车辆</a>
							</li>
							<li>
								<a href="addCars.jsp">增加车辆</a>
							</li>
						</ul>
					</li>
					<li>
						<a href=" ManageCar?type=CreateCheck">维修</a>
					</li>
					<li>
						<a href="LoginOut" >退出</a>
					</li>
				</ul>
				<br />
				<br />
			</div>
			<div id="Sright">
				<div class="item">
					修改密码
				</div>
				<div class="personalInfo">
					<form action="ModifyInfo?type=password" method="post">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									原&nbsp;密&nbsp;码:
								</td>
								<td>
									<input type="password" name="oldPwd" id="input" 
										onmouseover="this.focus();this.select();" />
								</td>
							</tr>
							<tr>
								<td>
									新&nbsp;密&nbsp;码:
								</td>
								<td>
									<input type="password" name="newPwd1" id="input"
										onmouseover="this.focus();this.select();" />
								</td>
							</tr>
							<tr>
								<td>
									再次输入:
								</td>
								<td>
									<input type="password" name="newPwd2" id="input" 
										onmouseover="this.focus();this.select();" />
								</td>
							</tr>
						</table>
						<p>
						<div class="button">
							<input type="submit" name="update" value="修改" id="button" />
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" name="cancel" value="取消" id="button"
								onclick="window.history.back()" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>

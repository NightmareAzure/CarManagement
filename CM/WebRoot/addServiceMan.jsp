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

		<title>欢迎进入</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="CSS/main.css">
		<script src="js/jquery-1.2.1.min.js" type="text/javascript"></script>
		<script src="js/menu.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="CSS/style.css" />
	
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
						<a href="#" >查看流水单</a>
						<ul>
							<li>
								<a href="ViewBill?type=NotFinished" >未处理</a>
							</li>
							<li>
								<a href="ViewBill?type=Doing" >正在处理</a>
							</li>
						</ul>
						
					</li>
					<li>
						<a href="SpersonalInfo.jsp" >个人信息</a>
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
						<a href="inventoryManagement.jsp">库存管理</a>
						<ul>
							<li>
								<a href="ManagePart?type=Search">查看零件</a>
							</li>
							<li>
								<a href="addComponent.jsp">增加零件</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="ViewBill?type=Finished">维修历史</a>
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
					添加维修员
				</div>
				<div class="personalInfo">
					<form action="Supdate.jsp" method="post">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									维修员ID:
								</td>
								<td>
									<input type="text" name="addServiceManID" id="input" />
								</td>
							</tr>
							<tr>
								<td>
									维&nbsp;&nbsp;修&nbsp;&nbsp;员:
								</td>
								<td>
									<input type="text" name="addServiceManName" id="input" />
								</td>
							</tr>
							<tr>
								<td>
									费&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用:
								</td>
								<td>
									<input type="text" name="addFee" id="input" />
								</td>
							</tr>
							</table>
						<p>
						<div class="button">
							<input type="submit" name="update" value="添加" id="button" />
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

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

		<title>车辆维修</title>

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
					添加维修车辆
				</div>
				<div class="carQuestion">
					<form action="ManageCar?type=DoingCheck&CarId=${info.carId }" method="post" >
						<b>品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;牌</b>： <input type="text" name="brand" id="input" value="${info.carBrand }" readonly><p>
						<b>型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</b>： <input type="text" name="model" id="input" value="${info.carModel }" readonly><p>
						<b>车&nbsp;牌&nbsp;号</b>： <input type="text" name="CarCode" id="input" value="${info.carCode }" readonly><p>
						<b>车辆问题</b>：<br><textarea style="color:gray" name="Problem" cols="80" rows="10" onmouseover="this.focus();this.select();">请这里输入。。。</textarea><p>
						<input type="submit" name="submit" value="提交" id="button" />
						<input type="button" name="cancel" value="取消" id="button" onclick="window.history.back()"/>
					</form>
				</div>
		</div>
	</div>
	</body>
</html>

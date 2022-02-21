<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<title>流水单信息</title>

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
	function view(info) {
		alert(info);
	}
</script>
		<script type="text/javascript">
	if ('${IsLogin }' == false) {
		location.href = "login.jsp";
	}
</script>
	</head>

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
						<a href="CcheckList.jsp">查看流水单</a>
						<ul>
							<li>
								<a href="ViewBill?type=NotFinished">未完成流水单</a>
							</li>
							<li>
								<a href="ViewBill?type=Finished">维修历史</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="CpersonalInfo.jsp">个人信息</a>
						<ul>
							<li>
								<a href="ViewUserInfo?type=Info">查看信息</a>
							</li>
							<li>
								<a href="ViewUserInfo?type=password">修改密码</a>
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
						<a href="LoginOut">退出</a>
					</li>
				</ul>
				<br />
				<br />
			</div>
			<div id="Sright">
				<div class="item">
					维修历史
				</div>
				<div class="checkList">
					<table border="1" style="border-collapse: collapse" width="90%"
						align="center">

						<tr>
							<th rowspan="2">
								ID
							</th>
							<th colspan="3">
								车
							</th>
							<th rowspan="2">
								日期
							</th>
							<th rowspan="2">
								检验员
							</th>
							<th rowspan="2">
								零件费用
							</th>
							<th rowspan="2">
								维修费用
							</th>
							<th rowspan="2">
								状态
							</th>
							<th rowspan="2">
								车辆问题
							</th>

						</tr>
						<tr>
							<th>
								车牌号
							</th>
							<th>
								型号
							</th>
							<th>
								品牌
							</th>
						</tr>
						<c:forEach items="${info }" var="EachInfo">
							<tr>
								<td>
									${EachInfo[0] }
								</td>
								<td>
									${EachInfo[1] }
								</td>
								<td>
									${EachInfo[2] }
								</td>
								<td>
									${EachInfo[3] }
								</td>
								<td>
									${EachInfo[4] }
								</td>
								<td>
									${EachInfo[5] }
								</td>
								<td>
									${EachInfo[6] }
								</td>
								<td>
									${EachInfo[7] }
								</td>
								<c:if test="${EachInfo[8]==0 }"><td >维修中</td></c:if>
								<c:if test="${EachInfo[8]==-1 }"><td >未维修</td></c:if>
								<c:if test="${EachInfo[8]==1 }"><td >已完成</td></c:if>
								<td>
									<a onclick="view('${EachInfo[9] }');"><img src="image/10.png" width="20px" />查看</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>

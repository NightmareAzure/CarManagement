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

		<title>库存管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="CSS/main.css">
		<script src="js/jquery-1.2.1.min.js" type="text/javascript"></script>
		<script src="js/menu.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="CSS/style.css" />
	<script type="text/javascript" >
			function deleteParts(){
				var inputs = document.getElementsByName("delete");
				var j=0;
				for(var i = 0; i < inputs.length; i++){
					if(inputs[i].checked == true){
						j++;
					}
				}
				if(j!=0){
					if(confirm("确定删除这"+j+"项吗？")){
						window.location.href="ManagePart?type=Delete";
						document.form2.submit();
	         	 	}
         	 	}
			}
		</script>
		<script type="text/javascript">
			if('${message }'!="") alert('${message }');
		</script>
	<script type="text/javascript">if('${IsLogin }'==false){location.href="login.jsp";}</script></head>
	
	<body background="image/bg1.png">
	<div id="block">
		<div id="top">
			<img src="image/0.jpg"  height="100%" width="100%">
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
							<a href="ManagePart?type=Search" >查看零件</a>
						</li>
						<li>
							<a href="addComponent.jsp" >添加零件</a>
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
		<div id="Sright" >
				<div class="item">
					添加零件
				</div>
				<div class="addComponent">
					<form action="ManagePart?type=Add" method="post">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									型号:
								</td>
								<td>
									<input type="text" name="componnentCode" id="input">
								</td>
							</tr>
							<tr>
								<td>
									产地:
								</td>
								<td>
									<input type="text" name="produceArea" id="input">
								</td>
							</tr>
							<tr>
								<td>
									厂家:
								</td>
								<td>
									<input type="text" name="manufacturer" id="input">
								</td>
							</tr>
							<tr>
								<td>
									单价:
								</td>
								<td>
									<input type="text" name="price" id="input">
								</td>
							</tr>
							<tr>
								<td>
									数量:
								</td>
								<td>
									<input type="text" name="num" id="input">
								</td>
							</tr>
						</table>
						<p>

							<input type="submit" name="add" value="添加" id="button" />
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" name="cancel" value="取消" id="button"
								onclick="window.history.back()" />
					</form>
				</div>
			</div>
	</div>
	</body>
</html>

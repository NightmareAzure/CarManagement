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

		<title>库存管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="CSS/main.css">
		<script src="js/jquery-1.2.1.min.js" type="text/javascript"></script>
		<script src="js/menu.js" type="text/javascript"></script>
		<script src="js/delete.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="CSS/style.css" />
		<script type="text/javascript">
			function add(){
				alert("您添加 xxx型号零件N个！");
			}
			function deleteComponent(){
				confirm("确定删除吗？");
				location.href="deleteComponent.jsp";
			}
		</script>
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
						//window.location.href="ManagePart?type=Delete";可以不要form里面注明了跳转
						document.form2.submit();
	         	 	}
         	 	}else{
         	 		alert("你未选择零件,无法删除!");
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
						<a href="SpersonalInfo.jsp"  >个人信息</a>
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
								<a href="ManagePart?type=Search"  >查看零件</a>
							</li>
							<li>
								<a href="addComponent.jsp"  >添加零件</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="ViewBill?type=Finished">维修历史</a>
					</li>
					<li>
						<a href="LoginOut" target="_top">退出</a>
					</li>
				</ul>
				<br />
				<br />
			</div>
			<div id="Sright">
				<div class="item">
					零件信息
				</div>
				<form method="post" name="form2" action="ManagePart?type=Delete">
				<div class="deleteComponent">
					<img src="image/16.png">
					<a onclick="deleteParts()"><font color="red" style="text-decoration:underline;">删除</font></a>
				</div>
				<div class="checkComponent">
					<table border="1"
						style="border-collapse: collapse;" width="90%" align="center">
						<tr>
							<th width="15%">
								型号
							</th>
							<th width="25%">
								产地
							</th>
							<th width="20%">
								厂家
							</th>
							<th width="10%">
								单价
							</th>
							<th width="10%">
								数量
							</th >
							<th width="10%">
								操作
							</th>
							<th width="10%">
								全选
								<input type="checkbox" name="deleteAll" onchange="checkAll(this);"/>
							</th>
						</tr>
						<c:forEach items="${info }" var="EachInfo">
						<tr>
							<td>
								${EachInfo.partModel }
							</td>
							<td>
								${EachInfo.partProduceArea }
							</td>
							<td>
								${EachInfo.partVender }
							</td>
							<td>
								${EachInfo.partPrice }
							</td>
							<td>
								${EachInfo.partNumber }
							</td>
							<td>
								<a href="ManagePart?type=CreateModify&PartModel=${EachInfo.partModel }"><img src="image/9.png" width="30px" />修改</a>
							</td>
							<td>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox" name="delete" value="${EachInfo.partModel }"/>
							</td>
						</tr>
						</c:forEach>
					</table>
				</div>
				</form>
			</div>
		</div>
	</body>
</html>

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

		<title>欢迎进入</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="CSS/main.css">
		<script src="js/jquery-1.2.1.min.js" type="text/javascript"></script>
		<script src="js/menu.js" type="text/javascript"></script>
		<script src="js/componentFee.js" type="text/javascript"></script>
		<script src="js/delete.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="CSS/style.css" />
		<script Language="JavaScript">
	function openPage() {

		newPage = window
				.showModalDialog(
						"inspectors.jsp",
						"userList",
						"dialogHeight=250px,dialogWidth=500px,toolbar=no, menubar=no,scrollbars=yes,resizable=no,location=no,status=no");
		//alert(newPage);
		userInfo = newPage.split(";");
		//document.write(userInfo);
		document.getElementsByName("receiver")[0].value = userInfo;
	}
</script>
	<script type="text/javascript" >
			function deleteParts(){
				var inputs = document.getElementsByName("deletePart");
				var j=0;
				for(var i = 0; i < inputs.length; i++){
					if(inputs[i].checked == true){
						j++;
					}
				}
				if(j!=0){
					if(confirm("确定删除这"+j+"项吗？")){
						//window.location.href="ManageCar?type=Delete";
						document.form1.submit();
	         	 	}
         	 	}else{
         	 		alert("你未选择订单中的零件,无法删除!");
         	 	}
			}
			function deleteServiceMans(){
				var inputs = document.getElementsByName("deleteServiceMan");
				var j=0;
				for(var i = 0; i < inputs.length; i++){
					if(inputs[i].checked == true){
						j++;
					}
				}
				if(j!=0){
					if(confirm("确定删除这"+j+"项吗？")){
						//window.location.href="ManageCar?type=Delete";
						document.form2.submit();
	         	 	}
         	 	}else{
         	 		alert("你未选择订单中的维修人员,无法删除!");
         	 	}
			}
			function AddParts(){
				var inputs = document.getElementsByName("addPart");
				var j=0;
				for(var i = 0; i < inputs.length; i++){
					if(inputs[i].checked == true){
						j++;
					}
				}
				if(j!=0){
					if(confirm("确定删除这"+j+"项吗？")){
						//window.location.href="ManageCar?type=Delete";
						document.form3.submit();
	         	 	}
         	 	}else{
         	 		alert("你未选择零件,无法添加!");
         	 	}
			}
			function AddServiceMans(){
				var inputs = document.getElementsByName("addServiceMan");
				var j=0;
				for(var i = 0; i < inputs.length; i++){
					if(inputs[i].checked == true){
						j++;
					}
				}
				if(j!=0){
					if(confirm("确定删除这"+j+"项吗？")){
						//window.location.href="ManageCar?type=Delete";
						document.form4.submit();
	         	 	}
         	 	}else{
         	 		alert("你未选择维修人员,无法添加!");
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
						<a href="SpersonalInfo.jsp">个人信息</a>
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
						<a href="inventoryManagement.jsp">库存管理</a>
						<ul>
							<li>
								<a href="ManagePart?type=Search">查看零件</a>
							</li>
							<li>
								<a href="addComponent.jsp">添加零件</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="ViewBill?type=Finished">维修历史</a>
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
					修改流水单
				</div>
				<div class="supdate">
					<form action="ModifyBill?type=ModifyBill" method="post">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									流水单号:
								</td>
								<td>
									<input type="text" name="BillId" id="input" value="${bill.billNumber }"
										readonly>
								</td>
							</tr>
							<tr>
								<td>
									检&nbsp;&nbsp;验&nbsp;&nbsp;员:
								</td>
								<td>
									<input type="text" name="inspector" id="input"
											value="${bill.billInspector }" onmouseover="this.focus();this.select();"/> 
								</td>
							</tr>
							<tr>
								<td>
									状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态:
								</td>
								<td>
									<select name="state" style="width: 160px; height: 28px;">
									<c:if test="${bill.billState ==-1}">
										<option value="-1">
											未处理
										</option>
									</c:if>
									<c:if test="${bill.billState ==0}">
										<option value="0">
											处理中
										</option>
									</c:if>
									<c:if test="${bill.billState ==1}">
										<option value="1">
											完成
										</option>
									</c:if>
										<option value="-1">
											未处理
										</option>
										<option value="0">
											处理中
										</option>
										<option value="1">
											完成
										</option>
									</select>
								</td>
							</tr>
						</table>
						<div class="updateButton">
							<input type="submit" name="update" value="修改" id="button" />
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" name="cancel" value="取消" id="button"
								onclick="window.history.back()" />
						</div>
					</form>
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								零件费用:
							</td>
							<td>
								<input type="radio" name="Fee" id="usedFee" checked/>
								已用零件
							</td>
							<td>
								<input type="radio" name="Fee" id="toUseFee" />
								所有零件和所有维修人员
							</td>
						</tr>
					</table>
					<div id="used">
						<form action="ModifyBill?type=DeletePart&BillId=${BillId }" name="form1" method="post">
						<div id="A">
							<img src="image/16.png">
							<a onclick="deleteParts()"><font color="red" style="text-decoration:underline;">删除</font> </a>
						</div>
						
						<div class="modifyTable">
							<table border="1" style="border-collapse: collapse;" width="90%"
								align="center">
								<tr>
									<th>
										型号
									</th>
									<th>
										单价
									</th>
									<th>
										数量
									</th>
									<th>
										费用
									</th>
									<th>
										操作
									</th>
									<th>
										全选
										<input type="checkbox" name="deleteAllPart" onchange="checkPart(this);">
									</th>
								</tr>
								<c:forEach items="${part }" var="EachPart">
								<tr>
									<td>
										${EachPart[0] }
									</td>
									<td>
										${EachPart[2] }
									</td>
									<td>
										${EachPart[1] }
									</td>
									<td>
										${EachPart[3] }
									</td>
									<td>
										<a href="ModifyBill?type=CreatePartModify&partModel=${EachPart[0] }&partNum=${EachPart[1] }&BillId=${BillId }"><img src="image/9.png" width="30px" />修改</a>
									</td>
									<td>
										<input type="checkbox" name="deletePart" value="${EachPart[0] }" >
									</td>
								</tr>
								</c:forEach>
							</table>
						</div>
						</form>
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									维修费用：
								</td>
								<td></td>
							</tr>
						</table>
						<div id="serviceFee">
							<form action="ModifyBill?type=DeleteServiceMan&BillId=${BillId }" name="form2" method="post">
							<div id="A">
								<img src="image/16.png">
							<a onclick="deleteServiceMans();"><font color="red" style="text-decoration:underline;">删除</font> </a>
							</div>
							<table border="1" style="border-collapse: collapse;" width="90%"
								align="center">
								<tr>
									<th colspan="2">
										维修员
									</th>
									<th rowspan="2">
										费用
									</th>
									<th rowspan="2">
										操作
									</th>
									<th rowspan="2">
										全选
										<input type="checkbox" name="deleteAllServiceMan" onchange="checkServiceMan(this);"/>
									</th>
								</tr>
								<tr>
									<th>
										ID
									</th>
									<th>
										姓名
									</th>
									
								</tr>
								<c:forEach items="${Service }" var="EachService">
								<tr>
									<td>
										${EachService[0] }
									</td>
									<td>
										${EachService[1] }
									</td>
									
									<td>
										${EachService[2] }
									</td>
									<td>
										<a href="ModifyBill?type=CreateServiceModify&ServiceManId=${EachService[0] }&BillId=${BillId }">修改</a>
									</td>
									<td>
										<input type="checkbox" name="deleteServiceMan" value="${EachService[0] }"/>
									</td>
								</tr>
								</c:forEach>
							</table>
						</form>
					</div>
	
					</div>
					<div id="toUse">
					<form action="ModifyBill?type=AddPart&BillId=${BillId }" name="form3" method="post">
						<div id="A">
							<a onclick="AddParts();"><img src="image/9.png"
									width="30px" /><font color="blue"><b>添加</b>
							</font> </a>
						</div>
						<div class="modifyTable">
							<table border="1" style="border-collapse: collapse;" width="90%"
								align="center">
								<tr>
									<th>
										型号
									</th>
									<th>
										单价
									</th>
									<th>
										原数量
									</th>
									<th>
										添加的数量
									</th>
									<th>
										全选
										<input type="checkbox" name="addAllPart" onchange="AddPart(this);">
									</th>
								</tr>
								<c:forEach items="${Allpart }" var="EachAllPart">
									<tr>
										<td>
											${EachAllPart.partModel }
										</td>
										<td>
											${EachAllPart.partPrice }
										</td>
										<td>
											${EachAllPart.partNumber }
										</td>
										<td>
											<input type="text" name="number" id="in" value="0" onmouseover="this.focus();this.select();"/>
										</td>
										<td>
											<input type="checkbox" name="addPart" value="${EachAllPart.partModel }">
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						</form>
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									维修费用：
								</td>
								<td></td>
							</tr>
						</table>
						<div id="serviceFee">
						<form action="ModifyBill?type=AddServiceMan&BillId=${BillId }" name="form4" method="post">
							<div id="A">
								<a onclick="AddServiceMans();"><img src="image/9.png"
										width="30px" /><font color="blue"><b>添加</b>
								</font> </a>
								</div>
							<table border="1" style="border-collapse: collapse;" width="90%"
								align="center">
								<tr>
									<th colspan="2">
										维修员
									</th>
									<th rowspan="2">
										费用
									</th>
									
									<th rowspan="2">
										全选
										<input type="checkbox" name="addAllServiceMan" onchange="AddServiceMan(this);"/>
									</th>
								</tr>
								<tr>
									<th>
										ID
									</th>
									<th>
										姓名
									</th>
									
								</tr>
								<c:forEach items="${AllService }" var="EachAllService">
								<tr>
									<td>
										${EachAllService.servicemanId }
									</td>
									<td>
										${EachAllService.servicemanName }
									</td>
										
									<td>
										<input type="text" name="price" id="in" value="输入.." onmouseover="this.focus();this.select();"/>
									</td>
									<td>
										<input type="checkbox" name="addServiceMan" value="${EachAllService.servicemanId }"/>
									</td>
								</tr>
								</c:forEach>
							</table>
						</form>
					</div>
					</div>
						</div>
				</div>
			</div>
		
	</body>
</html>

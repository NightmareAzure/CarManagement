<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'register.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css" href="CSS/main.css">
		<script src="js/jquery-2.0.3.min.js" type="text/javascript"
			charset="utf-8"></script>
		<script src="js/register.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		if('${msg }'!="") alert('${msg }');
		</script>

	</head>

	<body background="image/bg1.png">
		
			<div class="register">
				<font size="5" color="#993333"><b>fa请选择要注册的类型：</b>
				</font>
				<p>
					<input type="radio" name="userType" id="Cinput" checked="" />
					<font size="5" color="#993333"><b>Client</b>
					</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="userType" id="Sinput" />
					<font size="5" color="#993333"><b>serviceMan</b>
					</font>
			</div>
		
		
			<div class="register" id="clientRegister">

				<form name="register" method="post" action="Register?type=Client">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								账&nbsp;&nbsp;&nbsp;&nbsp;号:
							</td>
							<td>
								<input name="id" type="text" id="input" />
							</td>
						</tr>
						<tr>
							<td>
								姓&nbsp;&nbsp;&nbsp;&nbsp;名：
							</td>
							<td>
								<input name="username" type="text" id="input" />
							</td>
						</tr>
						<tr>
							<td>
								密&nbsp;&nbsp;&nbsp;&nbsp;码：
							</td>
							<td>
								<input name="pwd" type="password" id="input" />
							</td>
						</tr>
						<tr>
							<td>
								性&nbsp;&nbsp;&nbsp;&nbsp;别：
							</td>
							<td>
								<select name="sex" id="input">
									<option value="true">男</option>
									<option value="false">女</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								身份证号：
							</td>
							<td>
								<input name="idCardNo" type="text" id="input" />
							</td>
						</tr>
						<tr>
							<td>
								联系方式：
							</td>
							<td>
								<input name="telephoneNo" type="text" id="input" />
							</td>
						</tr>
						<tr>
							<td>
								备&nbsp;&nbsp;&nbsp;&nbsp;用：
							</td>
							<td>
								<input name="extraTelephoneNo" type="text" id="input" />
							</td>
						</tr>
					</table>
					<p>
					<div class="button">
						<input name="Csave" type="submit" id="button" value="保存" />
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="Creset" type="reset" id="button" value="重置" />
					</div>
				</form>

			</div>
			<div class="register" id="serviceManRegister">

				<form name="Register" method="post" action="Register?type=ServiceMan">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								账&nbsp;&nbsp;&nbsp;&nbsp;号:
							</td>
							<td>
								<input name="id" type="text" id="input" />
							</td>
						</tr>
						<tr>
							<td>
								姓&nbsp;&nbsp;&nbsp;&nbsp;名：
							</td>
							<td>
								<input name="username" type="text" id="input" />
							</td>
						</tr>
						<tr>
							<td>
								密&nbsp;&nbsp;&nbsp;&nbsp;码：
							</td>
							<td>
								<input name="pwd" type="password" id="input" />
							</td>
						</tr>
						<tr>
							<td>
								性&nbsp;&nbsp;&nbsp;&nbsp;别：
							</td>
							<td>
								<select name="sex" id="input">
									<option value="true">男</option>
									<option value="false">女</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								属&nbsp;&nbsp;&nbsp;&nbsp;性：
							</td>
							<td>
								<input name="attr" type="text" id="input" />
							</td>
						</tr>
						<tr>
							<td>
								身份证号：
							</td>
							<td>
								<input name="idCardNo" type="text" id="input" />
							</td>
						</tr>
						<tr>
							<td>
								联系方式：
							</td>
							<td>
								<input name="telephoneNo" type="text" id="input" />
							</td>
						</tr>

					</table>
					<p>
					<div class="button">
						<input name="Ssave" type="submit" id="button" value="保存" />
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="Sreset" type="reset" id="button" value="重置" />
					</div>
				</form>

			</div>
		

	</body>
</html>

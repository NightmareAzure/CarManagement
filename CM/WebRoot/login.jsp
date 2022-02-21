<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/main.css" >
	<script type="text/javascript">
		if('${msg }'!="") alert('${msg }');
	</script>
  </head>
  
  <body background="image/bg1.png">
  		<!-- ${msg } --><div align="center" class="mesg"></div>
			<div  class="login" >
				<form name="f1" method="post" action="Login">
					<table border="0" cellspacing="0" cellpadding="0" align="center">
						<tr>
							<td>用户名:&nbsp;</td>
							<td><input type="text" name="username" id="input"></td>
						</tr>
						<tr>
							<td>密&nbsp;&nbsp;码:&nbsp;</td>
							<td><input type="password" name="pwd" id="input"></td>
						</tr>
						<tr>
							<td>类&nbsp;&nbsp;型:&nbsp;</td>
							<td><select name="type" id="select" >
									<option value="">
										------------请选择------------
									</option>
									<option value="Client">
										客户
									</option>
									<option value="ServiceMan">
										维修员
									</option>
								</select>
							</td>
						</tr>				
					</table><p>
					<div align="center">
						<input type="submit" name="submit" value="登陆" id="button">&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" name="reset" value="重置" id="button">&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
				</form>
				<div align="center" class="LOG">
							<font size="2">若还没有账号请</font><a href="register.jsp">立即注册</a>
				</div>
			</div>
</body>
</html>

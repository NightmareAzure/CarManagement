<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>检验员名单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
			function closepage() {
				window.close();
			}
			function check() {
		
				var empName = document.getElementsByName("singleSelect");
				var i = 0;
				var dd;
				for (i = 0; i < empName.length; i++) {
					if (empName[i].checked) {
						dd = empName[i].value;
						window.returnValue = dd;
						closepage();
		
					}
				}
				closepage();
			}
		</script>
  <script type="text/javascript">if('${IsLogin }'==false){location.href="login.jsp";}</script></head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>

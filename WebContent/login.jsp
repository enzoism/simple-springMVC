<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
	function submitOnBtn() {
		var objList = new Array();
		var obj = {
			id : 1
		};
		$.post("http://localhost:8080/SSMDemo2/user/login.do", {
			"username" : "tony",
			"password" : "123456",
		}, function(data) {
			alert(data);
		}, "json");
	}
</script>
<title>用户登录</title>

</head>

<body>
	<input type="button" onclick="submitOnBtn();" value="直接点击就可以测试" /><br/>
	<a href="http://localhost:8080/SSMDemo2/user/insertMultiUserSuccess.do">点击的时候进行数据的批量插入(模拟成功)</a><br/>
	<a href="http://localhost:8080/SSMDemo2/user/insertMultiUserFail.do">点击的时候进行数据的批量插入(模拟失败)</a><br/>
	
</body>
</html>

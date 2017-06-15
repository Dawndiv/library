<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>福州市数字图书馆系统</title>
<style type="text/css">
body { font: 12px 宋体;}
#div1 { width: 50%; margin: auto; border: #000 solid 1px;}
h3 { background-color: #069; color: #FFF; text-align: center; margin: 0px; padding: 10px;}
#table1 { line-height: 40px; margin: 10px; width: 100%;}
</style>
<!-- 校验需要加入的代码 -->
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.js"></script>
<script src="js/jquery.validate.extend.js"></script>
<link href="css/validate.css" rel="stylesheet" type="text/css" />
<script>
$(document).ready(function() {
    $("#loginForm").validate({
        rules: {
            userName: {
        		required: true
      				},
      		userPwd: {
        		required: true
      				},
        		},
       	 messages:{
            userName: {
        		required: "请输入用户名"
      					},
      	    userPwd: {
        		required: "请输入密码"
              		 }
        		}
    		});
		});
</script>
</head>

<body>
<div id="div1">
	<h3>添加管理员</h3>
	<form id="loginForm" name="loginForm" action="addUser.do" method="post">
    	<table id="table1">
        	<tr>
            	<td width="30%">管理员姓名：</td>
                <td width="70%"><input id="userName" name="user.name" type="text" class="item-text" /></td>
            </tr>
        	<tr>
            	<td width="30%">管理员密码：</td>
                <td width="70%"><input id="userPwd" name="user.pwd" type="text" class="item-text" /></td>
            </tr>
        	<tr>
            	<td>&nbsp;</td>
                <td><input name="" type="submit" value="确定" /><input name="" type="reset" value="重置" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>


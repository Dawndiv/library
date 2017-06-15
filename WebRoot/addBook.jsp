<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>福州市数字图书馆系统</title>
<style type="text/css">
body { font: 12px 宋体;}
#div1 { width: 80%; margin: auto; border: #000 solid 1px;}
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
    $("#form1").validate({
        rules: {
            bookNo: {
                required: true
            },
            bookName: {
                required: true
            },
            bookType: {
                min : 1
            },
            price: {
                number: true
            },
			quantity: {
				digits: true
			}
        },
        messages:{
            bookNo: {
                required: "书籍编号不能为空"
            },
            bookName: {
                required: "书籍名称不能为空"
            },
            bookType: {
                min: "请选择类别"
            },
            price: {
                number: "价格必须是数字"
            },
			amount: {
                digits: "数量必须是整数"
            }
        }
    });
});
</script>
</head>

<body>
<div id="div1">
	<h3>添加图书</h3>
	<form id="form1" name="form1" action="addBook.do" method="post">
    	<table id="table1">
        	<tr>
            	<td width="15%">书籍编号：</td>
                <td width="35%"><input id="bookNo" name="book.no" type="text" class="item-text" /></td>
            	<td width="15%">书籍名称：</td>
                <td width="35%"><input id="bookName" name="book.name" type="text" class="item-text" /></td>
            </tr>
        	<tr>
            	<td>类别：</td>
                <td>
                	<select id="bookType" name="book.type.id" class="item-select">
                    	<option value="0">---请选择---</option>
                    	<c:forEach items="${typeList }" var="type">
                        <option value="${type.id }">${type.name }</option>
                        </c:forEach>
                    </select>
                </td>
            	<td>作者：</td>
                <td><input id="author" name="book.author" type="text" class="item-text" /></td>
            </tr>
        	<tr>
            	<td>价格：</td>
                <td><input id="price" name="book.price" type="text" class="item-text" /></td>
            	<td>数量：</td>
                <td><input id="amount" name="book.amount" type="text" class="item-text" /></td>
            </tr>
        	<tr>
            	<td>出版社：</td>
                <td><input name="book.publisher" type="text" class="item-text" /></td>
            	<td>备注：</td>
                <td><input name="book.remark" type="text" class="item-text" /></td>
            </tr>
        	<tr>
            	<td>&nbsp;</td>
                <td><input name="submit" type="submit" value="确定"  /><input name="submit" type="submit" value="重置" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

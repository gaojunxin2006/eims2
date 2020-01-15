<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="proPath" value="${pageContext.request.contextPath}" />
<%@ include file="common/common.jspf"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>



<title>用户登陆页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


	<script type="text/javascript">
			$(function(){
				$('#dd').dialog({
					title: '请输入账号密码登陆',
					width: 350,
					height: 200,
					closed: false,
					cache: false,
					// href: 'get_content.php',
					modal: true,
					buttons:[{
						text:'登陆',
						handler:function(){
							//alert('提交登陆');
							//启用验证
							$('#ff').form("enableValidation");
							//进行验证，如果通过（返回true)提交表单
							if($('#ff').form('validate')){
								$('#ff').submit();
							}
						}
					},{
						text:'重置',
						handler:function(){
							//alert('重置表单');
							$('#ff').form("reset");
						}
					}]
				});
				//禁用表单验证
				$('#ff').form("disableValidation");

			});
</script>




</head>



<div id="dd">
	<form id="ff" action="${proPath}/account/login.do" method="post">
		<br>
		<div>
			<label for="name">账号:</label>
			<input class="easyui-validatebox" type="text" name="accLogin" data-options="required:true" />
		</div>
		<br>
		<div>
			<label for="email">密码:</label>
			<input class="easyui-validatebox" type="password" name="accPass" data-options="required:true" />
		</div>
		<br>
		<div style="color:red" >${requestScope.errMsg}</div>
	</form>
</div>






</body>
</html>
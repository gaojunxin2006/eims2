<%--
  Created by IntelliJ IDEA.
  User: wii
  Date: 2020/1/3
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="proPath" value="${pageContext.request.contextPath}" />
<%@ include file="../../common/common.jspf"%>



<html>
<head>
    <title>添加供应商</title>
</head>
<body>


<h2>添加供应商</h2>

<br>

<hr>
<form id="ff" method="post">
    <div>
        <label for="supId">供应商编号:</label> <input type="text" name="supId" />
    </div>
    <div>
        <label for="supName">供应商:</label> <input type="text" name="supName" />
    </div>
    <div>
        <label for="supLinkman">联系人:</label> <input type="text"
                                                    name="supLinkman" />
    </div>
    <div>
        <label for="supPhone">联系电话:</label> <input type="text"
                                                   name="supPhone" />
    </div>

    <div>
        <label for="supType">供应商类型：</label>
        <select id="cc" class="easyui-combobox" name="supType" style="width:200px;">
            <c:forEach items="${applicationScope.sysParam.supType}" var="supType">
                <option value="${supType.key}">${supType.value}</option>
            </c:forEach>
        </select>
    </div>

    <div>
        <input id="btn" type="button" value="提交" />
    </div>
</form>


<!-- 校验表单 -->
<script type="text/javascript">
    $(function() {
        var win = parent.$("iframe[title='供应商管理']").get(0).contentWindow;//返回ifram页面文档（window)

        $("[name='supName']").validatebox({
            required : true,
            missingMessage : '请填写供应商！'
        });

        //禁用验证
        $("#ff").form("disableValidation");

        $("#btn").click(function() {
            alert("开始校验");
            $("#ff").form("enableValidation");
            if ($("#ff").form("validate")) {
                alert("------------");
                $('#ff').form('submit', {
                    url : '${proPath}/supplier/insert.action',
                    onSubmit : function() {
                        return true;
                    },
                    success : function(count) {
                        //可以定义为对应消息框
                        if(count>0){
                            alert("供应商添加成功");
                        }else{
                            alert("供应商添加失败");
                        }

                        //关掉弹出的窗口
                        parent.$("#win").window("close");

                        //刷新父窗体
                        win.$("#dg").datagrid("reload");
                    }
                });

            }

        });

    });
</script>


</body>
</html>

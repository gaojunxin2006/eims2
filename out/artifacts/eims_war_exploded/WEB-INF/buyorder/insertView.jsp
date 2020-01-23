<%--
  Created by IntelliJ IDEA.
  User: wii
  Date: 2020/1/14
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="proPath" value="${pageContext.request.contextPath}" />
<%@ include file="../../common/common.jspf"%>
<html>
<head>
    <title>采购管理</title>
</head>
<script type="text/javascript">

    $(function () {

        $("#dg").datagrid({


            //加载的json文件路径
            //单条件
            <%--url:'${proPath}/supplier/selectPage.do',--%>

            //多条件
            <%--url:'${proPath}/supplier/selectPageDy.do',--%>

            //显示斑马线效果，隔行变色
            striped:true,

            //指明那个一字段是标识字段
            idField:'goodsId',

            //加载信息
            loadMsg:'加载中，请稍等。。。。',

            //分页
            pagination:true,

            //表格自动填充显示
            fitColumns:true,

            //分页默认下拉页数
            pageSize:5,

            //设置分页属性初始化页面大小选择列表
            // pageList:[2,5,10,15],

            //显示行号
            rownumbers:true,


            //请求远程数据的发送额外参数
            // queryParams:{
            //
            //     // name:'easyui',
            //     // subject:'datagrid'
            //     // keyWord:'%%'
            //
            // },



            //增删该查工具条按钮
            toolbar:[

                {
                    iconCls: 'icon-add',
                    text:'添加商品',
                    handler:function () {


                        //用main.jsp 中 添加div方式
                        <%--window.location.href="${proPath}/supplier/add.do";--%>


                        parent.$('#win').window({

                            title:'选择商品',
                            width:600,
                            height:400,
                            modal:true,

                            content:"<iframe src='${proPath}/base/goURL/goods/select.do' title='选择商品' height='100%' width='100%' frameborder='0px' ></iframe>"


                        })


                    }
                },
                '-',

                {
                    iconCls: 'icon-edit',
                    text:'删除商品',
                    handler: function () {

                        //获取选中的行
                        var rows=$('#dg').datagrid('getSelections');

                        if (rows.length!=1){

                            alert("请选择,并且只能选择一条修改记录！");

                            return false;
                        }
                        parent.$('#win').window({

                            title:'修改供应商',
                            width:600,
                            height: 400,
                            modal: true,
                            content:"<iframe src='${proPath}/base/goURL/supplier/edit.action' title='编辑供应商' height='100%' width='100%' frameborder='0px' ></iframe>"




                        })




                    }
                },

                '-',


                {
                    iconCls: 'icon-remove',
                    text: '提交入库',
                    handler: function () {
                        // alert('删除按钮')

                        /*
                            需要完成的事情
                            1.获取选中的行，判断是否选中
                            2.获取行记录的id。获取id数组
                            3.弹出删除提示。确认操作
                            4.提交删除请求
                            5.成功刷新页面（列表部分，异步刷新）

                         */


                    }
                }

            ],


            //展示json的格式
            columns:[[

                //每行的单选框
                {checkbox:true},
                // {field:'productid',title:'Code',width:100},
                // {field:'productname',title:'Name',width:100},
                // {field:'unitcost',title:'Price',width:100,align:'right'}
                {field:'goodsId',title:'商品商编号',width:100},
                {field:'goodsName',title:'商品名称',width:100},
                {field:'goodsType',title:'类型',width:100},
                {field:'goodsColor',title:'颜色',width:100},
                {field:'goodsRemark',title:'备注',width:100},
                {field:'createTimeString',title:'添加时间',width:100},
                {field:'bodAmount',title:'仓库',width:100},
                {field:'bodBuyPrice',title:'价格',width:100}
            ]]
        });



        // 生成搜索框
        $('#ss').searchbox({


            searcher:function (value,name) {

                // alert(value+","+name)

                $('#dg').datagrid('load',{

                    keyWord:'%'+value+"%"
                })

            },

            prompt:'请输入供应商名称'

        });


        //搜索框，点击弹出供应商搜索页面

        $('#supName').searchbox({

            searcher:function (value,name) {
                parent.$('#win').window({

                        title:'选择供应商',
                        width:600,
                        height: 400,
                        modal: true,
                        content:"<iframe src='${proPath}/base/goURL/supplier/select.action' title='选择供应商' height='100%' width='100%' frameborder='0px' ></iframe>"
                })

            },
            prompt: '请选择供应商'


        });
    });









</script>




</head>



<body>



<form action="" id="ff">

    请填写采购信息：<br>
    供应商：
    <input type="text" id="supId" name="supId"/>
    <input type="text" id="supName" name="supName"/>
    仓库：<input type="text" id="shId" name="shId"/>
    日期：<input  type="text" id="boDate"
               class="easyui-datebox" name="boDate" required="required"></input>

    应付：<input type="text" id="boPayable" name="boPayable"/><br>
    已付：<input type="text" id="boPaid" name="boPaid"/>
    欠款：<input type="text" id="boArrears" name="boArrears"/>
    原始单号：<input type="text" id="boOriginal" name="boOriginal"/><br>
    经手人：<input type="text" id="boAttn" name="boAttn"/>
    操作员：<input type="text" id="boOperator" name="boOperator"/>
    备注：<input type="text" id="boRemark" name="boRemark"/>

<table id="dg"/>




</form>

















</table>



</body>
</html>

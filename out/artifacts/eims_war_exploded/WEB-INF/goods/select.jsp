<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="proPath" value="${pageContext.request.contextPath}" />
<%@ include file="../../common/common.jspf"%>

<html>


<head>

    <title>商品明细页面</title>

    <script type="text/javascript">



        function formatterdate(val, row) {
            if (val==null)
                return '';
            var format = 'yyyy-MM-dd hh:mm';
            var d = new Date(val.time);
            return d.format(format);
        };

        $(function () {
            var win = parent.$("iframe[title='商品入库']").get(0).contentWindow;//返回ifram页面文档（window)

            $("#dg").datagrid({


                //加载的json文件路径
                //单条件
                url:'${proPath}/goods/selectPageUseDyc.do',

                //多条件
                <%--url:'${proPath}/supplier/selectPageDy.do',--%>

                //显示斑马线效果
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
                pageList:[2,5,10,15],

                //显示行号
                rownumbers:true,

                //只能选中一行，单选
                singleSelect:true,


                //增删该查工具条按钮
                toolbar:[

                    {
                        iconCls: 'icon-add',
                        text:'添加入库',
                        handler:function () {


                            //用main.jsp 中 添加div方式
                            <%--window.location.href="${proPath}/supplier/add.do";--%>

                            //判断是否选中
                            var row=$('#dg').datagrid("getSelected");

                            if (row==null){

                                alert("请选择需要入库的商品");
                                return false;
                            }
                            alert(row.goodsId+"|"+row.goodsColor);

                            win.$('#dg').datagrid('appendRow',{

                                goodsId:row.goodsId,
                                goodsName:row.goodsName,
                                goodsType:row.goodsType,
                                goodsColor:row.goodsColor

                            });

                            //关闭父窗体
                            parent.$('#win').window("close");

                        }
                    },
                    '-',



                    {
                        iconCls: 'icon-search',
                        text: '<input id="goodsName" type="text" name="goodsName"/>',

                        handler:function () {
                            // alert('搜索')
                        }
                    },


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

                    {field:'goodsSelPrice',title:'价格',width:100},

                    {field:'createTimeString',title:'添加时间',width:100}

                ]]


            });



            // 生成搜索框
            $('#goodsName').searchbox({


                searcher:function (value,name) {

                    // alert(value+","+name)

                    $('#dg').datagrid('load',{

                        keyWord:'%'+value+"%"

                    })

                },

                prompt:'请输入供应商名称'

            });






        });







    </script>




</head>



<body>



<table id="dg">


</table>

<form action="">
    数量：<input type="text" name=""><br>
    价格:<input type="text" name=""><br>
    串号:<input type="text" name=""><br>


</form>

</body>
</html>

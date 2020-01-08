<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="proPath" value="${pageContext.request.contextPath}" />
<%@ include file="../../common/common.jspf"%>

<html>


<head>

    <title>供应商明细页面</title>

    <script type="text/javascript">

        $(function () {

            $("#dg").datagrid({


                //加载的json文件路径
                url:'${proPath}/datagrid.json',


                //显示斑马线效果
                striped:true,

                //指明那个一字段是标识字段
                idField:'productid',

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


                //请求远程数据的发送额外参数
                // queryParams:{
                //
                //     name:'easyui',
                //     subject:'datagrid'
                //
                // },



                //增删该查工具条按钮
                toolbar:[

                    {
                        iconCls: 'icon-add',
                        text:'添加',
                        handler:function () {
                            alert('添加按钮')
                        }
                    },
                    '-',

                    {
                    iconCls: 'icon-edit',
                        text:'编辑',
                    handler: function () {
                        alert('编辑按钮')
                        }
                    },

                    '-',


                    {
                        iconCls: 'icon-remove',
                        text:'删除',
                        handler: function () {
                            alert('删除按钮')
                        }
                    },

                    '-',


                    {
                    iconCls: 'icon-search',
                        text: '<input id="ss" type="text" name="supName"/>',
                    handler:function () {
                     // alert('搜索')
                        }
                },


                    '-',


                    {
                        iconCls: 'icon-help',
                        handler:function () {
                            alert('帮助按钮')
                        }
                    }


                ],


                //展示json的格式
                columns:[[

                    //每行的单选框
                    {checkbox:true},
                    {field:'productid',title:'Code',width:100},
                    {field:'productname',title:'Name',width:100},
                    {field:'unitcost',title:'Price',width:100,align:'right'}


                ]]


            });



            //生成搜索框
            $('#ss').searchbox({

                searcher:function (value,name) {

                    alert(value+","+name)

                },

                prompt:'搜索内容'



            });





        });








    </script>




</head>



<body>

    供应商明细页面

    <table id="dg">










    </table>



</body>
</html>

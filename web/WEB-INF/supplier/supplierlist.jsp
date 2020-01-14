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
                //单条件
                url:'${proPath}/supplier/selectPage.do',

                //多条件
                <%--url:'${proPath}/supplier/selectPageDy.do',--%>

                //显示斑马线效果
                striped:true,

                //指明那个一字段是标识字段
                idField:'supId',

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
                //     // name:'easyui',
                //     // subject:'datagrid'
                //     // keyWord:'%%'
                //
                // },



                //增删该查工具条按钮
                toolbar:[

                    {
                        iconCls: 'icon-add',
                        text:'添加',
                        handler:function () {


                            //用main.jsp 中 添加div方式
                            <%--window.location.href="${proPath}/supplier/add.do";--%>


                            parent.$('#win').window({

                                title:'添加供应商',
                                width:600,
                                height:400,
                                modal:true,

                                content:"<iframe src='${proPath}/base/goURL/supplier/add.action' title='添加供应商' height='100%' width='100%' frameborder='0px' ></iframe>"


                            })


                        }
                    },
                    '-',

                    {
                    iconCls: 'icon-edit',
                        text:'编辑',
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
                        text:'删除',
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

                            //第一步
                            //获取行id数组
                            var rows=$("#dg").datagrid("getSelections");


                            //判断选中
                            if (rows.length==0){

                                //弹出信息
                                alert("请选择需要删除的记录！")

                                return false;


                            }


                            //第二步，获取行的id

                            var ids=new Array();    //定义一个数组

                            for(var i=0;i<rows.length;i++){

                                // alert(rows[i].supId);

                                ids[i]=rows[i].supId;


                            }


                            //第三步弹出删除对话框
                           parent.$.messager.confirm('删除对话框', '您确认要删除吗？', function(r) {
                                if (r) {
                                    // alert(r);
                                    $.ajax({
                                        url: "${proPath}/supplier/deleteList.action",
                                        type:"POST",
                                        //设置为传统方式传送参数
                                        traditional:true,
                                        data:{ids,ids},
                                        success: function(html){
                                            if(html>0){
                                                alert("恭喜您，删除成功，共删除了"+i+"条记录！");
                                            }else{
                                                alert("对不起，删除失败，请联系管理员！");
                                            }
                                            //重新刷新页面
                                            $("#dg").datagrid("reload");
                                            //请除所有勾选的行
                                            $("#dg").datagrid("clearSelections");
                                        },
                                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                                            $.messager.alert('删除错误','请联系管理员！','error');
                                        },
                                        dataType:'json'
                                    });
                                }
                            });


                        }
                    },

                    '-',


                    {
                    iconCls: 'icon-search',
                        text: '<input id="ss" type="text" name="keyWord"/>',


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
                    // {field:'productid',title:'Code',width:100},
                    // {field:'productname',title:'Name',width:100},
                    // {field:'unitcost',title:'Price',width:100,align:'right'}

                    {field:'supId',title:'供应商编号',width:100},
                    {field:'supName',title:'供应商名称',width:100},
                    {field:'supLinkman',title:'联系人',width:100},
                    {field:'supPhone',title:'电话',width:100},
                    {field:'supAddress',title:'地址',width:100},
                    {field:'supRemark',title:'供应商类型',width:100}



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






        });








    </script>




</head>



<body>

    供应商明细页面

    <table id="dg">











    </table>



</body>
</html>

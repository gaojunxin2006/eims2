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


                //限定只能单选
                singleSelect:true,





                //增删该查工具条按钮
                toolbar:[

                    {
                        iconCls: 'icon-ok',
                        text:'确定',
                        handler:function () {


                            //如果等于选中状态
                          var row=$('#dg').datagrid("getSelected");

                            alert('获取到了变量'+row);

                            if(row==null){

                                alert('请选择一个供应商');
                                return false;
                            };

                          //把id写回到form表单的供应商位置
                            win.$('#ff').form("load",{

                                supId:row.supId,
                                supName:row.supName

                            });
                            win.$('#supName').val(row.supName);

                            //关闭次窗口
                            parent.$('#win').window("close");
                        }
                    },
                    '-',


                    {
                    iconCls: 'icon-search',
                        text: '<input id="supName" type="text" name="supName"/>',


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

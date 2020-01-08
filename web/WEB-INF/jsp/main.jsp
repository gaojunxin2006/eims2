<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="proPath" value="${pageContext.request.contextPath}" />
<%@ include file="../../common/common.jspf"%>

<html>


<head>

    <title>进销存管理系统</title>


    <script type="text/javascript">

        $(function () {

            $("a[title]").click(function () {

                var title=this.title;

                var text=this.href;

                // alert("打开标签"+title);

                //如果已经打开标签，那么不在重新打开

                if ($('#tt').tabs("exists",title)){


                    $("#tt").tabs("select",title)



                    //如果没有标签，就添加一个标签显示
                }else {

                    $('#tt').tabs('add',{

                        title:title,
                        selected:true,
                        closable:true,

                        //把页面内容嵌套在标签中
                        content:"<iframe src='"+text+"' title='"+this.title+"' height='100%' width='100%' frameborder='0px' ></iframe>"

                    })


                }

                //不要跳转到新的页面，只在标签中显示
                return false;





            })




        });






    </script>


</head>



<body class="easyui-layout">


<div data-options="region:'north',title:'进销存系统',split:true" style="height:150px;">

    欢迎您：${sessionScope.user.accName}



</div>



<div data-options="region:'west',title:'导航菜单',split:true" style="width:180px;">

    <div id="aa" class="easyui-accordion" style="width:300px;height:200px;">

        <div title="基础数据录入">
            <!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
            <ul style="list-style: none;padding: 0px;margin:0px;">
                <li style="padding: 6px;"><a href="${proPath}/base/goURL/supplier/supplierlist.do" title="供应商管理"
                                             style="text-decoration: none;display: block;font-weight:bold;" onclick="">供应商管理</a>
                </li>
                <li style="padding: 6px;"><a href="${proPath}/base/goURL/goods/goodslist.action" title="商品管理"
                                             style="text-decoration: none;display: block;font-weight:bold;" >商品管理</a>
                </li>
            </ul>
        </div>

        <div title="进货管理">
            <!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
            <ul style="list-style: none;padding: 0px;margin:0px;">
                <li style="padding: 6px;"><a href="#" title="商品进货"
                                             style="text-decoration: none;display: block;font-weight:bold;">商品进货</a>
                </li>
                <li style="padding: 6px;"><a href="#" title="商品退货"
                                             style="text-decoration: none;display: block;font-weight:bold;" >商品管理</a>
                </li>
            </ul>
        </div>

        <div title="仓库管理">
            <!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
            <ul style="list-style: none;padding: 0px;margin:0px;">
                <li style="padding: 6px;"><a href="#" title="供应商管理"
                                             style="text-decoration: none;display: block;font-weight:bold;">供应商管理</a>
                </li>
                <li style="padding: 6px;"><a href="#" title="商品管理"
                                             style="text-decoration: none;display: block;font-weight:bold;" >商品管理</a>
                </li>
            </ul>
        </div>





        <div title="Title2" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">
            content2
        </div>
        <div title="Title3">
            content3
        </div>
    </div>


</div>






<!-- ------------------------------------主要内容展示区域---------------------------------------------------- -->

<div data-options="region:'center',title:'主要内容'" style="padding:5px;background:#eee;">

<!--data-options="fit:true" 全屏显示 -->
    <div id="tt" class="easyui-tabs" data-options="fit:true" style="width:500px;height:250px;">
        <div title="系统简介" style="padding:20px;">
            XXX进销存系统。。。。。。
        </div>

        <div title="功能描述" style="padding:20px;">
            功能描述。。。。。。
        </div>
    </div>






</div>



</body>
</html>

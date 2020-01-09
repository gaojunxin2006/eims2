package cn.linguo.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者：高俊欣
 * 日期：2020/1/9
 * 微信：15000952623
 **/


@WebServlet(name = "/sysParamServlet")
public class SysParamServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {

        System.out.println("SysParamServlet  初始化已执行。。。。。。。");

        Map<String,Object> sysParamMap=new HashMap<String, Object>();

        Map<String,String> supTypeMap=new HashMap<String, String>();

        supTypeMap.put("1","一级供应商");
        supTypeMap.put("2","二级供应商");
        supTypeMap.put("3","普通供应商");

        sysParamMap.put("supType",supTypeMap);


        Map<String,String> goodsClolrMap=new HashMap<String, String>();

        goodsClolrMap.put("1","红色");
        goodsClolrMap.put("2","蓝色");
        goodsClolrMap.put("3","绿色");

        sysParamMap.put("goodsColor",goodsClolrMap);


        //加入到servlet域中
        getServletContext().setAttribute("sysParam",sysParamMap);

//        getServletContext().setAttribute("names","扎木斯");


        System.out.println("=====================系统参数加载完成===============================");





    }





}

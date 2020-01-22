package cn.linguo.action;

import cn.linguo.entity.Goods;
import cn.linguo.entity.Page;
import cn.linguo.service.IGoodsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 开发者：高俊欣
 * 日期：2020/1/21
 * 微信：15000952623
 **/


@Controller
@RequestMapping("/goods")
public class GoodsAction {

@Resource
private IGoodsService goodsService;



//查询所有商品
    @RequestMapping("/selectPageUseDyc")
    @ResponseBody
    public Object selectPageUserDyc(Page<Goods> page,Goods goods){

        System.out.println("GoodsAction 查询所有方法已经执行。。。。。。。。");

        System.out.println("GoodsAction 传入的分页信息：\t"+page);

        com.baomidou.mybatisplus.extension.plugins.pagination.Page mpPage=
                new com.baomidou.mybatisplus.extension.plugins.pagination.Page(page.getPage(),page.getRows());


        IPage iPageList = goodsService.getBaseMapper().selectPage(mpPage, null);


        List records = iPageList.getRecords();

        records.forEach(System.out::println);


        Page<Goods> page2=new Page<>();
        page2.setPageList(records);
        page2.setTotalRecord(new Long(iPageList.getTotal()).intValue());

        System.out.println("GoodsAction \t"+page2.getPageMap());

        return page2.getPageMap();
    }






}

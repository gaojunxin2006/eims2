package cn.linguo.test.mp;

import cn.linguo.entity.Mp;
import cn.linguo.mapper.GoodsMapper;
import cn.linguo.mapper.MpMapper;
import cn.linguo.service.IUserService;
import cn.linguo.service.MpService;
import cn.linguo.service.SupplierService;
import cn.linguo.service.impl.MpServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * 开发者：高俊欣
 * 日期：2020/1/19
 * 微信：15000952623
 **/


public class ServiceMpTest {

    //实现serivce接口

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    private MpService service  = ioc.getBean("mpService", MpService.class);






    //查询
    @Test
    public void getOne(){

        Mp one = service.getOne(Wrappers.<Mp>lambdaQuery().gt(Mp::getAge, 25), false);


        List<Mp> list = service.list();


        System.out.println(one);

        list.forEach(System.out::println);

    }



    //批量插入
    @Test
    public void batch(){

        Mp mp1=new Mp();
        mp1.setStudentName("混江龙-李俊");
        mp1.setAge(40);

        Mp mp2=new Mp();
        mp2.setUserId(1219088176300163074l);
        mp2.setStudentName("行者-武松");
        mp2.setAge(29);


        List<Mp> mpList = Arrays.asList(mp1, mp2);

        //批量插入
//        boolean b = service.saveBatch(mpList);

        //修改插入，根据设定的id修改
        boolean b = service.saveOrUpdateBatch(mpList);


        if (b){

            System.out.println(b+"数据插入成功！");

        }

    }




    //lambda 条件查询
    @Test
    public void chain(){


        List<Mp> mpList = service.lambdaQuery().gt(Mp::getAge, 25).like(Mp::getStudentName, "雨").list();

        mpList.forEach(System.out::println);



    }


    //lambda 更新
    @Test
    public void lambdaUpdate(){


        boolean b = service.lambdaUpdate().eq(Mp::getStudentName, "行者-武松").set(Mp::getStudentName, "武松").update();

        if (b){

            System.out.println(b+"数据修改成功！");

        }


    }



    //lambda 删除
    @Test
    public void lambdaRemove(){


        boolean b = service.lambdaUpdate().eq(Mp::getUserId, 20200120l).remove();

        if (b){

            System.out.println(b+"删除成功！");

        }


    }

}

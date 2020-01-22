package cn.linguo.test.mp;

import cn.linguo.mapper.MpMapper;
import cn.linguo.service.MpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 开发者：高俊欣
 * 日期：2020/1/21
 * 微信：15000952623
 **/


public class injectorTest {


    //实现serivce接口

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    private MpService service  = ioc.getBean("mpService", MpService.class);

    private MpMapper mapper=ioc.getBean("mpMapper",MpMapper.class);


    @Test
    public void deleteAll(){

        int i = mapper.lg_deleteAll();

        if (i!=0){

            System.out.println("你删除了所有数据！");
        }


    }







}

package cn.linguo.test.mp;

import cn.linguo.entity.Mp;
import cn.linguo.mapper.MpMapper;
import cn.linguo.service.MpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 开发者：高俊欣
 * 日期：2020/1/20
 * 微信：15000952623
 **/


public class OptTest {

    //乐观锁


    //实现serivce接口

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    private MpService service  = ioc.getBean("mpService", MpService.class);



    @Test
    public void updateByid(){

        int version=1;

        Mp mp1=new Mp();
        mp1.setStudentName("李刚");
        mp1.setUserId(1094592041087729681l);
        mp1.setVersion(version);

        int i = service.getBaseMapper().updateById(mp1);

        System.out.println(i+"更新了记录！");




    }






}

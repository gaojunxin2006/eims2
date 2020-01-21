package cn.linguo.test.mp;

import cn.linguo.entity.Mp;
import cn.linguo.mapper.MpMapper;
import cn.linguo.service.MpService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 开发者：高俊欣
 * 日期：2020/1/20
 * 微信：15000952623
 **/


public class MylogicTest {



    //实现serivce接口

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    private MpService service  = ioc.getBean("mpService", MpService.class);

    private MpMapper mapper=ioc.getBean("mpMapper",MpMapper.class);



    //逻辑删除混江龙
    @Test
    public void deleteByid(){

        //service模式
        int i = service.getBaseMapper().deleteById(1219088606971396097l);

        if (i!=0){

            System.out.println(i+"删除了记录！");
        }


//        int i = mapper.deleteById(1219088606971396097l);
//
//        System.out.println("删除了"+i+"条记录！");


    }



    //查询全部，但是逻辑删除的数据 已经查询不到了。
    @Test
    public void select(){


        List<Mp> list = service.getBaseMapper().selectList(null);


        list.forEach(System.out::println);


    }



    //更新，只能更新逻辑未删除的数据
    @Test
    public void updateByid(){

        Mp mp1=new Mp();
        mp1.setAge(30);
        mp1.setUserId(1219088606971396097l);

        service.getBaseMapper().updateById(mp1);


    }




    //测试自定义sql语句
    @Test
    public void mySelect(){


        List<Mp> list = service.mySelectList(Wrappers.<Mp>lambdaQuery().gt(Mp::getAge, 25)
            .eq(Mp::getDeleted,0));

        list.forEach(System.out::println);


    }



    //测试插入自动填充方法
    @Test
    public void insert(){

        Mp mp1=new Mp();
        mp1.setStudentName("青面兽-杨志");
        mp1.setAge(36);
        mp1.setEmail("yangzhi@linguo.cn");

        Mp mp = service.getBaseMapper().selectById(1087982257332887553l);

        mp1.setManagerId(mp.getUserId());

        int i = service.getBaseMapper().insert(mp1);

//        int i = mapper.insert(mp1);


        System.out.println(i+"插入了记录！");

    }



    //测试更新自动填充方法
    @Test
    public void update(){

        Mp mp1=new Mp();
        mp1.setStudentName("清官-李刚");
        mp1.setUserId(1094592041087729681l);


        int i = service.getBaseMapper().updateById(mp1);


        System.out.println(i+"更新了记录！");

    }


    //测试插入自动填充方法，加入了判断是否有属性条件
    @Test
    public void insert2(){

        Mp mp1=new Mp();
        mp1.setStudentName("霹雳火-秦明");
        mp1.setAge(22);
        mp1.setEmail("qinming@linguo.cn");

        Mp mp = service.getBaseMapper().selectById(1087982257332887553l);

        mp1.setManagerId(mp.getUserId());

        int i = service.getBaseMapper().insert(mp1);


        System.out.println(i+"插入了记录！");

    }



    //手动更新时设置自动填充
    @Test
    public void updateAuto(){

        Mp mp1=new Mp();
        mp1.setStudentName("清官-李刚");
        mp1.setUserId(1094592041087729681l);
//        mp1.setUpdateTime(LocalDateTime.now());


        int i = service.getBaseMapper().updateById(mp1);


        System.out.println(i+"更新了记录！");

    }











}

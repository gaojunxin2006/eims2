package cn.linguo.test.mp;

import cn.linguo.entity.Mp;
import cn.linguo.mapper.GoodsMapper;
import cn.linguo.mapper.MpMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 作者：高俊欣
 * 日期：2020/1/19
 * 微信：15000952623
 **/


public class ARMpTest {

    //测试AR模式

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");


    private MpMapper mpMapper  = ioc.getBean("mpMapper", MpMapper.class);

    private GoodsMapper goodsMapper=ioc.getBean("goodsMapper", GoodsMapper.class);


    private QueryWrapper<Mp> queryWrapper=new QueryWrapper<>();






    //插入数据
    @Test
    public void insertMp(){

        Mp mp=new Mp();
        mp.setStudentName("张三丰");
        mp.setAge(46);
        mp.setEmail("zsf@qq.cn");
        mp.setManagerId(1094592041087729672l);
        mp.setCreateTime(LocalDateTime.now());

        //插入数据库
        boolean insert = mp.insert();


        //获取主键
        Long userId = mp.getUserId();

        if (insert){
            System.out.println("数据插入成功，共插入了:\t"+"\t条数据,并且该记录的主键是:\t"+userId);

        }



    }



    //插入2  .如果设置了id就执行update语句， 如果没有就执行插入语句
    @Test
    public void insertOrUpdate(){

        Mp mp=new Mp();
        mp.setUserId(1094592041087729680l);
        mp.setStudentName("五虎上将-黄忠");
        mp.setAge(52);
        mp.setEmail("hz@qq.cn");
        mp.setManagerId(1094592041087729672l);
        mp.setCreateTime(LocalDateTime.now());

        boolean b = mp.insertOrUpdate();

        //获取主键
        Long userId = mp.getUserId();

        if (b){
            System.out.println("数据插入成功，共插入了:\t"+"\t条数据,并且该记录的主键是:\t"+userId);

        }


    }





    //查询
    @Test
    public void selectById(){

        Mp mp=new Mp();
        Mp mp1 = mp.selectById(1094592041087729678l);
        System.out.println(mp1);


    }


    //查询所有
    @Test
    public void selectAll(){

        Mp mp=new Mp();
        List<Mp> list = mp.selectAll();

        list.forEach(System.out::println);



    }



    //查询
    @Test
    public void selectById2(){

        Mp mp=new Mp();
        mp.setUserId(1094592041087729678l);
        Mp mp1 = mp.selectById();
        System.out.println(mp1);


    }


    //更新
    @Test
    public void updateByid(){

        Mp mp=new Mp();
        mp.setUserId(1094592041087729678l);

        mp.setStudentName("五虎上将-马超");


        boolean update = mp.updateById();

        //获取主键
        Long userId = mp.getUserId();

        if (update){
            System.out.println("数据插入成功，共插入了:\t"+"\t条数据,并且该记录的主键是:\t"+userId);

        }


    }




    //删除
    @Test
    public void deleteByid(){
        Mp mp=new Mp();
        mp.setUserId(1094592041087729678l);

        boolean b = mp.deleteById();

        if (b){
            System.out.println("数据删除成功，共插入了:\t"+"\t条数据,并且该记录的主键是:\t");

        }

    }













}

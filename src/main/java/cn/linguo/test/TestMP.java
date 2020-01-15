package cn.linguo.test;

import cn.linguo.entity.Goods;
import cn.linguo.mapper.GoodsMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import javax.sql.DataSource;
import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * 作者：高俊欣
 * 日期：2020/1/15
 * 微信：15000952623
 **/


public class TestMP {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");


    private GoodsMapper goodsMapper = ioc.getBean("goodsMapper", GoodsMapper.class);


    @Test
    public void testDataSource() throws SQLException {

        DataSource dataSource = ioc.getBean("dataSource", DataSource.class);

        System.out.println("测试连接池 是否正常=====" + dataSource);

        Connection conn = dataSource.getConnection();

        System.out.println("测试连接池 ，获取链接 是否正常=====" + conn);

    }


    //测试通用插入操作

    @Test
    public void testCommonInsert() {

        System.out.println("向数据库插入一条数据！");

        Goods goods = new Goods();
        goods.setGoodsName("小米手机");
        goods.setGoodsColor("白色");
        goods.setGoodsType("手机");
        goods.setGoodsRemark("雷军");
        goods.setSalary(60000.0);


        //插入到数据库中
        Integer i = goodsMapper.insert(goods);

        if (i != 0) {
            System.out.println("在数据中插入了" + i + "条数据");

        }


        //获取当前数据在数据库中的主键值
        Integer key = goods.getGoodsId();
        System.out.println("插入数据的主键值是:\t" + key);


    }


//测试通用插入操作,3.x没这个方法


//通用更新操作

    @Test
    public void testAllCommonInsert() {

        System.out.println("修改数据库一条数据！");

        Goods goods = new Goods();
        goods.setGoodsId(5);
        goods.setGoodsRemark("任正非");
        goods.setGoodsName("雷米米手机");
        goods.setGoodsColor("绿色");
        goods.setGoodsType("华为手机");

        goods.setSalary(60000.0);


        //插入到数据库中
        Integer i = goodsMapper.updateById(goods);

        if (i != 0) {
            System.out.println("在数据中修改了" + i + "条数据");

        }


        //获取当前数据在数据库中的主键值
        Integer key = goods.getGoodsId();
        System.out.println("插入数据的主键值是:\t" + key);


    }


    //查询
    @Test
    public void selectGoods() {


        Goods goods = goodsMapper.selectById(5);

        System.out.println("查询的对象是：\t" + goods);


        Goods goods1 = new Goods();
        goods.setGoodsId(7);


        //第二种方法
//        Goods goods2 = goodsMapper.selectOne(new QueryWrapper<Goods>().lambda().eq(Goods::getGoodsId, 7));


        //查询多个id
        List<Integer> listId = Arrays.asList(6, 7, 8);

        List<Goods> goodsList = goodsMapper.selectBatchIds(listId);

        System.out.println("查询多个id结果是：\t" + goodsList);





        //查询map,这里需要key 写数据库的列名，不是实体类的

        Map<String,Object> columnMap=new HashMap<>();

//        columnMap.put("goods_name","雷米米手机");
        columnMap.put("goods_type","手机");

        List<Goods> goods2 = goodsMapper.selectByMap(columnMap);

        System.out.println("查询多个map结果是：\t" + goods2);


    }







    //使用条件构造器查询,多条件查询
    @Test
    public void selectByWrapper() {

        QueryWrapper<Goods> queryWrapper=new QueryWrapper<>();

        //like模糊查询，全部为数据库列名，lt小于
        queryWrapper.like("goods_name","note").lt("goods_Id",10);


        List<Goods> list = goodsMapper.selectList(queryWrapper);

        System.out.println("根据构造器查询出来的结果是:\t"+list);




    }


    //使用条件构造器查询,多条件查询
    @Test
    public void selectByWrapper2() {

        QueryWrapper<Goods> queryWrapper=new QueryWrapper<>();

        //like模糊查询，全部为数据库列名，id是 大于等于2 小于等于10，且颜色不能为空
        queryWrapper.like("goods_name","note").between("goods_Id",2,10).isNotNull("goods_color");


        List<Goods> list = goodsMapper.selectList(queryWrapper);

        System.out.println("根据构造器查询出来的结果是:\t"+list);




    }

    //使用条件构造器查询,多条件查询
    @Test
    public void selectByWrapper3() {

        QueryWrapper<Goods> queryWrapper=new QueryWrapper<>();

        //like模糊查询，全部为数据库列名，,名字已n开头，或者id是 大于等于2  ，按照价格升序降序，按照id升序
        queryWrapper.likeRight("goods_name","n").or().ge("goods_Id",2).orderByDesc("goods_buy_price").orderByAsc("goods_name");


        List<Goods> list = goodsMapper.selectList(queryWrapper);

        System.out.println("根据构造器查询出来的结果是:\t"+list);




    }



    //使用条件构造器查询,多条件查询
    @Test
    public void selectByWrapper4() {

        QueryWrapper<Goods> queryWrapper=new QueryWrapper<>();

        //创建日期是2020以前，并且直属上级是雷姓
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}","2019-03-15");
//        .inSql("manager_id","select goods_Id from goods where goods_remark like '雷%'");

        List<Goods> list = goodsMapper.selectList(queryWrapper);

        System.out.println("根据构造器查询出来的结果是:\t"+list);




    }



}
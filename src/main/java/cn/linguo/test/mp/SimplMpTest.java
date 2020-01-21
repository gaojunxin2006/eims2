package cn.linguo.test.mp;

import cn.linguo.entity.Goods;
import cn.linguo.entity.Mp;
import cn.linguo.mapper.GoodsMapper;
import cn.linguo.mapper.MpMapper;
import cn.linguo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：高俊欣
 * 日期：2020/1/16
 * 微信：15000952623
 **/




public class SimplMpTest {


    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");


    private MpMapper mpMapper  = ioc.getBean("mpMapper", MpMapper.class);

    //查询条件构造对象
    private QueryWrapper<Mp> queryWrapper=new QueryWrapper<>();


//查询全部
    @Test
    public void select(){


        List<Mp> mpList = mpMapper.selectList(null);

//        List<Goods> mpList=goodsMapper.selectList(null);


        System.out.println(mpList);


        Assert.assertEquals(5,mpList.size());

        mpList.forEach(System.out::println);




    }




    //插入数据
    @Test
    public void insertMp(){

        Mp mp=new Mp();
        mp.setStudentName("王二小");
        mp.setAge(6);
        mp.setEmail("wex@linguo.cn");
        mp.setManagerId(1087982257332887553l);
        mp.setCreateTime(LocalDateTime.now());


        int i = mpMapper.insert(mp);

        Long userId = mp.getUserId();


        System.out.println("数据插入成功，共插入了:\t"+i+"\t条数据,并且该记录的主键是:\t"+userId);


    }



    //根据主键查询
    @Test
    public void selectByid(){
        Mp mp = mpMapper.selectById("1094592041087729674");

        System.out.println(mp);


    }


    //map集合查询,key是列，不是实体的属性
    @Test
    public void selectMap() {

        Map<String,Object> map=new HashMap<>();

        map.put("age",25);

        List<Mp> mpList = mpMapper.selectByMap(map);


        mpList.forEach(System.out::println);



    }




    //list查询，条件构造器，都是列名
        //1、名字中包含雨并且年龄小于40
        //    name like '%雨%' and age<40
    @Test
    public void slectByWrapper(){


        queryWrapper.like("user_name","雨").lt("age",40);


        List<Mp> mpList = mpMapper.selectList(queryWrapper);

        mpList.forEach(System.out::println);


    }








    //   2、名字中包含雨年并且龄大于等于20且小于等于40并且email不为空
        // name like '%雨%' and age between 20 and 40 and email is not null
    @Test
    public void slectByWrapper2() {

        queryWrapper.like("user_name","雨").between("age",20,40).isNotNull("email");


        List<Mp> mpList = mpMapper.selectList(queryWrapper);

        mpList.forEach(System.out::println);



    }





//    3、名字为王姓或者年龄大于等于25，按照年龄降序排列，年龄相同按照id升序排列
//    name like '王%' or age>=25 order by age desc,id asc
    @Test
    public void slectByWrapper3() {

        queryWrapper.likeRight("user_name","王").or().ge("age",25).orderByDesc("age")
                .orderByAsc("user_id");



        List<Mp> mpList = mpMapper.selectList(queryWrapper);

        mpList.forEach(System.out::println);



    }







//4、创建日期为2019年2月14日并且直属上级为名字为王姓
//    date_format(create_time,'%Y-%m-%d')='2019-02-14' and manager_id in (select id from user where name like '王%')

  /*
   sql 完整写法：  SELECT * FROM lg_mp WHERE date_format(create_time,'%Y-%m-%d')='2019-02-14'
         and manager_id in (select user_id from lg_mp where user_name like '王%')
   */


    @Test
    public void slectByWrapper4() {


        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}","2019-02-14")
                .inSql("manager_id","select user_id from lg_mp where user_name like '王%'");



        List<Mp> mpList = mpMapper.selectList(queryWrapper);

        mpList.forEach(System.out::println);



    }




//5、名字为王姓并且（年龄小于40或邮箱不为空）
//    name like '王%' and (age<40 or email is not null)
    @Test
    public void slectByWrapper5() {


        queryWrapper.likeRight("user_name","王").and(wq->wq.lt("age",40).or().isNotNull("email"));


        List<Mp> mpList = mpMapper.selectList(queryWrapper);

        mpList.forEach(System.out::println);



    }




//    名字为王姓或者（年龄小于40并且年龄大于20并且邮箱不为空）
//    name like '王%' or (age<40 and age>20 and email is not null)
    @Test
    public void slectByWrapper6() {


        queryWrapper.likeRight("user_name","王").or(wq->wq.lt("age",40).gt("age",20)
        .isNotNull("email"));

        List<Mp> mpList = mpMapper.selectList(queryWrapper);

        mpList.forEach(System.out::println);



    }




    //   （年龄小于40或邮箱不为空）并且名字为王姓
    //    (age<40 or email is not null) and name like '王%'
    @Test
    public void slectByWrapper7() {


        queryWrapper.nested(qw->qw.lt("age",40).or().isNotNull("email")).likeRight("user_name","王");

        List<Mp> mpList = mpMapper.selectList(queryWrapper);

        mpList.forEach(System.out::println);



    }



//    年龄为30、31、34、35
//    age in (30、31、34、35)
    @Test
    public void slectByWrapper8() {


        queryWrapper.in("age", Arrays.asList(31,27,34,35));
        List<Mp> mpList = mpMapper.selectList(queryWrapper);

        mpList.forEach(System.out::println);



    }




//    9、只返回满足条件的其中一条语句即可
//    limit 1
    @Test
    public void slectByWrapper9() {


        queryWrapper.in("age", Arrays.asList(31, 27, 34, 35)).last("limit 1");
        List<Mp> mpList = mpMapper.selectList(queryWrapper);

        mpList.forEach(System.out::println);
    }





//10、名字中包含雨并且年龄小于40(需求1加强版)
//    第一种情况：select id,name
//    from user
//    where name like '%雨%' and age<40
//list查询，条件构造器，都是列名
//1、名字中包含雨并且年龄小于40
//    name like '%雨%' and age<40
@Test
public void slectByWrapper10(){


    queryWrapper.select("user_id","user_name","age").like("user_name","雨").lt("age",40);



    List<Mp> mpList = mpMapper.selectList(queryWrapper);

    mpList.forEach(System.out::println);


}

//排除字段 select写在前后都一样
    @Test
    public void slectByWrapper10_2(){


        queryWrapper.like("user_name","雨").lt("age",40).select(Mp.class,info->!info.getColumn().
                equals("create_time")&&!info.getColumn().equals("manager_id"));



        List<Mp> mpList = mpMapper.selectList(queryWrapper);

        mpList.forEach(System.out::println);


    }





    //测试传入有空的情况查询
    @Test
    public void testCondition(){


        String user_name="";
        String email="w";

        condition(user_name,email);


    }






    //传入实体的查询
    @Test
    public void slectByWrapperEntity(){

        Mp mp=new Mp();
        mp.setStudentName("令狐冲");
        mp.setAge(27);

        queryWrapper.setEntity(mp);


        Mp mp1 = mpMapper.selectOne(queryWrapper);

        System.out.println(mp1);


    }




    //AllEq
    @Test
    public void slectByWrapperAllEq(){


        Map<String,Object> params=new HashMap<>();

        params.put("user_name","王天风");
        params.put("age",null);

//        queryWrapper.allEq(params,false);

        //过滤
        queryWrapper.allEq((k,v)->!k.equals("user_name"),params);

        List<Mp> mpList = mpMapper.selectList(queryWrapper);

        mpList.forEach(System.out::println);


    }


    //selectMaps
    @Test
    public void slectByWrapperMaps(){


        queryWrapper.select("user_id","user_name").like("user_name","雨").lt("age",40);


        List<Map<String, Object>> maps = mpMapper.selectMaps(queryWrapper);

        maps.forEach(System.out::println);


    }




//    11、按照直属上级分组，查询每组的平均年龄、最大年龄、最小年龄。
//    并且只取年龄总和小于500的组。
//    select avg(age) avg_age,min(age) min_age,max(age) max_age
//    from lg_mp
//    group by manager_id
//    having sum(age) <500
    @Test
    public void slectByWrapperMaps2(){


       queryWrapper.select("avg(age) avg_age","min(age) min_age","max(age) max_age").groupBy("manager_id")
               .having("sum(age)<{0}",500);

        List<Map<String, Object>> lists = mpMapper.selectMaps(queryWrapper);

        lists.forEach(System.out::println);


    }




    //selectObjs 只返回一列
    @Test
    public void slectByWrapperObjs(){


        queryWrapper.select("user_id","age").like("user_name","雨").lt("age",40);

        List<Object> lists = mpMapper.selectObjs(queryWrapper);

        lists.forEach(System.out::println);


    }





    //查询总记录数
    @Test
    public void slectByWrapperCount(){


        queryWrapper.like("user_name","雨").lt("age",40);

        Integer integer = mpMapper.selectCount(queryWrapper);

        System.out.println("符合查询条件的总记录数:\t"+integer);

//        lists.forEach(System.out::println);


    }


    //selectOne
    @Test
    public void slectByWrapperselectOne(){


        queryWrapper.like("user_name","令狐冲").lt("age",40);

        Mp mp1= mpMapper.selectOne(queryWrapper);

        System.out.println("符合查询条件的总记录数:\t"+mp1);

//        lists.forEach(System.out::println);


    }


    //selectOne
    @Test
    public void slectLambda(){


        LambdaQueryWrapper<Mp> lambdaQueryWrapper1=new QueryWrapper<Mp>().lambda();

        LambdaQueryWrapper<Mp> lambdaQueryWrapper= Wrappers.<Mp>lambdaQuery();


        lambdaQueryWrapper.like(Mp::getStudentName,"雨").lt(Mp::getAge,40);


        List<Mp> mpList = mpMapper.selectList(lambdaQueryWrapper);

        mpList.forEach(System.out::println);


    }





//-------------------------------------------------------------------------------------------------------

    //使用自定义方法
    @Test
    public void slectMy(){

        LambdaQueryWrapper<Mp> lambdaQueryWrapper1=new QueryWrapper<Mp>().lambda();

        LambdaQueryWrapper<Mp> lambdaQueryWrapper= Wrappers.<Mp>lambdaQuery();


        lambdaQueryWrapper.like(Mp::getStudentName,"雨").lt(Mp::getAge,40);


        List<Mp> mpList = mpMapper.selectAll2(lambdaQueryWrapper);

        mpList.forEach(System.out::println);


    }

    //使用自定义方法 方法2使用xml文件
    @Test
    public void slectMy2(){

        LambdaQueryWrapper<Mp> lambdaQueryWrapper1=new QueryWrapper<Mp>().lambda();

        LambdaQueryWrapper<Mp> lambdaQueryWrapper= Wrappers.<Mp>lambdaQuery();


        lambdaQueryWrapper.like(Mp::getStudentName,"雨").lt(Mp::getAge,40);


        List<Mp> mpList = mpMapper.selectAll3(lambdaQueryWrapper);

        mpList.forEach(System.out::println);


    }



    //使用自定义方法 方法4使用xml文件
    @Test
    public void slectMy4(){

        List<Mp> list = mpMapper.selectAll4();

        list.forEach(System.out::println);


    }



    //使用自定义方法 方法5使用xml文件
    @Test
    public void slectMy5(){

        Mp mp = mpMapper.selectAll5(1094592041087729666l);

        System.out.println("使用自定义方法 方法5\t "+mp);


    }




//-------------------------------------------------------------------------------------------------------


    //分页查询
    @Test
    public void selectPage(){


        //年龄小于26
//        queryWrapper.lt("age",26);

        //年龄大于26
        queryWrapper.ge("age",26);

        Page<Mp> page = new Page<>(1, 2);

        IPage<Mp> iPage = mpMapper.selectPage(page, queryWrapper);

        System.out.println("总页数：\t"+iPage.getPages());
        System.out.println("总记录数：\t"+iPage.getTotal());

        List<Mp> mpList = iPage.getRecords();

        mpList.forEach(System.out::println);


    }




    //分页查询2
    @Test
    public void selectPage2() {

        //年龄大于26
        queryWrapper.ge("age",26);

        Page<Mp> page = new Page<>(1, 2,false);

        IPage<Map<String, Object>> mapIPage = mpMapper.selectMapsPage(page, queryWrapper);

        System.out.println("总页数：\t"+mapIPage.getPages());
        System.out.println("总记录数：\t"+mapIPage.getTotal());

        List<Map<String, Object>> mpList = mapIPage.getRecords();

        mpList.forEach(System.out::println);


    }


    //分页查询2
    @Test
    public void selectMyPage() {

        //年龄大于26
        queryWrapper.ge("age",26);

        Page<Mp> page = new Page<>(1,2);

        IPage<Mp> mpIPage = mpMapper.selectMpPage(page, queryWrapper);

        System.out.println("总页数：\t"+mpIPage.getPages());
        System.out.println("总记录数：\t"+mpIPage.getTotal());

        List<Mp> records = mpIPage.getRecords();

        records.forEach(System.out::println);


    }




    //-------------------------------------------------------------------------------------------------------
    //更新

   @Test
   public void updateByids(){

        Mp mp=new Mp();
        mp.setUserId(1094592041087729676l);
        mp.setAge(9);
        mp.setEmail("wex@qq.com");


       int i = mpMapper.updateById(mp);

       System.out.println("共更新了\t"+i+"条记录");


   }


   @Test
   public void updateByWrapper(){


       UpdateWrapper<Mp> updateWrapper=new UpdateWrapper<>();

       //设置查询的where条件
       updateWrapper.eq("user_name","令狐冲").eq("age",27);

       //更改令狐冲的邮箱
       Mp mp=new Mp();
       mp.setEmail("linghuchong@souhu.com");

       mp.setAge(28);

       int i = mpMapper.update(mp, updateWrapper);

       System.out.println("共更新了\t"+i+"条记录");



   }




    @Test
    public void updateByWrapper2(){

        //更改令狐冲的邮箱
        Mp whereM=new Mp();
        whereM.setStudentName("令狐冲");



        UpdateWrapper<Mp> updateWrapper=new UpdateWrapper<>();

        //设置查询的where条件
        updateWrapper.eq("age",27);


        whereM.setAge(28);

        int i = mpMapper.update(whereM, updateWrapper);

        System.out.println("共更新了\t"+i+"条记录");



    }




    //只更新部分字段，不去new对象
    @Test
    public void updateByWrapper3(){

        UpdateWrapper<Mp> updateWrapper=new UpdateWrapper<>();

        //设置查询的where条件
        updateWrapper.eq("user_name","令狐冲").eq("age",28).set("age",27);

        //更改令狐冲的邮箱
        Mp whereM=new Mp();


        whereM.setAge(28);

        int i = mpMapper.update(whereM, updateWrapper);

        System.out.println("共更新了\t"+i+"条记录");



    }



    //只更新部分字段  Lambda有防止误写功能
    @Test
    public void updateByWrapperLambda(){

        LambdaUpdateWrapper<Mp> lambdaQueryWrapper=Wrappers.<Mp>lambdaUpdate();

        //设置查询的where条件
        lambdaQueryWrapper.eq(Mp::getStudentName,"令狐冲").eq(Mp::getAge,27).set(Mp::getAge,31);

        //更改令狐冲的邮箱
        Mp whereM=new Mp();


        whereM.setAge(28);

        int i = mpMapper.update(whereM, lambdaQueryWrapper);

        System.out.println("共更新了\t"+i+"条记录");



    }





    //只更新部分字段  Lambda有防止误写功能。链式
    @Test
    public void updateByWrapperLambda2(){

        boolean reslt = new LambdaUpdateChainWrapper<Mp>(mpMapper).eq(Mp::getStudentName, "令狐冲").eq(Mp::getAge, 31).set(Mp::getAge, 27)
                .update();


       if (reslt){

           System.out.println("共更新了\t1"+"条记录");
       }




    }



//-------------------------------------------------------------------------------------------------------
    //删除

 @Test
 public void deleteByid(){

     int i = mpMapper.deleteById("1094592041087729667");

     System.out.println("删除\t"+i+"条记录");

 }



 //map删除,map内容相当于where条件
    @Test
    public void deleteByMap(){


        Map<String,Object> map=new HashMap<>();

        map.put("user_name","郭德纲");

        map.put("age","26");

        int i = mpMapper.deleteByMap(map);

        System.out.println("删除\t"+i+"条记录");

    }


    @Test
    //批量删除
    public void deleteBathids(){


        int i = mpMapper.deleteBatchIds(Arrays.asList(1094592041087729671l, 1094592041087729676l));

        System.out.println("删除\t"+i+"条记录");
    }





    @Test
    //Lambda删除
    public void deleteBathidsLambda(){

        LambdaQueryWrapper<Mp> lambdaQueryWrapper=Wrappers.<Mp>lambdaQuery();

        lambdaQueryWrapper.eq(Mp::getAge,21).or().gt(Mp::getAge,41);

        int i = mpMapper.delete(lambdaQueryWrapper);


        System.out.println("删除\t"+i+"条记录");


    }



















//=================================================================================================================

    //传入参数有空的情况下
    public void condition(String user_name,String email){

        //判断是否是空串
//        if (StringUtils.isNotEmpty(user_name)){
//
//            queryWrapper.like("user_name",user_name);
//
//        }
//
//    //判断是否是空串
//        if (StringUtils.isNotEmpty(email)){
//
//            queryWrapper.like("email",email);
//
//        }


        //简单写法
        queryWrapper.like(StringUtils.isNotEmpty(user_name),"user_name",user_name);


        queryWrapper.like(StringUtils.isNotEmpty(email),"email",email);



        List<Mp> mpList = mpMapper.selectList(queryWrapper);

        mpList.forEach(System.out::println);

    }















    }

package cn.linguo.mapper.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * 开发者：高俊欣
 * 日期：2020/1/20
 * 微信：15000952623
 **/


@Component //表示他是spring管理的bean
public class MyMetaObjectHandler implements MetaObjectHandler {

    //自动填充处理器


    //插入时填充
    @Override
    public void insertFill(MetaObject metaObject) {

        System.out.println("MyMetaObjectHandler 在插入数据时，执行了这个方法");

        //判断是否有 createTime 这个属性
        boolean hasGetter = metaObject.hasGetter("createTime");

        if (hasGetter){

            System.out.println("MyMetaObjectHandler 有createTime这个属性");

            //插入数据时加入这个值，值是实体类的属性名，不是数据库的字段名
            setInsertFieldValByName("createTime", LocalDateTime.now(),metaObject);

        }



    }






    //更新时填充
    @Override
    public void updateFill(MetaObject metaObject) {

        System.out.println("MyMetaObjectHandler 在更新数据时，执行了这个方法");

        Object val = getFieldValByName("updateTime", metaObject);

        if (val!=null){

            System.out.println("MyMetaObjectHandler updateTime属性不为空，不进行自动填充！");

        }else {

            System.out.println("MyMetaObjectHandler updateTime属性未空，执行自动填充！");
            setUpdateFieldValByName("updateTime",LocalDateTime.now(),metaObject);
        }



    }





}

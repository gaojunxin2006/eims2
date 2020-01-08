package cn.linguo.dao;

import cn.linguo.entity.Supplier;
import org.apache.poi.hssf.record.formula.functions.T;

import java.util.List;

/**
 * 作者：高俊欣
 * 日期：2020/1/6
 * 微信：15000952623
 **/



//抽取的Mapper

public interface BaseMapper<T> {



    //增删改查


    //添加对象到数据库
    public int insert3(T entity);


    //根据主键修改记录
    public int update3(T entity);


    //查找记录
    public List<T> find3(T entity);


    //删除一条记录
    public int deleteByPk3(T entity);


    //插入一条记录
    int insertSelective3(Supplier record);



}

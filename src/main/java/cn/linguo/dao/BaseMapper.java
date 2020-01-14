package cn.linguo.dao;

import cn.linguo.entity.Page;
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
    public int updateByPrimaryKeySelective(T entity);


    //查找记录
    public List<T> find3(T entity);


    //删除一条记录
    public int deleteByPk3(T entity);


    //插入一条记录
    int insertSelective3(Supplier record);


    //通过关键字，查询分页数据，返回列表
    List<T> pageSelectList(Page<T> page);


    //通过关键字查询，分页数据，返回总记录数
    Integer pageCount(Page<T> page);



    //==================================================================================================

    //多条件通过关键字，查询分页数据，返回列表
    List<T> SelectListPage(Page<T> page);


    //通过关键字查询，分页数据，返回总记录数
    Integer CountPage(Page<T> page);



    //==================================================================================================

    //根据主键，批量删除，删除多条记录

    Integer deleteList(String pks[]);





}

package cn.linguo.service.impl;

import cn.linguo.dao.AccountMapper;
import cn.linguo.dao.BaseMapper;
import cn.linguo.dao.SupplierMapper;
import cn.linguo.entity.Page;
import cn.linguo.entity.Supplier;
import cn.linguo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 作者：高俊欣
 * 日期：2020/1/10
 * 微信：15000952623
 **/


public class BaseServiceImpl<T> implements BaseService<T> {


    @Autowired
    protected SupplierMapper supplierMapper;


    @Autowired
    protected AccountMapper accountMapper;


    protected BaseMapper<T> baseMapper;



    public int insert(T entity) throws Exception {
        return baseMapper.insert3(entity);
    }



    public int updateByPK(T entity) {
        return baseMapper.updateByPrimaryKeySelective(entity);
    }



    public int deleteByPk(T entity) {
        return baseMapper.deleteByPk3(entity);
    }




    public List<T> select(T entity) {
        return null;

    }




    public int insertSelective3(Supplier entity) throws Exception {
        return baseMapper.insertSelective3(entity);
    }




    public Page<T> selectPage(Page<T> page) {

        page.setPageList(baseMapper.SelectListPage(page));

        page.setTotalRecord(baseMapper.CountPage(page));

        return page;
    }




    public Page<Supplier> SelectListPage(Page<T> page) {
        page.setPageList(baseMapper.pageSelectList(page));
        page.setTotalRecord(baseMapper.CountPage(page));
        return (Page<Supplier>) page;
    }




    public Integer deleteList(String[] pks) throws Exception {
        return supplierMapper.deleteList(pks);
    }




}

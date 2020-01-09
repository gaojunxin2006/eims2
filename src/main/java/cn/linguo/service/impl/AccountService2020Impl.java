package cn.linguo.service.impl;

import cn.linguo.dao.AccountMapper;
import cn.linguo.entity.Account;
import cn.linguo.entity.Page;
import cn.linguo.entity.Supplier;
import cn.linguo.service.AccountService2020;
import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：高俊欣
 * 日期：2020/1/6
 * 微信：15000952623
 **/

@Service("accountService")
public class AccountService2020Impl implements AccountService2020 {

    @Autowired
    public AccountMapper accountMapper;




    //用户登陆，验证账号密码

    public Account login(Account account) {

        System.out.println("AccountService2020Impl service层调用dao 执行登陆方法"+account);


        return accountMapper.login(account);


    }




    //继承的抽取出来的通用方法

    public int insert3(T entity) {
        return 0;
    }




    public int update3(T entity) {
        return 0;
    }




    public List<T> find3(T entity) {
        return null;
    }




    public int deleteByPk3(T entity) {
        return 0;
    }



    public int insertSelective3(Supplier record) {
        return 0;
    }

    public List<T> pageSelectList(Page<T> page) {
        return null;
    }

    public Integer pageCount(Page<T> page) {
        return null;
    }

    public List<T> SelectListPage(Page<T> page) {
        return null;
    }

    public Integer CountPage(Page<T> page) {
        return null;
    }





    //通用 根据主键批量删除多条记录
    public Integer deleteList(String[] pks) {
        return null;
    }


}

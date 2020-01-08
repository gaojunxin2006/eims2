package cn.linguo.service;

import cn.linguo.dao.BaseMapper;
import cn.linguo.entity.Account;
import org.apache.poi.hssf.record.formula.functions.T;

/**
 * 作者：高俊欣
 * 日期：2020/1/6
 * 微信：15000952623
 **/


public interface AccountService2020 extends BaseMapper<T> {

    public Account login(Account account);


}

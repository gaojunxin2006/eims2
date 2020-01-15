package cn.linguo.service.impl;



import cn.linguo.entity.AccountRecords;
import cn.linguo.entity.Page;
import cn.linguo.entity.Supplier;
import cn.linguo.service.IAccountRecordsService;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linguo
 * @since 2020-01-14
 */
@Service
public class AccountRecordsServiceImpl implements IAccountRecordsService {


    @Override
    public int insert(AccountRecords entity) throws Exception {
        return 0;
    }

    @Override
    public int updateByPK(AccountRecords entity) {
        return 0;
    }

    @Override
    public int deleteByPk(AccountRecords entity) {
        return 0;
    }

    @Override
    public List<AccountRecords> select(AccountRecords entity) {
        return null;
    }

    @Override
    public int insertSelective3(Supplier entity) throws Exception {
        return 0;
    }

    @Override
    public Page<AccountRecords> selectPage(Page<AccountRecords> page) {
        return null;
    }

    @Override
    public Page<Supplier> SelectListPage(Page<AccountRecords> page) {
        return null;
    }

    @Override
    public Integer deleteList(String[] pks) throws Exception {
        return null;
    }


}

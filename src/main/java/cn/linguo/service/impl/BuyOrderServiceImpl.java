package cn.linguo.service.impl;

import cn.linguo.entity.BuyOrder;
import cn.linguo.entity.Page;
import cn.linguo.entity.Supplier;
import cn.linguo.mapper.BuyOrderMapper;
import cn.linguo.service.IBuyOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class BuyOrderServiceImpl implements IBuyOrderService {

    @Override
    public int insert(BuyOrder entity) throws Exception {
        return 0;
    }

    @Override
    public int updateByPK(BuyOrder entity) {
        return 0;
    }

    @Override
    public int deleteByPk(BuyOrder entity) {
        return 0;
    }

    @Override
    public List<BuyOrder> select(BuyOrder entity) {
        return null;
    }

    @Override
    public int insertSelective3(Supplier entity) throws Exception {
        return 0;
    }

    @Override
    public Page<BuyOrder> selectPage(Page<BuyOrder> page) {
        return null;
    }

    @Override
    public Page<Supplier> SelectListPage(Page<BuyOrder> page) {
        return null;
    }

    @Override
    public Integer deleteList(String[] pks) throws Exception {
        return null;
    }
}

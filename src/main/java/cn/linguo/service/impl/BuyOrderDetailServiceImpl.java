package cn.linguo.service.impl;

import cn.linguo.entity.BuyOrderDetail;
import cn.linguo.entity.Page;
import cn.linguo.entity.Supplier;
import cn.linguo.mapper.BuyOrderDetailMapper;
import cn.linguo.service.IBuyOrderDetailService;
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
public class BuyOrderDetailServiceImpl implements IBuyOrderDetailService {

    @Override
    public int insert(BuyOrderDetail entity) throws Exception {
        return 0;
    }

    @Override
    public int updateByPK(BuyOrderDetail entity) {
        return 0;
    }

    @Override
    public int deleteByPk(BuyOrderDetail entity) {
        return 0;
    }

    @Override
    public List<BuyOrderDetail> select(BuyOrderDetail entity) {
        return null;
    }

    @Override
    public int insertSelective3(Supplier entity) throws Exception {
        return 0;
    }

    @Override
    public Page<BuyOrderDetail> selectPage(Page<BuyOrderDetail> page) {
        return null;
    }

    @Override
    public Page<Supplier> SelectListPage(Page<BuyOrderDetail> page) {
        return null;
    }

    @Override
    public Integer deleteList(String[] pks) throws Exception {
        return null;
    }
}

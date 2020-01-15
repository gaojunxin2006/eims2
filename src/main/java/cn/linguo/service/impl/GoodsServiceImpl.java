package cn.linguo.service.impl;

import cn.linguo.entity.Goods;
import cn.linguo.mapper.GoodsMapper;
import cn.linguo.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linguo
 * @since 2020-01-14
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

}

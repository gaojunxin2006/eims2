package cn.linguo.service.impl;

import cn.linguo.entity.Mp;
import cn.linguo.mapper.MpMapper;
import cn.linguo.service.MpService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 开发者：高俊欣
 * 日期：2020/1/19
 * 微信：15000952623
 **/

@Service("mpService")
public class MpServiceImpl extends ServiceImpl<MpMapper,Mp> implements MpService {

    @Autowired
    private MpMapper mapper;


    @Override
    public List<Mp> mySelectList(Wrapper<Mp> wrapper) {
        return mapper.mySelectList(wrapper);
    }
}

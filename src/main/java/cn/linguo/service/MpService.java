package cn.linguo.service;

import cn.linguo.entity.Mp;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作者：高俊欣
 * 日期：2020/1/19
 * 微信：15000952623
 **/




//mp接口
public interface MpService extends IService<Mp> {


    List<Mp> mySelectList(@Param(Constants.WRAPPER) Wrapper<Mp> wrapper);







}

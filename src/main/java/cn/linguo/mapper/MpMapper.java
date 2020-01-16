package cn.linguo.mapper;

import cn.linguo.entity.Mp;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 作者：高俊欣
 * 日期：2020/1/16
 * 微信：15000952623
 **/


public interface MpMapper extends BaseMapper<Mp> {


    //自定义sql语句，卸载注解上
    @Select("select * from lg_mp ${ew.customSqlSegment}")
    List<Mp> selectAll2(@Param(Constants.WRAPPER)Wrapper<Mp> wrapper);


    List<Mp> selectAll3(@Param(Constants.WRAPPER)Wrapper<Mp> wrapper);

    List<Mp> selectAll4();

    Mp selectAll5(Long userId);

}

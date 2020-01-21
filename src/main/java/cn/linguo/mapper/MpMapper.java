package cn.linguo.mapper;

import cn.linguo.entity.Mp;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    //传统mybatis方式定义接口和xml文件
    List<Mp> selectAll4();

    //传统mybatis方式定义接口和xml文件2
    Mp selectAll5(Long userId);



    //自定义查询，比如多表查询的分页
    IPage<Mp> selectMpPage(Page<Mp> page,@Param(Constants.WRAPPER)Wrapper<Mp> wrapper);


    //高级功能 ，自定义语句. 这里要写查询的表名， 不是实体类
    @Select("select * from lg_mp ${ew.customSqlSegment}")
    List<Mp> mySelectList(@Param(Constants.WRAPPER) Wrapper<Mp> wrapper);



}

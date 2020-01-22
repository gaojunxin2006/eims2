package cn.linguo.mapper.method;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 开发者：高俊欣
 * 日期：2020/1/21
 * 微信：15000952623
 **/

//创建注入器
public class DdleteAllMethod2020 extends AbstractMethod {


    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {

        //执行的sql
        String sql="DELETE from "+tableInfo.getTableName();


        //mapp接口方法名
        String method="lg_deleteAll";

        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);


        return addDeleteMappedStatement(mapperClass,method,sqlSource);


    }



}

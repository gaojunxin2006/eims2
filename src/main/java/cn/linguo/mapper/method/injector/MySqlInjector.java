package cn.linguo.mapper.method.injector;

import cn.linguo.mapper.method.DdleteAllMethod2020;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 开发者：高俊欣
 * 日期：2020/1/21
 * 微信：15000952623
 **/


@Component
public class MySqlInjector extends DefaultSqlInjector {



    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {

        List<AbstractMethod> methodList = super.getMethodList(mapperClass);

        methodList.add(new DdleteAllMethod2020());

        return methodList;

    }





}

package org.fanfan.resp.param.config;

import org.fanfan.resp.param.model.PublicArg;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description: 默认配置
 * @author: fanfanlordship
 * @create: 2021-03-03 23:30
 */
public class DefaultResponseParamConfig {

    public void filedTypeMappingParamType(Map<Class, String> mapping) {
        //数字类型
        mapping.put(Integer.class, "Number");
        mapping.put(int.class, "Number");
        mapping.put(Long.class, "Number");
        mapping.put(long.class, "Number");
        mapping.put(Double.class, "Number");
        mapping.put(double.class, "Number");
        //字符串
        mapping.put(String.class, "String");
        mapping.put(char.class, "String");
        //布尔类型
        mapping.put(Boolean.class, "Boolean");
        mapping.put(boolean.class, "Boolean");
        //集合
        mapping.put(List.class, "Array");
        mapping.put(Set.class, "Array");
    }

    public void appendFiledTypeMappingParamType(Map<Class, String> mapping) {
    }

    public void publicArgs(List<PublicArg> publicArgs) {
    }
}

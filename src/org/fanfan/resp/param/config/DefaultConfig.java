package org.fanfan.resp.param.config;

import org.fanfan.resp.param.model.PublicArg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 全局默认配置
 * @author: fanfanlordship
 * @create: 2021-03-03 23:33
 */
public class DefaultConfig {
    /**
     * 实体字段映射参数字段字典
     */
    private final static Map<Class, String> FILEDTYPE_PARAMTYPE = new HashMap<>();
    /**
     * 公共部分
     */
    private final static List<PublicArg> PUBLIC_ARGS = new ArrayList<>();

    public static String getTypeFormatStr(Class clazz) {
        return FILEDTYPE_PARAMTYPE.getOrDefault(clazz, "Object");
    }

    public static Map<Class, String> getFiledtypeParamtype() {
        return FILEDTYPE_PARAMTYPE;
    }

    public static List<PublicArg> getPublicArgs() {
        return PUBLIC_ARGS;
    }
}

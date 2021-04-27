package org.fanfan.resp.param;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 全局默认配置
 * @author: fanfanlordship
 * @create: 2021-03-03 23:33
 */
public class CommonConfig {
    /**
     * 实体字段映射参数字段字典
     */
    protected final static Map<Class, String> FILEDTYPE_PARAMTYPE = new HashMap<>();

    public static String getTypeFormatStr(Class clazz) {
        return FILEDTYPE_PARAMTYPE.getOrDefault(clazz, "Object");
    }
}

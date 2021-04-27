package org.fanfan.resp.param;

import org.fanfan.resp.param.config.DefaultResponseParamConfig;
import org.fanfan.resp.param.exception.HasBeenInitializedException;

/**
 * @description: 项目启动
 * @author: fanfanlordship
 * @create: 2021-03-03 23:46
 */
public class RunStart {

    public static void load() {
        load(new DefaultResponseParamConfig());
    }

    private static void load(DefaultResponseParamConfig defaultResponseParamConfig) {
        defaultResponseParamConfig.filedTypeMappingParamType(CommonConfig.FILEDTYPE_PARAMTYPE);
        defaultResponseParamConfig.appendFiledTypeMappingParamType(CommonConfig.FILEDTYPE_PARAMTYPE);
    }
}

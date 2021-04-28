package org.fanfan.resp.param;

import org.fanfan.resp.param.config.DefaultConfig;
import org.fanfan.resp.param.config.DefaultResponseParamConfig;
import org.fanfan.resp.param.model.PublicArg;

import java.util.List;

/**
 * @description: 项目启动
 * @author: fanfanlordship
 * @create: 2021-03-03 23:46
 */
public class RunStart {

    public static void load() {
        load(new DefaultResponseParamConfig());
    }

    public static void load(DefaultResponseParamConfig defaultResponseParamConfig) {
        defaultResponseParamConfig.filedTypeMappingParamType(DefaultConfig.getFiledtypeParamtype());
        defaultResponseParamConfig.appendFiledTypeMappingParamType(DefaultConfig.getFiledtypeParamtype());
        List<PublicArg> publicArgs = DefaultConfig.getPublicArgs();
        defaultResponseParamConfig.publicArgs(publicArgs);
    }
}

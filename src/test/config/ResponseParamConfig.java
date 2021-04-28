package test.config;

import org.fanfan.resp.param.config.DefaultResponseParamConfig;
import org.fanfan.resp.param.model.PublicArg;

import java.util.List;

/**
 * @description:
 * @author: fanfanlordship
 * @create: 2021-03-03 23:42
 */
public class ResponseParamConfig extends DefaultResponseParamConfig {

    @Override
    public void publicArgs(List<PublicArg> publicArgs) {
        publicArgs.add(new PublicArg("状态码", "CODE", "状态码"));
        publicArgs.add(new PublicArg("信息", "MSG", "信息"));
        publicArgs.add(new PublicArg("结果", "result", "结果"));
    }
}

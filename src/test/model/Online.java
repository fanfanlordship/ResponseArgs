package test.model;

import org.fanfan.resp.param.annotation.Document;
import org.fanfan.resp.param.annotation.ResponseField;

/**
 * @description:
 * @author: fanfanlordship
 * @create: 2021-03-03 22:38
 */
@Document
public class Online {

    @ResponseField(name = "名称", memo = "接口名称")
    private String name;

    @ResponseField(name = "详情")
    private InC inC;
}

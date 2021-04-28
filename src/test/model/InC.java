package test.model;

import org.fanfan.resp.param.annotation.Document;
import org.fanfan.resp.param.annotation.ResponseField;

/**
 * @description: 内部类
 * @author: fanfanlordship
 * @create: 2021-03-03 23:06
 */
@Document
public class InC {

    @ResponseField(name = "开始")
    private Integer start;
}

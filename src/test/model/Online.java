package test.model;

import org.fanfan.resp.param.annotation.ResponseField;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: fanfanlordship
 * @create: 2021-03-03 22:38
 */
public class Online {

    @ResponseField(name = "名称")
    private String name;

    @ResponseField(name = "详情")
    private InC inC;
//    private ArrayList<String> inC;
}

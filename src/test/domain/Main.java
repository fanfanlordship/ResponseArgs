package test.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fanfan.resp.param.CommonConfig;
import org.fanfan.resp.param.RunStart;
import org.fanfan.resp.param.annotation.ResponseField;
import org.fanfan.resp.param.config.DefaultResponseParamConfig;
import org.fanfan.resp.param.model.RespField;
import org.fanfan.resp.param.model.RespFieldNode;
import org.fanfan.resp.param.service.FieldDocument;
import test.config.ResponseParamConfig;
import test.model.Online;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: fanfanlordship
 * @create: 2021-03-03 22:38
 */
public class Main {

    public static void main(String[] args) {
        ObjectMapper JSON = new ObjectMapper();

        //加载项目配置
        RunStart.load();
        FieldDocument fieldDocument = new FieldDocument(Online.class);
        List<RespField> param = fieldDocument.params();
        System.out.println(param);
        List<RespFieldNode> respFieldNodes = fieldDocument.paramTree();
        System.out.println(respFieldNodes);

        try {
            System.out.println(JSON.writeValueAsString(respFieldNodes));
        } catch (JsonProcessingException e) {
        }
    }
}

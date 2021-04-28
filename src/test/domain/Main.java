package test.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fanfan.resp.param.RunStart;
import org.fanfan.resp.param.model.RespField;
import org.fanfan.resp.param.model.RespFieldNode;
import org.fanfan.resp.param.service.FieldDocument;
import test.config.ResponseParamConfig;
import test.model.Online;

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
        RunStart.load(new ResponseParamConfig());
        FieldDocument fieldDocument = new FieldDocument(Online.class);
        //获取参数列表
        List<RespField> param = fieldDocument.args();
        for (RespField respField : param) {
            System.out.println(respField);
        }
        System.out.println("****************************************");
        //获取参数树
        List<RespFieldNode> respFieldNodes = fieldDocument.argNodes();
        for (RespFieldNode respFieldNode : respFieldNodes) {
            System.out.println(respFieldNode);
        }
    }
}

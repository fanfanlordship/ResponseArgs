package org.fanfan.resp.param.service;

import org.fanfan.resp.param.config.DefaultConfig;
import org.fanfan.resp.param.annotation.Document;
import org.fanfan.resp.param.annotation.ResponseField;
import org.fanfan.resp.param.model.PublicArg;
import org.fanfan.resp.param.model.RespField;
import org.fanfan.resp.param.model.RespFieldNode;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 字段文档
 * @author: fanfanlordship
 * @create: 2021-03-03 22:50
 */
public class FieldDocument {
    /**
     * 文档封装类
     */
    private Class responsePackage;

    public FieldDocument(Class responsePackage) {
        Annotation annotation = responsePackage.getAnnotation(Document.class);
        if (annotation != null) {
            this.responsePackage = responsePackage;
        }
//        new NotDocumentException(responsePackage);
    }

    /**
     * 获取响应参数列表
     *
     * @return
     */
    public List<RespField> args() {
        List<RespField> objects = new ArrayList<>();
        List<PublicArg> publicArgs = DefaultConfig.getPublicArgs();
        if (!publicArgs.isEmpty()) {
            objects.addAll(publicArgs.stream().map(o -> new RespField(o)).collect(Collectors.toList()));
        }
        args(responsePackage, objects);
        return objects;
    }

    private void args(Class clazz, List<RespField> respFields) {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            ResponseField responseField = field.getAnnotation(ResponseField.class);
            if (responseField == null) {
                continue;
            }
            Class<?> type = field.getType();

            RespField respField = new RespField(clazz, field);
            respField.setValue(field.getName());
            respField.setName(responseField.name());
            respField.setMemo(responseField.memo());

            //生成类型
            String typeStr = DefaultConfig.getTypeFormatStr(type);
            respField.setType(typeStr);

            respFields.add(respField);

            Document document = type.getAnnotation(Document.class);
            if (document != null) {
                args(type, respFields);
            }
        }
    }

    public List<RespFieldNode> argNodes() {
        RespFieldNode respFieldNode = new RespFieldNode();
        argNodes(respFieldNode, responsePackage);
        return respFieldNode.getSub();
    }

    private void argNodes(RespFieldNode parent, Class clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        List<RespFieldNode> respFieldNodes = new ArrayList<>();
        for (Field field : declaredFields) {
            ResponseField annotation = field.getAnnotation(ResponseField.class);
            if (annotation == null) {
                continue;
            }
            Class<?> type = field.getType();

            RespFieldNode respFieldNode = new RespFieldNode(clazz, field);
            respFieldNode.setValue(field.getName());
            respFieldNode.setName(annotation.name());

            //生成类型
            String typeStr = DefaultConfig.getTypeFormatStr(type);
            respFieldNode.setType(typeStr);

            respFieldNodes.add(respFieldNode);

            Document document = type.getAnnotation(Document.class);
            if (document != null) {
                argNodes(respFieldNode, type);
            }
        }

        if (!respFieldNodes.isEmpty()) {
            parent.setSub(respFieldNodes);
        }
    }
}

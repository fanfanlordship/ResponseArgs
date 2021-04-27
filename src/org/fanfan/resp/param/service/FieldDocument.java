package org.fanfan.resp.param.service;

import org.fanfan.resp.param.CommonConfig;
import org.fanfan.resp.param.annotation.ResponseField;
import org.fanfan.resp.param.model.RespField;
import org.fanfan.resp.param.model.RespFieldNode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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
        this.responsePackage = responsePackage;
    }

    public List<RespField> params() {
        List<RespField> objects = new ArrayList<>();
        params(responsePackage, objects);
        return objects;
    }

    private void params(Class clazz, List<RespField> respFields) {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            //获取注解
            ResponseField annotation = field.getAnnotation(ResponseField.class);
            if (annotation == null) {
                continue;
            }
            Class<?> type = field.getType();

            RespField respField = new RespField(clazz, field);
            respField.setValue(field.getName());
            respField.setName(annotation.name());

            //生成类型
            String typeStr = CommonConfig.getTypeFormatStr(type);
            respField.setType(typeStr);

            respFields.add(respField);

            if (type != String.class
                    && type != Integer.class
                    && type != Double.class
                    && type != Boolean.class) {
                params(type, respFields);
            }
        }
    }

    public List<RespFieldNode> paramTree() {
        RespFieldNode respFieldNode = new RespFieldNode();
        paramsTree(respFieldNode, responsePackage);
        return respFieldNode.getSub();
    }

    private void paramsTree(RespFieldNode parent, Class clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        List<RespFieldNode> respFieldNodes = new ArrayList<>();
        for (Field field : declaredFields) {
            //获取注解
            ResponseField annotation = field.getAnnotation(ResponseField.class);
            if (annotation == null) {
                continue;
            }
            Class<?> type = field.getType();

            RespFieldNode respFieldNode = new RespFieldNode(clazz, field);
            respFieldNode.setValue(field.getName());
            respFieldNode.setName(annotation.name());

            //生成类型
            String typeStr = CommonConfig.getTypeFormatStr(type);
            respFieldNode.setType(typeStr);

            respFieldNodes.add(respFieldNode);

            if (type != String.class
                    && type != Integer.class
                    && type != Double.class
                    && type != Boolean.class) {
                paramsTree(respFieldNode, type);
            }
        }

        if (!respFieldNodes.isEmpty()) {
            parent.setSub(respFieldNodes);
        }
    }
}

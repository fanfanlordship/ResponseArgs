package org.fanfan.resp.param.model;

import java.lang.reflect.Field;

/**
 * @description: 响应字段
 * @author: fanfanlordship
 * @create: 2021-03-03 22:46
 */
public class RespField {
    /**
     * 字段ID
     */
    private String id;
    /**
     * 字段
     */
    private String value;
    /**
     * 名称
     */
    private String name;
    /**
     * 字段类型
     */
    private String type;
    /**
     * 备注
     */
    private String memo;

    public RespField() {
    }

    public RespField(Class clazz, Field field) {
        this.id = new StringBuilder(100).append(clazz.getName()).append("#").append(field.getName()).toString();
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public RespField setValue(String value) {
        this.value = value;
        return this;
    }

    public String getName() {
        return name;
    }

    public RespField setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public RespField setType(String type) {
        this.type = type;
        return this;
    }

    public String getMemo() {
        return memo;
    }

    public RespField setMemo(String memo) {
        this.memo = memo;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RespField{");
        sb.append("id='").append(id).append('\'');
        sb.append(", value='").append(value).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", memo='").append(memo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

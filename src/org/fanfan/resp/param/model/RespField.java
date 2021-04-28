package org.fanfan.resp.param.model;

import java.lang.reflect.Field;

/**
 * @description: 响应字段
 * @author: fanfanlordship
 * @create: 2021-03-03 22:46
 */
public class RespField extends RootArgs {
    /**
     * 字段ID
     */
    private String id;

    protected RespField() {
    }

    public RespField(PublicArg publicArg) {
        this.id = new StringBuilder(30).append("public_").append(publicArg.getValue()).toString();
        this.setName(publicArg.getName());
        this.setType(publicArg.getType());
        this.setValue(publicArg.getValue());
        this.setMemo(publicArg.getMemo());
    }

    public RespField(Class clazz, Field field) {
        this.id = new StringBuilder(100).append(clazz.getName()).append("#").append(field.getName()).toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RespField{");
        sb.append("id='").append(id).append('\'');
        sb.append(", value='").append(getValue()).append('\'');
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", memo='").append(getMemo()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

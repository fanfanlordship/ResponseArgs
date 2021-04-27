package org.fanfan.resp.param.model;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @description: 响应字段
 * @author: fanfanlordship
 * @create: 2021-03-03 22:46
 */
public class RespFieldNode extends RespField {
    /**
     * 内部参数
     */
    private List<RespFieldNode> sub;

    public RespFieldNode() {
        super();
    }

    public RespFieldNode(Class clazz, Field field) {
        super(clazz, field);
    }

    public List<RespFieldNode> getSub() {
        return sub;
    }

    public RespFieldNode setSub(List<RespFieldNode> sub) {
        this.sub = sub;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RespFieldNode{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", value='").append(getValue()).append('\'');
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", type='").append(getType()).append('\'');
        sb.append(", memo='").append(getMemo()).append('\'');
        sb.append(", sub='").append(sub).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

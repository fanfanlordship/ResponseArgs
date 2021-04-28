package org.fanfan.resp.param.model;

/**
 * @author fanfanlordship
 * @Package org.fanfan.resp.param.model
 * @date 2021/4/28 14:18
 */
public class RootArgs {
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

    protected RootArgs() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "RootArgs{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}

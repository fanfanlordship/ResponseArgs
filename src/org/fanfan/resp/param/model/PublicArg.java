package org.fanfan.resp.param.model;

/**
 * @author fanfanlordship
 * @Package org.fanfan.resp.param.model
 * @date 2021/4/28 14:17
 */
public class PublicArg extends RootArgs {

    public PublicArg() {
    }

    public PublicArg(String name, String value, String memo) {
        setName(name);
        setValue(value);
        setMemo(memo);
    }
}
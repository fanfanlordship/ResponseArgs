package org.fanfan.resp.param.exception;

/**
 * @description: 项目已经初始化异常
 * @author: fanfanlordship
 * @create: 2021-03-03 23:54
 */
public class HasBeenInitializedException extends Exception {

    public HasBeenInitializedException() {
        super("config has been initialized");
    }
}

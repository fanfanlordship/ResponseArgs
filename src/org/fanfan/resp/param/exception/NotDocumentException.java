package org.fanfan.resp.param.exception;

/**
 * @description: 不是文档类
 * @author: fanfanlordship
 * @create: 2021-03-03 23:54
 */
public class NotDocumentException extends Exception {

    public NotDocumentException(Class clazz) {
        super(String.format("%s is not document bean!", clazz.getName()));
    }
}

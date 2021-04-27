package org.fanfan.resp.param.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseField {
    /**
     * 参数名称
     *
     * @return
     */
    String name();

    /**
     * 参数备注
     *
     * @return
     */
    String memo() default "";

    /**
     * 示例
     *
     * @return
     */
    Example[] examples() default {};
}

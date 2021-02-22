package com.lm.lusty.anno;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author lumeng
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LuRpc {

    //指定协议
    String protcl() default "http";


}

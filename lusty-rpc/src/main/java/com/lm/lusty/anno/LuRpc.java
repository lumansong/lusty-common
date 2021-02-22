package com.lm.lusty.anno;


import com.lm.lusty.constant.ProtclConstant;
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
    String protcl() default ProtclConstant.HTTP;

    //指定host
    String host() default "";
}

package com.lm.lusty.anno;


import com.lm.lusty.registor.LuRpcRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LuRpcRegister.class)
public @interface EnableLuRpc {

    //扫描路径
    String[] scanPath() default "";
}

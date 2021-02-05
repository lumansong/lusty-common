package com.lusty.config.anno;


import com.lusty.config.datasource.LustyConfigDataSourceRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lumeng
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LustyConfigDataSourceRegister.class)
public @interface EnableLustyConfig {
}

package com.lusty.datasource.config.anno;


import com.lusty.datasource.config.DynamicDataSourceRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lumeng
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DynamicDataSourceRegister.class)
public @interface EnableDyDataSource {

}

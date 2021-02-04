package demo.anno;


import org.springframework.context.annotation.Import;
import java.lang.annotation.*;

/**
 * @author lumeng
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(EnableDemoSelector.class)
@Import(DemoRegistor.class)
public @interface EnableDemo {
}

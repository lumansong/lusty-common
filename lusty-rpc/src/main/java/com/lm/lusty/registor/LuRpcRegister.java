package com.lm.lusty.registor;

import com.lm.lusty.anno.EnableLuRpc;
import com.lm.lusty.anno.LuRpc;
import com.lm.lusty.proxy.LuRpcProxyFactory;
import com.lm.lusty.util.ClassScanner;
import com.lm.lusty.util.SpringContextHolder;
import com.lm.lusty.util.StringUtil;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ReflectionUtils;

import java.util.Map;
import java.util.Set;

public class LuRpcRegister implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //扫描注解
        Map<String, Object> annotationAttributes = importingClassMetadata
                .getAnnotationAttributes(EnableLuRpc.class.getName());
        if(annotationAttributes==null){
            return;
        }
        String[] basePackages = (String[]) annotationAttributes.get("scanPath");
        if(basePackages==null||basePackages.length==0){
            return;
        }
        ClassScanner classScanner=new ClassScanner();
        Set<Class<?>> scan = classScanner.scan(basePackages, LuRpc.class);
        for(Class clazz:scan){
//            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
//            GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
            GenericBeanDefinition definition=new GenericBeanDefinition();
            definition.getPropertyValues().add("interfaceClass", clazz.getName());
            definition.setBeanClass(LuRpcProxyFactory.class);
            definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
          //  SpringContextHolder.registerBean(definition);

            String simpleNameString=clazz.getSimpleName();
            if(simpleNameString.contains(".")){
                simpleNameString=simpleNameString.substring(simpleNameString.lastIndexOf(".")+1);
            }
            simpleNameString= StringUtil.lowerFirstChar(simpleNameString);
            registry.registerBeanDefinition(simpleNameString,definition);
        }


    }
}

package com.lm.lusty.registor;

import com.lm.lusty.anno.LuRpc;
import com.lm.lusty.proxy.LustyRpcProxyUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * @author lumeng
 */
public class LustyRpcRegistor implements BeanFactoryPostProcessor, ApplicationContextAware {
    
    private ApplicationContext applicationContext;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Map<String, Object> lustyRpcInterface = applicationContext.getBeansWithAnnotation(LuRpc.class);
        if(lustyRpcInterface!=null&&lustyRpcInterface.size()>0) {
            Class<? extends Object> clazz = null;
            for (Map.Entry<String, Object> entry : lustyRpcInterface.entrySet()) {
                clazz = entry.getValue().getClass();//获取到实例对象的class信息
                Class<? extends Object>[] interfaces = clazz.getInterfaces();
                Object proxy = LustyRpcProxyUtil.getProxy(interfaces[0]);
                // bean定义类
                GenericBeanDefinition define = new GenericBeanDefinition();
                // 设置bean的类型，此处DynamicRoutingDataSource是继承AbstractRoutingDataSource的实现类
                define.setBeanClass(interfaces[0]);
                configurableListableBeanFactory.registerSingleton(interfaces[0].getSimpleName(),proxy);
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}

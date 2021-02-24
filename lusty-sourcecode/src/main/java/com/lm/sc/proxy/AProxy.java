package com.lm.sc.proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class AProxy implements MethodInterceptor {

    public Object getInstance(Class clazz) throws Exception {
        //输出class文件
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/lumeng/IdeaProjects/lusty-common/lusty-sourcecode/src/main/java/com/lm/sc/proxyfile");
        //返回代理类对象
        return Enhancer.create(clazz,this);
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是媒婆：");
        System.out.println("------------");
        methodProxy.invokeSuper(o, objects);
        System.out.println("------------");
        System.out.println("寻找中....找到啦");
        return null;
    }
}

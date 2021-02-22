package com.lm.lusty.proxy;

import com.lm.lusty.anno.LuRpc;
import com.lm.lusty.anno.ProtclKey;
import com.lm.lusty.invoker.spi.HttpInvoker;
import com.lm.lusty.invoker.LuRpcInvoke;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.ServiceLoader;

public class LuRpcProxy implements InvocationHandler {

    private Class<?> interfaceClass;

    public Object bind(Class<?> cls) {
        this.interfaceClass = cls;
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[] {interfaceClass}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LuRpc rpc = method.getDeclaringClass().getAnnotation(LuRpc.class);
        if(rpc==null||StringUtils.isEmpty(rpc.protcl())){
            return null;
        }
        LuRpcInvoke invoke=getInvoker(rpc.protcl());
        invoke.setMehod(method);
        invoke.setParam(args);
        return invoke.getUrl();
    }


    private LuRpcInvoke getInvoker(String key){
        ServiceLoader<LuRpcInvoke> load = ServiceLoader.load(LuRpcInvoke.class);
        Iterator<LuRpcInvoke> iterator = load.iterator();
        while (iterator.hasNext()){
            LuRpcInvoke next = iterator.next();
            ProtclKey protclKey = next.getClass().getDeclaredAnnotation(ProtclKey.class);
            if(StringUtils.isNotBlank(protclKey.key())&&protclKey.key().equals(key)){
                return next;
            }
        }
        return null;
    }

}

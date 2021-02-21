package com.lm.lusty.proxy;

import org.springframework.aop.framework.AopProxyUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class LustyRpcProxyUtil<T> {


    public static<T> T getProxy(Class<T> rpcInterface){
        LuRpcInvokehandler luRpcInvokehandler=new LuRpcInvokehandler(rpcInterface);
        T t= (T) Proxy.newProxyInstance(rpcInterface.getClassLoader(),new Class[]{rpcInterface.getClass()},luRpcInvokehandler);
        return t;
    }




     static class LuRpcInvokehandler implements InvocationHandler{

        private Class rpcInterface;


        public LuRpcInvokehandler(Class rpcInterface) {
            this.rpcInterface = rpcInterface;
        }

        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
            System.out.println("11111111");
            return null;
        }
    }

}

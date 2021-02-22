package com.lm.lusty.proxy;

import org.springframework.beans.factory.FactoryBean;

public class LuRpcProxyFactory<T> implements FactoryBean<T> {

    private Class<T> interfaceClass;
    public Class<T> getInterfaceClass() {
        return interfaceClass;
    }
    public void setInterfaceClass(Class<T> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }
    @Override
    public T getObject() throws Exception {
        return (T) new LuRpcProxy().bind(interfaceClass);
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceClass;
    }

    @Override
    public boolean isSingleton() {
        // 单例模式
        return true;
    }

}

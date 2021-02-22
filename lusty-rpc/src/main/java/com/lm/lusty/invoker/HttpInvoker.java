package com.lm.lusty.invoker;

import com.lm.lusty.anno.LuRpc;
import com.lm.lusty.protcl.common.HttpEndPoint;
import com.lm.lusty.protcl.http.HttpInvokerResponse;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class HttpInvoker implements LuRpcInvoke<HttpInvokerResponse>{

    private Method method;

    @Override
    public HttpInvokerResponse invoke() {

        return null;
    }

    @Override
    public String getUrl() {
        LuRpc luRpc = method.getDeclaringClass().getDeclaredAnnotation(LuRpc.class);
        String host=luRpc.host();
        //方法名字
        String name = method.getName();
        //方法参数
        Parameter[] parameters = method.getParameters();
        HttpEndPoint httpEndPoint = HttpEndPoint.builder().host(host).protcl(luRpc.protcl()).methodName(name).build();

        return null;
    }

    @Override
    public void setMehod(Method mehod) {
        this.method=mehod;
    }

}

package com.lm.lusty.invoker.spi;

import com.lm.lusty.anno.LuRpc;
import com.lm.lusty.anno.ProtclKey;
import com.lm.lusty.constant.ProtclConstant;
import com.lm.lusty.invoker.LuRpcInvoke;
import com.lm.lusty.protcl.common.HttpEndPoint;
import com.lm.lusty.protcl.http.HttpInvokerResponse;
import com.lm.lusty.util.MethodParamConverter;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@ProtclKey(key = ProtclConstant.HTTP)
public class HttpInvoker extends AbstractInvoker<HttpInvokerResponse> implements LuRpcInvoke<HttpInvokerResponse> {

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
        HttpEndPoint httpEndPoint = HttpEndPoint.builder().host(host).protcl(luRpc.protcl())
                .methodName(name).param(MethodParamConverter.change(method,args)).build();
        String url = httpEndPoint.getUrl();
        return url;
    }



}

package com.lm.lusty.invoker.spi;

import com.lm.lusty.anno.ProtclKey;
import com.lm.lusty.constant.ProtclConstant;
import com.lm.lusty.invoker.LuRpcInvoke;
import com.lm.lusty.protcl.dubbo.DubboInvokerResponse;

import java.lang.reflect.Method;

@ProtclKey(key = ProtclConstant.DUBBO)
public class DubboInvoker extends AbstractInvoker<DubboInvokerResponse> implements LuRpcInvoke<DubboInvokerResponse> {
    @Override
    public DubboInvokerResponse invoke() {
        return null;
    }

    @Override
    public String getUrl() {
        return "dubbo://localhost:8080/tesh?a=1&b=2";
    }

    @Override
    public void setMehod(Method mehod) {

    }

    @Override
    public void setParam(Object[] args) {

    }
}

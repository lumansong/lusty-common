package com.lm.lusty.invoker.spi;

import com.lm.lusty.invoker.BaseInvokerResponse;
import com.lm.lusty.invoker.LuRpcInvoke;

import java.lang.reflect.Method;

public abstract class AbstractInvoker<R extends BaseInvokerResponse> implements LuRpcInvoke<R> {

    protected Method method;

    protected Object[] args;

    @Override
    public void setMehod(Method mehod) {
        this.method=mehod;
    }

    @Override
    public void setParam(Object[] args) {
        this.args=args;
    }
}

package com.lm.lusty.invoker;

import java.lang.reflect.Method;

public interface LuRpcInvoke<R extends BaseInvokerResponse> {

    R invoke();

    String getUrl();

    void setMehod(Method mehod);

    void setParam(Object[] args);

}

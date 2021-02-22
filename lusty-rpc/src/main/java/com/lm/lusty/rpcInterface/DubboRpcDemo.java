package com.lm.lusty.rpcInterface;


import com.lm.lusty.anno.LuRpc;
import com.lm.lusty.constant.ProtclConstant;

@LuRpc(host = "localhost:8080",protcl = ProtclConstant.DUBBO)
public interface DubboRpcDemo {

    String show();

    String showParam(String a,Integer b);
}

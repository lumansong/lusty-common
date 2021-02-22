package com.lm.lusty.rpcInterface;


import com.lm.lusty.anno.LuRpc;

@LuRpc(host = "localhost:8080")
public interface LustyRpcDemo {

    String show();

    String showParam(String a,Integer b);
}

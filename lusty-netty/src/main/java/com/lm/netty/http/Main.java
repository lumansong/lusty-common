package com.lm.netty.http;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        NettyHttpServer server=new NettyHttpServer();
        server.open();
    }
}

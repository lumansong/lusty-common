package com.lm.netty.chart.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ChartServer {

    private static final Integer port=8080;

    public void start() throws InterruptedException {
        EventLoopGroup boss=new NioEventLoopGroup();
        EventLoopGroup worker=new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap=new ServerBootstrap();

            bootstrap.group(boss,worker).
                    channel(NioServerSocketChannel.class).
                    childHandler(new ChatServerInitialize()).
                    option(ChannelOption.SO_BACKLOG,1024).
                    option(ChannelOption.SO_KEEPALIVE,true);

            //绑定监听端口，调用sync同步阻塞方法等待绑定操作完成，完成后返回ChannelFuture类似于JDK中Future
            ChannelFuture future = bootstrap.bind(port).sync();

            System.out.println("服务器启动：");
            //使用sync方法进行阻塞，等待服务端链路关闭之后Main函数才退出
            future.channel().closeFuture().sync();
        }finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }


    }


    public static void main(String[] args) throws InterruptedException {
        new ChartServer().start();
    }

}

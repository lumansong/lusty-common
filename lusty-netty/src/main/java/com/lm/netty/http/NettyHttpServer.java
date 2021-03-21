package com.lm.netty.http;

import com.lm.netty.telnet.NettyTelnetInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class NettyHttpServer {

    private static final int PORT=8080;

   // private EventLoopGroup bossGroup=new NioEventLoopGroup(1);
    private EventLoopGroup group=new NioEventLoopGroup();
    private ServerBootstrap serverBootstrap;

    public void open() throws InterruptedException {
        try {
            serverBootstrap=new ServerBootstrap();
            // serverBootstrap.option(ChannelOption.SO_BACKLOG,1024);
            serverBootstrap.group(group).channel(NioServerSocketChannel.class)
                    .childHandler(new NettyServerFilter());
            ChannelFuture f = serverBootstrap.bind(PORT).sync();
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully();
        }
    }

}

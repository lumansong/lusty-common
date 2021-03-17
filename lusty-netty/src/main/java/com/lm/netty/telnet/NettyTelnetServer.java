package com.lm.netty.telnet;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class NettyTelnetServer {

    private static final int PORT=8888;

    private ServerBootstrap serverBootstrap;

    private EventLoopGroup bossGroup=new NioEventLoopGroup(1);
    private EventLoopGroup workserGroup=new NioEventLoopGroup();

    public void open() throws InterruptedException {
        serverBootstrap=new ServerBootstrap();
        serverBootstrap.option(ChannelOption.SO_BACKLOG,1024);
        serverBootstrap.group(bossGroup,workserGroup).channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO)).childHandler(new NettyTelnetInitializer());
        Channel ch = serverBootstrap.bind(PORT).sync().channel();
        ch.closeFuture().sync();
    }

    public void close(){
        bossGroup.shutdownGracefully();
        workserGroup.shutdownGracefully();
    }

}

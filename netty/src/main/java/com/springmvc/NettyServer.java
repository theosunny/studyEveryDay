package com.springmvc;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Hello world!
 *
 */
public class NettyServer
{

    private  static final int INET_PORT = 8000;

    public static void main(String[] args )
    {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup boos = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap.group(boos,worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(getChildHandler()).bind(INET_PORT);
    }

    private static ChannelInitializer<NioSocketChannel> getChildHandler() {
        return new ChannelInitializer<NioSocketChannel>() {

            @Override
            protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                nioSocketChannel.pipeline().addLast(new StringDecoder());
                nioSocketChannel.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
                        System.out.println(msg);
                    }
                });
            }
       };
    }
}

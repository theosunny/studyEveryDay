package nettyimpl;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {
    public void connect(int port, String host) {
        //配置客户端nio线程组
        EventLoopGroup clientGroup = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(clientGroup).channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new TimeClientHandler());
                    }
                });
        //发起异步连接操作
        try {
            ChannelFuture f = b.connect(host, port).sync();

            //等待客户端链路关闭
            f.channel().closeFuture().sync();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            clientGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new TimeClient().connect(8080,"127.0.0.1");
    }
}

package com.nainiu192141.nettyclient;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;


/**
 * Created by xfx on 2021/1/22 10:30
 */
public class NettyHttpClient {
    public void connect(String host, int port) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new NettyClientHandler());
                }
            });

            // Start the client.
            ChannelFuture cf = b.connect(host, port).sync();

            String reqStr = "我是客户端请求1";
            // 发送客户端的请求
            cf.channel().writeAndFlush(Unpooled.copiedBuffer(reqStr.getBytes(CharsetUtil.UTF_8)));
            Thread.sleep(300);
            cf.channel().writeAndFlush(Unpooled.copiedBuffer("我是客户端请求2".getBytes(CharsetUtil.UTF_8)));
            Thread.sleep(300);
            cf.channel().writeAndFlush(Unpooled.copiedBuffer("我是客户端请求3".getBytes(CharsetUtil.UTF_8)));

            cf.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully().sync();
        }
    }
}

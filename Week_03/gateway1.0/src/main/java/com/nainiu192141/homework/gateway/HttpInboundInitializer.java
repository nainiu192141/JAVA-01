package com.nainiu192141.homework.gateway;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * Created by xfx on 2021/1/25 19:35
 * @author 86134
 */
public class HttpInboundInitializer extends ChannelInitializer <SocketChannel> {

    private String backServer;

    public HttpInboundInitializer(String backServer) {
        this.backServer = backServer;
    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline p = channel.pipeline();
        p.addLast(new HttpServerCodec());
        p.addLast(new HttpObjectAggregator(1024 * 1024));
        p.addLast(new HttpInboundHandler(this.backServer));
    }

}

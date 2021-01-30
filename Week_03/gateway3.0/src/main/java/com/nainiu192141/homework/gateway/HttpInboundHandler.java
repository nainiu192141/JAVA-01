package com.nainiu192141.homework.gateway;

import com.nainiu192141.homework.gateway.netty.NettyOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by xfx on 2021/1/25 19:42
 * @author 86134
 */
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {
    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
    private NettyOutboundHandler handler;
    public HttpInboundHandler(List<String> backServers) {
        handler = new NettyOutboundHandler(backServers);
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            long startTime = System.currentTimeMillis();
            logger.info("channelRead流量接口请求开始，时间为{}", startTime);
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            handler.handle(fullRequest, ctx);

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            //ReferenceCountUtil.release(msg);
        }
    }
    // 出现异常的处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println("HttpInboundHandler 读取数据出现异常");
        cause.printStackTrace();
        //ctx.close();
    }
}

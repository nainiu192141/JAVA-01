package com.nainiu192141.homework.gateway.netty;


import com.nainiu192141.homework.gateway.filter.HeaderHttpResponseFilter;
import com.nainiu192141.homework.gateway.filter.HttpResponseFilter;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * 读取服务器返回的响应信息
 * @author xfx
 *
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    HttpResponseFilter responseFilter = new HeaderHttpResponseFilter();
    private ChannelHandlerContext channelHandlerContext;
    private FullHttpRequest fullRequest;
    public NettyClientHandler(ChannelHandlerContext ctx,FullHttpRequest request) {
        this.channelHandlerContext = ctx;
        this.fullRequest = request;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            System.err.println("client 读取数据开始");
            FullHttpResponse response = (FullHttpResponse) msg;
            responseFilter.filter(response);
            this.channelHandlerContext.write(response);
            this.channelHandlerContext.flush();
            //handlerTest(this.fullRequest,this.channelHandlerContext,response.content());
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            //ReferenceCountUtil.release(msg);
        }
    }
    private void handlerTest(FullHttpRequest fullRequest, ChannelHandlerContext ctx, ByteBuf value) {
        FullHttpResponse response = null;
        try {
            response = new DefaultFullHttpResponse(HTTP_1_1, OK, value);
            response.headers().set("Content-Type", "text/html");
            response.headers().setInt("Content-Length", response.content().readableBytes());

        } catch (Exception e) {
            System.out.println("处理出错:"+e.getMessage());
            response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
        } finally {
            if (fullRequest != null) {
                if (!HttpUtil.isKeepAlive(fullRequest)) {
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                } else {
                    response.headers().set(CONNECTION, KEEP_ALIVE);
                    ctx.write(response);
                }
            }
        }
    }

    // 数据读取完毕的处理
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.err.println("client 读取数据完毕");
    }

    // 出现异常的处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println("client 读取数据出现异常");
        ctx.close();
    }

}


package com.nainiu192141.homework.gateway.netty;

import com.nainiu192141.homework.gateway.filter.HeaderHttpRequestFilter;
import com.nainiu192141.homework.gateway.filter.HttpRequestFilter;
import com.nainiu192141.homework.gateway.router.HttpEndpointRouter;
import com.nainiu192141.homework.gateway.router.WeightRoundRobinHttpRouter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by xfx on 2021/1/30 12:41
 * @author 86134
 */
public class NettyOutboundHandler {
    private List<String> backendUrls;
    private NettyHttpClient nettyHttpClient;
    HttpEndpointRouter router=  new WeightRoundRobinHttpRouter();
    HttpRequestFilter filter = new HeaderHttpRequestFilter();

    public NettyOutboundHandler(List<String> backendUrls) {
        this.backendUrls = backendUrls;
        nettyHttpClient = new NettyHttpClient();
    }

    public void handle(FullHttpRequest fullRequest, ChannelHandlerContext ctx) throws InterruptedException, URISyntaxException {
        String backendUrl = router.route(this.backendUrls);
        backendUrl = backendUrl.endsWith("/")?backendUrl.substring(0,backendUrl.length()-1):backendUrl;
        System.out.println("当前请求的服务地址："+backendUrl+"------"+System.currentTimeMillis());
        System.out.println("当前请求的headers中属性mao的值："+fullRequest.headers().get("mao")+"------"+System.currentTimeMillis());
        filter.filter(fullRequest);
        System.out.println("过滤器在请求的headers中增加属性mao的值："+fullRequest.headers().get("mao")+"------"+System.currentTimeMillis());
        nettyHttpClient.connect(fullRequest,ctx,backendUrl);
    }
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}

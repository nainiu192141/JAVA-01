package com.nainiu192141.homework.gateway.filter;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * Created by xfx on 2021/1/26 13:52
 * @author 86134
 */
public class HeaderHttpRequestFilter implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest) {
        fullRequest.headers().set("mao","soul");
    }
}

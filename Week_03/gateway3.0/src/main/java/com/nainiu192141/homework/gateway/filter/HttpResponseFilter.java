package com.nainiu192141.homework.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * Created by xfx on 2021/1/26 13:56
 */
public interface HttpResponseFilter {
    void filter(FullHttpResponse fullHttpResponse);
}

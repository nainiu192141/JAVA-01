package com.nainiu192141.homework.gateway;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * Created by xfx on 2021/1/26 13:57
 * @author 86134
 */
public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse fullHttpResponse) {
        fullHttpResponse.headers().set("res", "testfilter");
    }
}

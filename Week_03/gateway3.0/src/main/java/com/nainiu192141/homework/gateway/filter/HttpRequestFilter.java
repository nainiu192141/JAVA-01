package com.nainiu192141.homework.gateway.filter;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author 86134
 */
public interface HttpRequestFilter {

    void filter(FullHttpRequest fullRequest);

}

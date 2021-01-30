package com.nainiu192141.homework.gateway.router;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 轮训算法
 * 将请求按顺序轮流地分配到服务器上，它均衡地对待后端的每一台服务器，
 * 而不关心服务器实际的连接数和当前的系统负载
 * Created by xfx on 2021/1/30 11:44
 * @author 86134
 */
public class RoundRobinHttpRouter implements  HttpEndpointRouter{
    private static AtomicInteger indexAtomic = new AtomicInteger(0);
    @Override
    public String route(List<String> endpoints) {
        if (indexAtomic.get() >= endpoints.size()) {
            indexAtomic.set(0);
        }
        return endpoints.get(indexAtomic.getAndIncrement());
    }
}

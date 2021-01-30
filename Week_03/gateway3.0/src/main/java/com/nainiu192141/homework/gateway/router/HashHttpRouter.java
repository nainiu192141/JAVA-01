package com.nainiu192141.homework.gateway.router;

import java.util.List;
import java.util.Random;

/**
 * hash取模算法
 * 通过哈希函数计算得到的一个数值，用该数值对服务器列表的大小进行取模运算，
 * 得到的结果便是客服端要访问服务器的序号。采用源地址哈希法进行负载均衡，
 * 同一源地址的请求，当服务器列表不变时，它每次都会映射到同一台服务器进行访问。
 * Created by xfx on 2021/1/30 11:34
 * @author 86134
 */
public class HashHttpRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> endpoints) {
        String sourceIp = "ip" + new Random().nextInt(1000);
        int index = sourceIp.hashCode() % endpoints.size();
        return endpoints.get(index);
    }
}

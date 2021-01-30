package com.nainiu192141.homework.gateway.router;

import java.util.List;
import java.util.Random;

/**
 * 随机算法
 * 从服务器列表中随机选取一台服务器进行访问。
 * 由概率论可以得知，随着客户端调用服务端的次数增多，
 * 其实际效果趋近于平均分配请求到服务端的每一台服务器，也就是达到轮询的效果
 * Created by xfx on 2021/1/26 13:40
 * @author 86134
 */
public class RandomHttpRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> endpoints) {
        int size = endpoints.size();
        Random random = new Random(System.currentTimeMillis());
        return endpoints.get(random.nextInt(size));
    }
}

package com.nainiu192141.homework.gateway;

import java.util.List;
import java.util.Random;

/**
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

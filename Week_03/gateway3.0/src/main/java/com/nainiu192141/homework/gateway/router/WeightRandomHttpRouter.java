package com.nainiu192141.homework.gateway.router;

import java.util.*;

/**
 * 加权随机算法
 * 加权轮询法一样，加权随机法也根据服务器的配置，
 * 系统的负载分配不同的权重。不同的是，它是按照权重随机请求后端服务器，而非顺序。
 * Created by xfx on 2021/1/30 11:45
 * @author 86134
 */
public class WeightRandomHttpRouter implements HttpEndpointRouter{
    @Override
    public String route(List<String> endpoints) {
        ArrayList<String> serverList = new ArrayList<>();
        Set<String> serverSet = ServerManager.serverMap.keySet();
        Iterator<String> iterator = serverSet.iterator();

        Integer weightSum = 0;
        while(iterator.hasNext()){
            String server = iterator.next();
            Integer weight = ServerManager.serverMap.get(server);
            weightSum += weight;
            for (int i = 0; i < weight; i++) {
                serverList.add(server);
            }
        }

        Random random = new Random();
        String server = serverList.get(random.nextInt(weightSum));
        return server;
    }
}

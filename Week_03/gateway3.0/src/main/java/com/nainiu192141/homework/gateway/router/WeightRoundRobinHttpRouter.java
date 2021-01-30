package com.nainiu192141.homework.gateway.router;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 加权轮询算法
 * Created by xfx on 2021/1/30 11:51
 * @author 86134
 */
public class WeightRoundRobinHttpRouter implements HttpEndpointRouter{
    private static AtomicInteger indexAtomic = new AtomicInteger(0);
    @Override
    public String route(List<String> endpoints) {

        ArrayList<String> serverList = new ArrayList<>();
        Set<String> serverSet = ServerManager.serverMap.keySet();
        Iterator<String> iterator = serverSet.iterator();
        while(iterator.hasNext()){
            String server = iterator.next();
            Integer weight = ServerManager.serverMap.get(server);
            for (int i = 0; i < weight; i++) {
                serverList.add(server);
            }
        }

        if (indexAtomic.get() >= serverList.size()) {
            indexAtomic.set(0);
        }
        String server = serverList.get(indexAtomic.getAndIncrement());
        return server;
    }
}

package com.nainiu192141.homework.gateway.router;

import java.util.List;

public interface HttpEndpointRouter {

    String route(List<String> endpoints);

    // Load Balance
    // hash
    // Random
    // RoundRibbon
    // Weight
    // - server01,20
    // - server02,30
    // - server03,50

}

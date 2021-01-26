package com.nainiu192141.homework.gateway;

import java.util.Arrays;

/**
 * @author 86134
 */
public class GatewayApplication {
    public static final String GATEWAY_NAME="NIOGateway";
    public static final String GATEWAY_VERSION="3.0.0";
    public static void main(String[] args) {
        String backendServices = "http://localhost:8801,http://localhost:8802,http://localhost:8803";//,http://localhost:8088";
        String[] list  = backendServices.split("\\,");
        String gatewayPort = System.getProperty("gatewayPort","8888");

        //  http://localhost:8888/api/hello  ==> gateway API
        //  http://localhost:8088/api/hello  ==> backend service

        int port = Integer.parseInt(gatewayPort);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" starting...");
        HttpInboundServer server = new HttpInboundServer(port, Arrays.asList(list));
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" started at http://localhost:" + port + " for serverList:" + backendServices);
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}

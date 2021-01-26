package com.nainiu192141.homework.gateway;

/**
 * @author 86134
 */
public class GatewayApplication {
    public static final String GATEWAY_NAME="NIOGateway";
    public static final String GATEWAY_VERSION="1.0.0";
    public static void main(String[] args) {
        String backendService = System.getProperty("backendService","http://localhost:8088/");
        String gatewayPort = System.getProperty("gatewayPort","8888");

        //  http://localhost:8888/api/hello  ==> gateway API
        //  http://localhost:8088/api/hello  ==> backend service

        int port = Integer.parseInt(gatewayPort);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" starting...");
        HttpInboundServer server = new HttpInboundServer(port, backendService);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" started at http://localhost:" + port + " for server:" + backendService);
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}

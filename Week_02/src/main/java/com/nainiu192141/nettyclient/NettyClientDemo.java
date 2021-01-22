package com.nainiu192141.nettyclient;

/**
 * Created by xfx on 2021/1/22 9:39
 */
public class NettyClientDemo {

        public static void main(String[] args) throws Exception {
            NettyHttpClient client = new NettyHttpClient();
            client.connect("127.0.0.1", 8808);
    }
}

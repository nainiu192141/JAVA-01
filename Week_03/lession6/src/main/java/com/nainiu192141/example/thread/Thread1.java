package com.nainiu192141.example.thread;

/**
 * Created by xfx on 2021/2/2 12:31
 */
public class Thread1 {
    public static void main(String[] args) {
        Runnable task =new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                Thread t = Thread.currentThread();
                System.out.println("当前线程："+t.getName());
            }
        };
        Thread tt = new Thread(task);
        tt.setDaemon(false);
        tt.start();
    }

}

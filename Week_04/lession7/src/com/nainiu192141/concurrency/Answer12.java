package com.nainiu192141.concurrency;

import java.util.concurrent.Semaphore;

/**
 * 利用Semaphore信号量
 * Created by xfx on 2021/2/6 22:52
 * @author 86134
 */
public class Answer12 {
    static int result = 0;
    static Semaphore semaphore = new Semaphore(50);
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        new Thread(() -> {
            try {
                result = sum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release(50);
        }).start();
        semaphore.acquire(99);
        System.out.println("异步结果为：" + result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
    private static int sum() throws InterruptedException {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }
}

package com.nainiu192141.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * 利用CountDownLatch线程计数器
 * Created by xfx on 2021/2/6 22:52
 * @author 86134
 */
public class Answer10 {
    static int result = 0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            result = sum();
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println("异步结果为：" + result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }
}

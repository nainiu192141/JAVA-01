package com.nainiu192141.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 主线程睡眠100毫秒等待子线程完成
 * Created by xfx on 2021/2/6 22:52
 * @author 86134
 */
public class Answer2 {
    static int result = 0;
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        new Thread(()->{
            result = sum();
        }).start();
        Thread.sleep(TimeUnit.MILLISECONDS.toMillis(100));
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

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

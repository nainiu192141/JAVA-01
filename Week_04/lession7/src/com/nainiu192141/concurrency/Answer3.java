package com.nainiu192141.concurrency;

/**
 * 主线程阻塞，等待子线程完成计算
 * Created by xfx on 2021/2/6 22:52
 * @author 86134
 */
public class Answer3 {
    static int result = 0;
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread thread = new Thread(()->{
            result = sum();
        });
        thread.start();
        // 使用join阻塞主线程，等到异步线程执行完后，拿到结果
        thread.join();
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

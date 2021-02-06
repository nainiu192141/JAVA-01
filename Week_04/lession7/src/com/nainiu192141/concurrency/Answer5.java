package com.nainiu192141.concurrency;

import java.util.concurrent.Callable;

/**
 * Callable
 * Created by xfx on 2021/2/6 22:52
 * @author 86134
 */
public class Answer5 {
    static int result = 0;
    public static void main(String[] args) throws Exception {
        long start=System.currentTimeMillis();
        // 使用Callable接口，利用Callable有结果
        Integer result = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        }.call();
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

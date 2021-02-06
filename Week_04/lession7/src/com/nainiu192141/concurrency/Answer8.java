package com.nainiu192141.concurrency;

import java.util.concurrent.*;

/**
 * 利用FutureTask
 * Created by xfx on 2021/2/6 22:52
 * @author 86134
 */
public class Answer8 {
    static int result = 0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        });
        new Thread(task).start();
        System.out.println("异步结果为：" + task.get());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return sum();
        }
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

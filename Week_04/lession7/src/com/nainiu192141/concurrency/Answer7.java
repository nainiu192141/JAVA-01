package com.nainiu192141.concurrency;

import java.util.concurrent.*;

/**
 * 利用Future
 * Created by xfx on 2021/2/6 22:52
 * @author 86134
 */
public class Answer7 {
    static int result = 0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start=System.currentTimeMillis();
        ExecutorService executorService = new ThreadPoolExecutor(1,1,1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            return sum();
        }
    });
        executorService.shutdown();
        System.out.println("异步结果为：" + future.get());
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

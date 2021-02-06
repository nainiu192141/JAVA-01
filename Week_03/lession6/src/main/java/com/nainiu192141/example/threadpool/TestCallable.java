package com.nainiu192141.example.threadpool;

import java.util.concurrent.*;

/**
 * Created by xfx on 2021/2/2 16:47
 */
public class TestCallable {
    public static void main(String[] args) throws Exception {
        Callable<Integer> task = new RandomSleepCallable();
        ExecutorService executorService =
                initThreadPoolExecutor();
        Future<Integer> future1 = executorService.submit(task);
        Future<Integer> future2 = executorService.submit(task);
        // 等待执行结果
        Integer result1 = future1.get(10, TimeUnit.SECONDS);
        Integer result2 = future2.get(10, TimeUnit.SECONDS);
        System.out.println("result1=" + result1);
        System.out.println("result2=" + result2);
    }
    public static ThreadPoolExecutor initThreadPoolExecutor() {
        int coreSize = Runtime.getRuntime().availableProcessors();
        int maxSize = Runtime.getRuntime().availableProcessors() * 2;
        BlockingQueue<Runnable> workQueue = new
                LinkedBlockingDeque<>(500);
        CustomThreadFactory threadFactory = new CustomThreadFactory();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(coreSize,
                maxSize,
                1, TimeUnit.MINUTES, workQueue, threadFactory);
        return executor;
    }
}

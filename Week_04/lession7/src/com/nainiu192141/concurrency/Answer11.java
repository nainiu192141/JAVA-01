package com.nainiu192141.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;

/**
 * 利用CyclicBarrier线程栅栏
 * Created by xfx on 2021/2/6 22:52
 * @author 86134
 */
public class Answer11 {
    static int result = 0;
    public static void main(String[] args) throws ExecutionException, InterruptedException, BrokenBarrierException {
        long start=System.currentTimeMillis();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(() -> {
            result = sum();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        cyclicBarrier.await();
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

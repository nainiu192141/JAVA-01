package com.nainiu192141.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 利用Lock和Condition
 * Created by xfx on 2021/2/6 22:52
 * @author 86134
 */
public class Answer13 {
    static int result = 0;
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        new Thread(() -> {
            try {
                result = sum();
                lock.lock();
                condition.signal();
            }finally {
                lock.unlock();
            }
        }).start();
        lock.lock();
        condition.await();
        lock.unlock();
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

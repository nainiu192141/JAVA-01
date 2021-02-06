package com.nainiu192141.example.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xfx on 2021/2/2 16:49
 * @author 86134
 */
public class CustomThreadFactory implements ThreadFactory {
    private AtomicInteger serial = new AtomicInteger(0);
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        // 根据需要，设置守护线程
        thread.setDaemon(true);
        thread.setName("CustomeThread-" + serial.getAndIncrement());
        return thread;
    }
}

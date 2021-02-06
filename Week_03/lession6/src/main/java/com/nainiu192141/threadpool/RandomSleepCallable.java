package com.nainiu192141.threadpool;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by xfx on 2021/2/2 16:46
 * @author 86134
 */
public class RandomSleepCallable implements
        Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Integer sleep = new
                Random().nextInt(10000);
        TimeUnit.MILLISECONDS.sleep(sleep);
        return sleep;
    }
}

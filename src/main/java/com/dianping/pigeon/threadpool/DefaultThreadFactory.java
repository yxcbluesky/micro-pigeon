package com.dianping.pigeon.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by fang on 2018/5/3.
 */
public class DefaultThreadFactory implements ThreadFactory {

    static final AtomicInteger poolNumber = new AtomicInteger(1);
    final AtomicInteger threadNumber;
    final ThreadGroup group;
    final String namePrefix;

    public DefaultThreadFactory(String preffix) {
        this.threadNumber = new AtomicInteger(1);
        this.group = new ThreadGroup(preffix + "-" + poolNumber.getAndIncrement() + "-threadGroup");
        this.namePrefix = preffix + "-" + poolNumber.getAndIncrement() + "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(this.group, r, this.namePrefix + this.threadNumber.getAndIncrement(),
                -3715992351445876736L);
    }
}

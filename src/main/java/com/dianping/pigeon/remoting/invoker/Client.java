package com.dianping.pigeon.remoting.invoker;

/**
 * Created by fang on 2018/4/27.
 */
public interface Client {
    void open();
    void close();
    String getHost();
    int getPort();
}

package com.dianping.remoting.invoker;

/**
 * Created by fang on 2018/4/25.
 */
public class Test {

    public static void main(String[] args) {
        try {
            new NettyClient().connect(7632, "127.0.0.1");
        } catch (Exception ex) {

        }
    }
}

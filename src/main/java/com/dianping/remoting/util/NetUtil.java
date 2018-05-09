package com.dianping.remoting.util;

/**
 * Created by fang on 2018/5/3.
 */
public class NetUtil {
    public static String getAddress(String host, String port) {
        return String.format("%s:%s", host, port);
    }
}

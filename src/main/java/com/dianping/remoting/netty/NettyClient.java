package com.dianping.remoting.netty;

import com.dianping.remoting.invoker.Client;
import org.jboss.netty.bootstrap.ClientBootstrap;

/**
 * Created by fang on 2018/4/27.
 */
public class NettyClient implements Client {

    private String remoteHost;
    private String remotePort;
    private ClientBootstrap bootstrap;

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public String getHost() {
        return null;
    }

    @Override
    public int getPort() {
        return 0;
    }
}

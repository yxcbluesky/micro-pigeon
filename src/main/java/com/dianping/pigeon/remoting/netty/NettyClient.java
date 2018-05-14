package com.dianping.pigeon.remoting.netty;

import com.dianping.pigeon.remoting.invoker.Client;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFactory;

/**
 * Created by fang on 2018/4/27.
 */
public class NettyClient implements Client {

    private String remoteHost;
    private String remotePort;
    private String remoteAddress;
    private ChannelFactory channelFactory;
    private ClientBootstrap bootstrap;

    public NettyClient(String remoteHost, String remotePort, ChannelFactory channelFactory) {
        this.remoteHost = remoteHost;
        this.remotePort = remotePort;
        this.remoteAddress = String.format("%s:%s", remoteHost, remotePort);
        this.channelFactory = channelFactory;
    }

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

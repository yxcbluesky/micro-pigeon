package com.dianping.remoting.netty;

import com.dianping.remoting.invoker.Client;
import com.dianping.remoting.invoker.ClientConfig;
import com.dianping.threadpool.DefaultThreadFactory;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.channel.socket.nio.NioWorkerPool;

import java.util.concurrent.Executors;

/**
 * Created by fang on 2018/4/27.
 */
public class NettyClientFactory {

    private volatile static ChannelFactory channelFactory = null;

    private static ClientConfig clientConfig = new ClientConfig();

    public static Client create(String host, String port) {
        return new NettyClient(host, port, getChannelFactory());
    }

    private static ChannelFactory getChannelFactory() {
        if (channelFactory == null) {
            synchronized (NettyClientFactory.class) {
                if (channelFactory == null) {
                    channelFactory = new NioServerSocketChannelFactory(
                            Executors.newCachedThreadPool(new DefaultThreadFactory("Pigeon-Netty-Client-Boss")),
                            clientConfig.getBossThreadPoolCount(),
                            new NioWorkerPool(
                                    Executors.newCachedThreadPool(new DefaultThreadFactory("Pigeon-Netty-Client-Worker")),
                                    clientConfig.getWorkerThreadPoolCount()
                            ));
                }
            }
        }
        return channelFactory;
    }

}

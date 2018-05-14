package com.dianping.pigeon.remoting.netty;

import com.dianping.pigeon.remoting.invoker.Client;
import com.dianping.pigeon.remoting.invoker.ClientConfig;
import com.dianping.pigeon.remoting.util.NetUtil;
import com.dianping.pigeon.threadpool.DefaultThreadFactory;
import com.google.common.collect.Maps;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.channel.socket.nio.NioWorkerPool;

import java.util.Map;
import java.util.concurrent.Executors;

/**
 * Created by fang on 2018/4/27.
 */
public class NettyClientFactory {

    private volatile static ChannelFactory channelFactory = null;

    private static ClientConfig clientConfig = new ClientConfig();

    private static final Map<String, Client> nettyClientRegistry = Maps.newConcurrentMap();

    public static Client getClient(String host, String port) {
        String address = NetUtil.getAddress(host, port);
        if (nettyClientRegistry.containsKey(address)) {
            return nettyClientRegistry.get(address);
        }
        Client client = new NettyClient(host, port, getChannelFactory());
        nettyClientRegistry.put(address, client);
        return client;
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

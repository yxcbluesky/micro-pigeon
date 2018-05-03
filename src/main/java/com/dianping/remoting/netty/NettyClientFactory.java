package com.dianping.remoting.netty;

import com.dianping.remoting.invoker.Client;
import com.dianping.remoting.invoker.ClientConfig;
import org.jboss.netty.channel.ChannelFactory;

/**
 * Created by fang on 2018/4/27.
 */
public class NettyClientFactory {

    private volatile static ChannelFactory channelFactory = null;

    public static Client create(ClientConfig clientConfig) {
        return null;
    }

    private static ChannelFactory getChannelFactory() {
        if (channelFactory == null) {
            synchronized (NettyClientFactory.class) {
                if (channelFactory == null) {
                    channelFactory =
                }
            }
        }
    }

}

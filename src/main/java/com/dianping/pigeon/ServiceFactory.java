package com.dianping.pigeon;

import com.dianping.pigeon.remoting.invoker.config.InvokerConfig;
import com.dianping.pigeon.remoting.invoker.proxy.ServiceProxy;

/**
 * Created by fang on 2018/4/25.
 */
public class ServiceFactory {

    private static final ServiceProxy proxy = new ServiceProxy();

    public static <T> T getService(Class<T> serviceInterface) {
        return proxy.getProxy(new InvokerConfig<T>(serviceInterface));
    }
}

package com.dianping;

import com.dianping.remoting.invoker.config.InvokerConfig;
import com.dianping.remoting.invoker.proxy.ServiceProxy;

/**
 * Created by fang on 2018/4/25.
 */
public class ServiceFactory {

    private static final ServiceProxy proxy = new ServiceProxy();

    public static <T> T getService(Class<T> serviceInterface) {
        return proxy.getProxy(new InvokerConfig<T>(serviceInterface));
    }
}

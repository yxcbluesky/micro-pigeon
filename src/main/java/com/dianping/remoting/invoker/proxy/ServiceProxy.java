package com.dianping.remoting.invoker.proxy;

import com.dianping.remoting.invoker.config.InvokerConfig;

import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fang on 2018/4/26.
 */
public class ServiceProxy {

    /**
     * 保存已创建的代理类对象
     */
    private static final Map<InvokerConfig<?>, Object> services = new ConcurrentHashMap<>();

    public <T> T getProxy(InvokerConfig<T> invokerConfig) {

        Object service = services.get(invokerConfig);

        if (service == null) {
            service = Proxy.newProxyInstance(invokerConfig.getClassLoader(),
                    new Class[] { invokerConfig.getServiceInterface() },

                    );
        }
        return null;
    }
}

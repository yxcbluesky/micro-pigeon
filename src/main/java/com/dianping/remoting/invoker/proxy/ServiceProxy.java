package com.dianping.remoting.invoker.proxy;

import com.dianping.remoting.common.domain.InvocationContext;
import com.dianping.remoting.invoker.config.InvokerConfig;
import com.dianping.remoting.invoker.process.InvokerProcessHandlerFactory;
import com.dianping.remoting.invoker.service.ServiceInvocationProxyHandler;

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
            startup();
            service = proxyRequest(invokerConfig);
        }
        return null;
    }

    private void startup() {
        InvokerProcessHandlerFactory.init();
    }

    private <T> Object proxyRequest(InvokerConfig<T> invokerConfig) {
        return Proxy.newProxyInstance(invokerConfig.getClassLoader(),
                new Class[]{invokerConfig.getServiceInterface()},
                new ServiceInvocationProxyHandler(InvokerProcessHandlerFactory.getInvocationHandler(), new InvocationContext() {
                }));
    }
}

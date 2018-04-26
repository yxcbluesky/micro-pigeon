package com.dianping.remoting.invoker.service;

import com.dianping.remoting.common.process.ServiceInvocationHandler;
import com.dianping.remoting.invoker.config.InvokerConfig;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by fang on 2018/4/26.
 */
@AllArgsConstructor
public class ServiceInvocationProxyHandler implements InvocationHandler {

    private ServiceInvocationHandler handler;
    private InvokerConfig<?> invokerConfig;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return handler.handle(null);
    }
}

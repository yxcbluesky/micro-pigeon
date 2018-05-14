package com.dianping.pigeon.remoting.invoker.service;

import com.dianping.pigeon.remoting.common.domain.InvocationContext;
import com.dianping.pigeon.remoting.common.domain.InvocationResponse;
import com.dianping.pigeon.remoting.common.process.ServiceInvocationHandler;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by fang on 2018/4/26.
 */
@AllArgsConstructor
public class ServiceInvocationProxyHandler implements InvocationHandler {

    private ServiceInvocationHandler handler;
    private InvocationContext invokerContext;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        InvocationResponse response = handler.handle(invokerContext);
        return null;
    }
}

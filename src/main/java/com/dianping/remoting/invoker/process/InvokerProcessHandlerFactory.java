package com.dianping.remoting.invoker.process;

import com.dianping.remoting.common.process.ServiceInvocationHandler;

/**
 * Created by fang on 2018/4/26.
 */
public class InvokerProcessHandlerFactory {

    private static ServiceInvocationHandler handler;

    public static ServiceInvocationHandler getInvocationHandler() {
        return handler;
    }
}

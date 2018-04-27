package com.dianping.remoting.invoker.process.filter;

import com.dianping.remoting.common.domain.InvocationContext;
import com.dianping.remoting.common.domain.InvocationResponse;
import com.dianping.remoting.common.process.ServiceInvocationHandler;

/**
 * Created by fang on 2018/4/27.
 */
public class RemoteCallInvocationFilter implements InvokerInvocationFilter {

    @Override
    public InvocationResponse invoke(ServiceInvocationHandler handler, InvocationContext ctx) {
        return null;
    }
}

package com.dianping.remoting.invoker.process.filter;

import com.dianping.remoting.common.domain.InvocationResponse;
import com.dianping.remoting.common.process.ServiceInvocationHandler;
import com.dianping.remoting.invoker.config.InvokerContext;

/**
 * Created by fang on 2018/4/27.
 */
public interface InvokerInvocationFilter {
    InvocationResponse invoke(ServiceInvocationHandler handler, InvokerContext ctx);
}

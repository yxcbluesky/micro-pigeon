package com.dianping.remoting.invoker.process.filter;

import com.dianping.remoting.common.domain.InvocationContext;
import com.dianping.remoting.common.process.ServiceInvocationHandler;

/**
 * Created by fang on 2018/4/27.
 */
public interface InvokerInvocationFilter {
    void invoke(ServiceInvocationHandler handler, InvocationContext ctx);
}

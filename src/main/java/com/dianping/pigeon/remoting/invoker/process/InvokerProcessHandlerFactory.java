package com.dianping.remoting.invoker.process;

import com.dianping.remoting.common.domain.InvocationContext;
import com.dianping.remoting.common.domain.InvocationResponse;
import com.dianping.remoting.common.process.ServiceInvocationHandler;
import com.dianping.remoting.invoker.process.filter.ContextPrepareInvocationFilter;
import com.dianping.remoting.invoker.process.filter.InvokerInvocationFilter;
import com.dianping.remoting.invoker.process.filter.RemoteCallInvocationFilter;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by fang on 2018/4/26.
 */
public class InvokerProcessHandlerFactory {

    private static ServiceInvocationHandler handler;

    private static volatile boolean isStarted = false;
    private static List<InvokerInvocationFilter> filters = Lists.newArrayList();

    public static void init() {
        if (!isStarted) {
            synchronized (InvokerProcessHandlerFactory.class) {
                if (!isStarted) {
                    filters.add(new ContextPrepareInvocationFilter());
                    filters.add(new RemoteCallInvocationFilter());
                }
                isStarted = true;
            }
        }
    }

    public static ServiceInvocationHandler getInvocationHandler() {
        return handler;
    }

    private static void createHandler() {
        ServiceInvocationHandler last = null;
        for (int i = filters.size() - 1; i >= 0; i--) {
            final InvokerInvocationFilter cur = filters.get(i);
            final ServiceInvocationHandler next = last;
            last = new ServiceInvocationHandler() {
                @Override
                public InvocationResponse handle(InvocationContext ctx) {
                    return cur.invoke(next, ctx);
                }
            };
        }
        handler = last;
    }
}

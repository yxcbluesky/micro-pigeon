package com.dianping.remoting.invoker.process.filter;

import com.dianping.registry.ServiceRegistry;
import com.dianping.remoting.common.domain.InvocationResponse;
import com.dianping.remoting.common.process.ServiceInvocationHandler;
import com.dianping.remoting.invoker.config.InvokerContext;
import com.dianping.remoting.netty.NettyClientFactory;

/**
 * Created by fang on 2018/4/27.
 */
public class ContextPrepareInvocationFilter implements InvokerInvocationFilter {

    @Override
    public InvocationResponse invoke(ServiceInvocationHandler handler, InvokerContext ctx) {
        String[] address = ServiceRegistry.getAddress(ctx.getInvokerConfig().getUrl()).split(":");
        String host = address[0];
        String port = address[1];
        ctx.setClient(NettyClientFactory.getClient(host, port));
        return null;
    }

}

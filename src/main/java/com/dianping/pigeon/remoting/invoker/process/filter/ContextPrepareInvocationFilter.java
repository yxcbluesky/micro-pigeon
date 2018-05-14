package com.dianping.pigeon.remoting.invoker.process.filter;

import com.dianping.pigeon.registry.ServiceRegistry;
import com.dianping.pigeon.remoting.common.domain.InvocationResponse;
import com.dianping.pigeon.remoting.common.process.ServiceInvocationHandler;
import com.dianping.pigeon.remoting.invoker.config.InvokerContext;
import com.dianping.pigeon.remoting.netty.NettyClientFactory;

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

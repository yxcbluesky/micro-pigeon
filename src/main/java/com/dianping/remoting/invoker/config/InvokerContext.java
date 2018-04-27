package com.dianping.remoting.invoker.config;

import com.dianping.remoting.common.domain.InvocationContext;
import com.dianping.remoting.common.domain.InvocationRequest;
import com.dianping.remoting.common.domain.InvocationResponse;
import com.dianping.remoting.invoker.Client;

/**
 * Created by fang on 2018/4/27.
 */
public class InvokerContext implements InvocationContext {
    private Client client;
    private InvocationRequest request;
    private InvocationResponse response;
}

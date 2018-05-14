package com.dianping.pigeon.remoting.invoker.config;

import com.dianping.pigeon.remoting.common.domain.InvocationContext;
import com.dianping.pigeon.remoting.common.domain.InvocationRequest;
import com.dianping.pigeon.remoting.common.domain.InvocationResponse;
import com.dianping.pigeon.remoting.invoker.Client;
import lombok.Data;

/**
 * Created by fang on 2018/4/27.
 */
@Data
public class InvokerContext implements InvocationContext {
    private InvokerConfig invokerConfig;
    private Client client;
    private InvocationRequest request;
    private InvocationResponse response;
}

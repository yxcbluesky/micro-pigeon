package com.dianping.pigeon.remoting.common.process;

import com.dianping.pigeon.remoting.common.domain.InvocationContext;
import com.dianping.pigeon.remoting.common.domain.InvocationResponse;

/**
 * Created by fang on 2018/4/26.
 */
public interface ServiceInvocationHandler {
    InvocationResponse handle(InvocationContext ctx);
}

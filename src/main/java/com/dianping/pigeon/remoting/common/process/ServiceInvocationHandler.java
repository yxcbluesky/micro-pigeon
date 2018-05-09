package com.dianping.remoting.common.process;

import com.dianping.remoting.common.domain.InvocationContext;
import com.dianping.remoting.common.domain.InvocationResponse;

/**
 * Created by fang on 2018/4/26.
 */
public interface ServiceInvocationHandler {
    InvocationResponse handle(InvocationContext ctx);
}

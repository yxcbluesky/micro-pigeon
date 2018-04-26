package com.dianping.remoting.common.process;

import com.dianping.remoting.common.domain.InvocationContext;

/**
 * Created by fang on 2018/4/26.
 */
public interface ServiceInvocationHandler {
    void handle(InvocationContext ctx);
}

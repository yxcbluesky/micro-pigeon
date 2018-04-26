package com.dianping.remoting.invoker.config;

import com.dianping.remoting.common.codec.SerializerType;
import lombok.Data;

/**
 * Created by fang on 2018/4/26.
 */
@Data
public class InvokerConfig<T> {

    private Class<T> serviceInterface;
    private byte serialize;

    public InvokerConfig(Class<T> serviceInterface) {
        this.serviceInterface = serviceInterface;
        this.serialize = SerializerType.HESSIAN.getCode();
    }
}

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
    private ClassLoader classLoader;
    private String url;

    public InvokerConfig(Class<T> serviceInterface) {
        this.serviceInterface = serviceInterface;
        this.serialize = SerializerType.HESSIAN.getCode();
        this.classLoader = serviceInterface.getClassLoader();
        this.url = serviceInterface.getName();
    }
}

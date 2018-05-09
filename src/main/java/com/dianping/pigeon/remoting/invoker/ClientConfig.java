package com.dianping.remoting.invoker;

import lombok.Data;

/**
 * Created by fang on 2018/5/3.
 */
@Data
public class ClientConfig {
    private Integer bossThreadPoolCount;
    private Integer workerThreadPoolCount;

    public ClientConfig() {
        bossThreadPoolCount = 1;
        workerThreadPoolCount = Runtime.getRuntime().availableProcessors() * 2;
    }
}

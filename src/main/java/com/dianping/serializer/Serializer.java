package com.dianping.serializer;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by fang on 2018/5/14.
 */
public interface Serializer {
    Object deserializeRequest(InputStream is);
    void serializeRequest(OutputStream os, Object obj);
}

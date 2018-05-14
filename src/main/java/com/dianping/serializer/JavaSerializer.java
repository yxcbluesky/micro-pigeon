package com.dianping.serializer;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by fang on 2018/5/14.
 */
public class JavaSerializer implements Serializer {

    @Override
    public Object deserializeRequest(InputStream is) {
        return null;
    }

    @Override
    public void serializeRequest(OutputStream os, Object obj) {

    }
}

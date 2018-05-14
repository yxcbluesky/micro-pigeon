package com.dianping.serializer;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Created by fang on 2018/5/14.
 * jdk序列化
 */
public class JavaSerializer implements Serializer {

    @Override
    public Object deserializeRequest(InputStream is) {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(is);
            try {
                return ois.readObject();
            } catch (Exception ex) {
                ois.close();
            }
        } catch (Exception ex) {

        }
        return null;
    }

    @Override
    public void serializeRequest(OutputStream os, Object obj) {
        try {
            ObjectOutputStream oout = new ObjectOutputStream(os);
            try {
                oout.writeObject(obj);
            } finally {
                oout.close();
            }
        } catch (Exception ex) {
        }
    }
}

package com.dianping.pigeon.remoting.common.codec;

/**
 * Created by fang on 2018/4/26.
 */
public enum SerializerType {
    HESSIAN((byte) 1, "hessian")
    ;

    private byte code;
    private String desc;

    SerializerType(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public byte getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

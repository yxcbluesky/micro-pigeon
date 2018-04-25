package com.dianping.invoker.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by fang on 2018/4/25.
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端接收消息" + msg);
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }

}

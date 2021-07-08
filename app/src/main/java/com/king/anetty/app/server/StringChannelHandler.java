package com.king.anetty.app.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * company：江西神州医疗设备有限公司
 * author： LoveLin
 * time：2021/7/8 11:18
 * desc：
 */
@ChannelHandler.Sharable
public class StringChannelHandler extends SimpleChannelInboundHandler<String> {

    /**
     * 接收消息
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();

    }
}
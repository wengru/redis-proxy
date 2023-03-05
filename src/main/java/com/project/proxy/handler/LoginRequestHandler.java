package com.project.proxy.handler;

import com.project.proxy.packet.LoginResponsePacket;
import com.project.proxy.constant.Attributes;
import com.project.proxy.entity.UserInfo;
import com.project.proxy.exception.BusinessException;
import com.project.proxy.exception.PacketException;
import com.project.proxy.packet.LoginRequestPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.UUID;

public class LoginRequestHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // find account info
        LoginResponsePacket responsePacket = new LoginResponsePacket();
        try {
            UserInfo userInfo = findUserInfo(msg);
            ctx.channel().attr(Attributes.SESSION).set(userInfo);
            responsePacket.setSuccess(true);
            responsePacket.setUid(userInfo.getUid());
            responsePacket.setUsername(userInfo.getUsername());
        } catch (BusinessException e) {
            e.printStackTrace();
            responsePacket.setSuccess(false);
        }
        ctx.writeAndFlush(responsePacket);
    }

    private UserInfo findUserInfo(Object msg) throws Exception {
        if (!(msg instanceof LoginRequestPacket)) {
            throw new BusinessException();
        }
        System.out.println("用户：" + ((LoginRequestPacket) msg).getAccount() + "开始登录");
        // todo 查询数据库
        UserInfo userInfo = new UserInfo();
        userInfo.setUid(UUID.randomUUID().toString());
        userInfo.setAccount("test");
        userInfo.setUsername("admin");
        if (userInfo == null) {
            throw new PacketException();
        }
        return userInfo;
    }

}

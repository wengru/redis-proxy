package com.project.proxy.handler;

import com.project.proxy.packet.response.LoginResponsePacket;
import com.project.proxy.constant.Attributes;
import com.project.proxy.entity.UserInfo;
import com.project.proxy.packet.request.LoginRequestPacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

@ChannelHandler.Sharable
public class LoginHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    public static final LoginHandler INSTANCE = new LoginHandler();

    private LoginHandler() {
        // do nothing
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket packet) throws Exception {
        // find account info
        LoginResponsePacket responsePacket = new LoginResponsePacket();
        try {
            UserInfo userInfo = findUserInfo(packet);
            ctx.channel().attr(Attributes.SESSION).set(userInfo);
            ctx.channel().attr(Attributes.LOGIN).set(true);
            responsePacket.setSuccess(true);
            responsePacket.setUid(userInfo.getUid());
            responsePacket.setUsername(userInfo.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
            responsePacket.setSuccess(false);
            responsePacket.setMsg(e.getMessage());
        }
        ctx.channel().writeAndFlush(responsePacket);
    }

    private UserInfo findUserInfo(Object msg) throws Exception {
        if (!(msg instanceof LoginRequestPacket)) {
            throw new Exception("请求错误");
        }
        System.out.println("用户：" + ((LoginRequestPacket) msg).getAccount() + "开始登录");
        // todo 查询数据库
        UserInfo userInfo = new UserInfo();
        userInfo.setUid(UUID.randomUUID().toString());
        userInfo.setAccount("test");
        userInfo.setUsername("admin");
        if (userInfo == null) {
            throw new Exception("用户不存在");
        }
        return userInfo;
    }

}

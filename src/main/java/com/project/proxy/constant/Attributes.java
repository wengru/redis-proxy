package com.project.proxy.constant;

import com.project.proxy.entity.UserInfo;
import io.netty.util.AttributeKey;

/**
 * @author hanxin
 * @date 2023/3/5 22:11
 */
public class Attributes {

    public static final AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

    public static final AttributeKey<UserInfo> SESSION = AttributeKey.newInstance("session");

}

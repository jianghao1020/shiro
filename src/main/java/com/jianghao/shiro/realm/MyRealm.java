package com.jianghao.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {

    @Override
    public String getName() {
        return "myRealm";
    }

    //授权操作
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证操作
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //通过用户名到数据库中查用户信息，封装成一个AuthenticationInfo对象返回，方便认证器进行对比

        String username = (String) authenticationToken.getPrincipal();
        //假设查询数据库返回数据是zhangsan,111
        if (!"zhangsan".equals(username)) {
            return null;
        }
        String password = "111";

        //simpleAuthenticationInfo表示realm登录比对信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, getName());

        return simpleAuthenticationInfo;
    }
}

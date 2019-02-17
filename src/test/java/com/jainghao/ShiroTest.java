package com.jainghao;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class ShiroTest {

    @Test
    public void testLogin() throws Exception{

        //1创建SecurityManager工厂对象，加载配置文件，创建工厂对象
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //2创建SecurityManager实例
        SecurityManager instance = factory.getInstance();

        //3将SecurityManager绑定到当前环境中，让系统可以访问SecurityManager对象
        SecurityUtils.setSecurityManager(instance);

        //4创建当前登录的主体，此时没有经过认证
        Subject subject = SecurityUtils.getSubject();

        //5收集主体登录的身份
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "111");

        //6登录
        try {
            subject.login(token);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("验证登陆是否成功" + subject.isAuthenticated());

        //7登出
        subject.logout();

        System.out.println("验证登陆是否成功" + subject.isAuthenticated());
    }

    @Test
    public void testLoginByRealm() throws Exception{

        //1创建SecurityManager工厂对象，加载配置文件，创建工厂对象
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        //2创建SecurityManager实例
        SecurityManager instance = factory.getInstance();

        //3将SecurityManager绑定到当前环境中，让系统可以访问SecurityManager对象
        SecurityUtils.setSecurityManager(instance);

        //4创建当前登录的主体，此时没有经过认证
        Subject subject = SecurityUtils.getSubject();

        //5收集主体登录的身份
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "111");

        //6登录
        try {
            subject.login(token);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("验证登陆是否成功" + subject.isAuthenticated());

        //7登出
        subject.logout();

        System.out.println("验证登陆是否成功" + subject.isAuthenticated());
    }
}

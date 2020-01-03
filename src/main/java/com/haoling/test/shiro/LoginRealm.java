package com.haoling.test.shiro;

import com.haoling.test.pojo.T_user;
import com.haoling.test.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;


public class LoginRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 用于权限的认证
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String userName = principalCollection.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roleName = userService.findRoles(userName);
        Set<String> permissions = userService.findPermissions(userName);
        info.setRoles(roleName);
        info.setStringPermissions(permissions);
        return info;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //获取用户账号
        String username = (String)token.getPrincipal();
        T_user user = userService.findUserByUsername(username);
        if (user != null) {
            SimpleAuthenticationInfo authenticationInfo
                    = new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),getName());
            return authenticationInfo;
        }
        return null;
    }
}

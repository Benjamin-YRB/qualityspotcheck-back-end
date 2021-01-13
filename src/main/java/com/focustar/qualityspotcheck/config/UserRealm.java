package com.focustar.qualityspotcheck.config;

import com.focustar.qualityspotcheck.pojo.entity.SysUser;
import com.focustar.qualityspotcheck.service.PermissionService;
import com.focustar.qualityspotcheck.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author yangxiansheng
 * @Since 2021/1/11
 * description:
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        List<String> permissions = permissionService.getPermissionByUserId(user.getId());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);

        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SysUser user = userService.getUserByLoginName(token.getUsername());

        //用户不存在
        if (user == null){

            throw new AuthenticationException();
        }

        return new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getSalt().toString()),user.getName());
//        SysUser user = new SysUser();
//        user.setPassword("123456");
//        user.setSalt(1);
//        user.setName("yang");
//        user.setLoginName("123456");
//        return new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getSalt()),user.getName());

    }
}

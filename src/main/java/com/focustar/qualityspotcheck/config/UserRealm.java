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

        if (user == null){
            return null;
        }

        return new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(""),user.getName());
    }
}

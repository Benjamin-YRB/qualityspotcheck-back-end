package com.focustar.qualityspotcheck.config;

import com.focustar.qualityspotcheck.pojo.entity.SysUser;
import com.focustar.qualityspotcheck.pojo.vo.UserVO;
import com.focustar.qualityspotcheck.service.PermissionService;
import com.focustar.qualityspotcheck.service.RoleService;
import com.focustar.qualityspotcheck.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author yangxiansheng
 * @Since 2021/1/11
 * description:
 */
public class UserRealm extends AuthorizingRealm {

    public static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        System.out.println(user);
        logger.info("开始授权："+user.getName());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        info.addRoles(roleService.getRoleNamesByUserId(user.getId()));

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
        SysUser user = userService.getSysUserByLoginName(token.getUsername());

        logger.info("开始认证");

        //用户不存在
        if (user == null){

            throw new AuthenticationException();
        }

        return new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getSalt().toString()),user.getName());

    }
}

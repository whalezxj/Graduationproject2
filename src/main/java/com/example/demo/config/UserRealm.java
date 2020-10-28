package com.example.demo.config;

import com.example.demo.pojo.Staff;
import com.example.demo.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author
 * @date 2020/10/10
 **/
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private StaffService staffService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.error("执行doGetAuthorizationInfo--->授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前角色
        Subject subject = SecurityUtils.getSubject();
        Staff currentUser = (Staff) subject.getPrincipal();
        //根据当前用户获取权限
        Staff staff = staffService.getByStaffName(currentUser.getStaffName());
        //System.out.println(role);
        info.addRole(staff.getStaffRole());//添加权限角色
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.error("执行doGetAuthenticationInfo--->认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Staff staff = staffService.getByStaffName(token.getUsername());
        if(null == staff){
            throw new UnknownAccountException();
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("loginUser", staff);

        //密码加密
        ByteSource credentialsSalt = ByteSource.Util.bytes(staff.getStaffName());
        //密码加密写法 ↑--↓
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(staff, staff.getStaffPassword(), credentialsSalt, staff.getStaffName());

        /*不加密写法
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(),user.getUsername());
        */
        return info;
    }
}

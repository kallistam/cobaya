package com.tangcco.cobaya.config.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.tangcco.cobaya.beans.User;
import com.tangcco.cobaya.service.UserService;

/**
 * 判断用户权限的Realm
 * 
 * @author JiFeng
 *
 *         2018年1月15日
 */
public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 因为principals封装了实体对象的信息所以进行强转
		User principal = (User) principals.getPrimaryPrincipal();
		if (principal == null) {
			return null;
		}
		Set<String> roles = new HashSet<String>();
		// 添加权限
		if (principal.getState() != null || principal.getState() > 0) {
			roles.add(String.valueOf(principal.getIsvip()));
		}
		// 添加到roles 给shiroFilter做相应过滤
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		return info;
	}

	// 验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 强转类型未UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		// 核实用户信息
		User userinfo = userService.login(upToken.getUsername(), String.valueOf(upToken.getPassword()));
		// 如果用户是null
		if (userinfo == null) {
			throw new UnknownAccountException("用户不存在!");
		}
		// 赋值密码
		Object credentials = userinfo.getPassword();
		// 创建对象 赋值并返回
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userinfo, credentials, getName());
		return authenticationInfo;
	}

}

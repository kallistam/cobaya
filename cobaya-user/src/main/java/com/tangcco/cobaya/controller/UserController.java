package com.tangcco.cobaya.controller;

import java.util.Date;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tangcco.cobaya.beans.User;
import com.tangcco.cobaya.service.UserService;
import com.tangcco.cobaya.util.RedisUtils;

/**
 * 菜单控制器
 * 
 * @author jifeng
 *
 *         2018年3月20日
 */
@RestController
public class UserController {

	@Autowired
	private RedisUtils redisUtils;

	@Autowired
	private UserService userService;

	/**
	 * 手机注册 不会给用户密码 后期自己设定
	 * 
	 * @param regPhone
	 * @return
	 */
	@RequestMapping("/register/{regPhone}")
	public Integer register(@PathVariable("regPhone") String regPhone) {
		User user = new User();
		user.setAccount(regPhone);
		user.setPhone(regPhone);
		// 唯一标识
		user.setId(UUID.randomUUID().toString());
		// 随机设置一个姓名
		user.setName(UUID.randomUUID().toString().substring(0, 10));
		// 设置创建时间
		user.setCreatetime(new Date());
		// 默认注册时不是vip
		user.setIsvip(0);
		// 设置用户的状态
		user.setState(1);
		return userService.register(user);
	}

	/**
	 * 账号登录 手机号 + 密码
	 * 
	 * @param phone
	 *            手机号
	 * @param password
	 *            密码
	 * @return
	 */
	@RequestMapping(value = "/login/{phone}/{password}", produces = { "application/json;charset=UTF-8" })
	public User login(@PathVariable("phone") String phone, @PathVariable("password") String password) {
		System.err.println(phone + " --- " + password);
		Subject currentUser = SecurityUtils.getSubject();
		// 将用户名作为盐值
		// ByteSource salt = ByteSource.Util.bytes(phone);
		/*
		 * MD5加密： 使用SimpleHash类对原始密码进行加密。 第一个参数代表使用MD5方式加密 第二个参数为原始密码
		 * 第三个参数为盐值，即用户名 第四个参数为加密次数 最后用toHex()方法将加密后的密码转成String
		 */
		// 将旧密码进行转换
		// String newPs = new SimpleHash("MD5", String.valueOf(password), salt,
		// 1024).toHex();

		// 设置加密后的密码
		// password = newPs;
		// 设置返回值对象
		User user = null;
		if (!currentUser.isAuthenticated()) {
			// 把用户名和密码封装为 UsernamePasswordToken 对象
			UsernamePasswordToken token = new UsernamePasswordToken(phone, password);
			// rememberme
			// if (rememberme != null) {
			// token.setRememberMe(true);
			// } else {
			// token.setRememberMe(false);
			// }
			try {
				currentUser.login(token);
				Subject subject = SecurityUtils.getSubject();
				// 设置返回对象值
				user = (User) subject.getPrincipal();
				if (user != null) {
					redisUtils.set("loginUser" + user.getPhone(), RedisUtils.ObjectToJson(user), 302400L);
				}
				return user;
			}
			// 所有认证时异常的父类.
			catch (AuthenticationException ae) {
				return null;
			}
		}
		return user;
	}

	// @RequestMapping("/checkAccountExists/{phone}")
	// public Integer checkAccountExists(@PathVariable("phone") String phone) {
	// return userService.checkAccountExists(phone);
	// }

	/**
	 * 检查手机是否注册过
	 * 
	 * @param number
	 *            手机号
	 * @return
	 */
	@RequestMapping("/checkPhoneLogin/{number}")
	public Integer checkPhoneLogin(@PathVariable("number") String number) {
		return userService.checkPhoneLogin(number);
	}

	/**
	 * 手机号 登录
	 * 
	 * @param phone
	 * @return
	 */
	@RequestMapping("/phoneLogin/{phone}")
	public User phoneLogin(@PathVariable("phone") String phone) {
		User user = userService.phoneLogin(phone);
		String loginUserJson = RedisUtils.ObjectToJson(user);
		if (loginUserJson != null) {
			redisUtils.set("loginUser" + user.getAccount(), loginUserJson, 302400L);
		}
		return user;
	}

}

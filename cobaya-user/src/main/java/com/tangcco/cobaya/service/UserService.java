package com.tangcco.cobaya.service;

import com.tangcco.cobaya.beans.User;

public interface UserService {

	/**
	 * 用户实现注册
	 * 
	 * @param user
	 *            用户对象
	 * @return
	 */
	Integer register(User user);

	/**
	 * 用户登陆
	 * 
	 * @param account
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	User login(String account, String password);

	/**
	 * 检查用户名是否存在
	 * 
	 * @param account
	 *            用户账号
	 * @return
	 */
	// public Integer checkAccountExists(String account);

	/**
	 * 检查手机号是否存在
	 * 
	 * @param number
	 *            手机号
	 * @return
	 */
	Integer checkPhoneLogin(String number);

	/**
	 * 手机号进行登录
	 * 
	 * @param phone
	 *            手机号
	 * @return
	 */
	User phoneLogin(String phone);

}

package com.tangcco.cobaya.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangcco.cobaya.beans.User;
import com.tangcco.cobaya.mapper.UserMapper;
import com.tangcco.cobaya.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public Integer register(User user) {
		return userMapper.register(user);
	}

	@Override
	public User login(String phone, String password) {
		return userMapper.login(phone, password);
	}

	// @Override
	// public Integer checkAccountExists(String phone) {
	// return userMapper.checkAccountExists(phone);
	// }

	@Override
	public Integer checkPhoneLogin(String number) {
		return userMapper.checkPhoneLogin(number);
	}

	@Override
	public User phoneLogin(String phone) {
		return userMapper.phoneLogin(phone);
	}

}

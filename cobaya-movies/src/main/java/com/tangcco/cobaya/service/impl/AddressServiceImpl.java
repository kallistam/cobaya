package com.tangcco.cobaya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.tangcco.cobaya.beans.Address;
import com.tangcco.cobaya.mapper.AddressMapper;
import com.tangcco.cobaya.service.AddressService;
import com.tangcco.cobaya.util.RedisUtils;

/**
 * 查询地区服务
 * 
 * @author JiFeng
 *
 *         2018年3月2日
 */
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private RedisUtils redisUtils;

	@Override
	public List<Address> findAllAddress() {
		// String jsonss = redisUtils.get("allAddress");
		// if (jsonss != null) {
		// String json = jsonss.replace("\\", "");
		// return JSON.parseArray(json, Address.class);
		// }
		List<Address> list = addressMapper.findAllAddress();
		// 设置redis的key value 和 过期时间
		// redisUtils.set("allAddress", RedisUtils.ObjectToJson(list), 302400L);
		return list;
	}

}

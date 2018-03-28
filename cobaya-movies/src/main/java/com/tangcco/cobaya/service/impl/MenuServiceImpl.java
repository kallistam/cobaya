package com.tangcco.cobaya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangcco.cobaya.beans.Menu;
import com.tangcco.cobaya.mapper.MenuMapper;
import com.tangcco.cobaya.service.MenuService;
import com.tangcco.cobaya.util.RedisUtils;

/**
 * 菜单服务
 * 
 * @author JiFeng
 *
 *         2018年3月2日
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	@Autowired
	private RedisUtils redisUtils;

	@Override
	public List<Menu> findAllMenu() {
		// String jsonss = redisUtils.get("allMenu");
		// if (jsonss != null) {
		// String json = jsonss.replace("\\", "");
		// return JSON.parseArray(json, Menu.class);
		// }
		List<Menu> list = menuMapper.findAllMenu();
		// redisUtils.set("allMenu", RedisUtils.ObjectToJson(list), 302400L);
		return list;
	}

}

package com.tangcco.cobaya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangcco.cobaya.beans.Movietype;
import com.tangcco.cobaya.mapper.MovietypeMapper;
import com.tangcco.cobaya.service.MovietypeService;
import com.tangcco.cobaya.util.RedisUtils;

/**
 * 影片类型服务
 * 
 * @author JiFeng
 *
 *         2018年3月3日
 */
@Service
public class MovietypeServiceImpl implements MovietypeService {

	@Autowired
	private MovietypeMapper movietypeMapper;

	@Autowired
	private RedisUtils redisUtils;

	@Override
	public List<Movietype> findAllMovieType() {
		// String jsonss = redisUtils.get("allMovieType");
		// if (jsonss != null) {
		// String json = jsonss.replace("\\", "");
		// return JSON.parseArray(json, Movietype.class);
		// }
		List<Movietype> menuList = movietypeMapper.findAllMovieType();
		// redisUtils.set("allMovieType", RedisUtils.ObjectToJson(menuList),
		// 302400L);
		return menuList;
	}

}

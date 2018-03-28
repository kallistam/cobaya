package com.tangcco.cobaya.service;

import java.util.List;

import com.tangcco.cobaya.beans.Movietype;

/**
 * 影片类型服务接口
 * 
 * @author JiFeng
 *
 *         2018年3月3日
 */
public interface MovietypeService {

	/**
	 * 查询所有影片类型
	 * 
	 * @return
	 */
	List<Movietype> findAllMovieType();
}

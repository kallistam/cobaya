package com.tangcco.cobaya.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tangcco.cobaya.beans.Movietype;

/**
 * 
 * @author JiFeng
 *
 *         2018年3月3日
 */
public interface MovietypeMapper {

	/**
	 * 查询所有影片类型
	 * 
	 * @return
	 */
	@Select("select id,name from movietype")
	List<Movietype> findAllMovieType();
}

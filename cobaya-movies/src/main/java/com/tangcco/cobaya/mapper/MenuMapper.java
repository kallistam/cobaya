package com.tangcco.cobaya.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tangcco.cobaya.beans.Menu;

/**
 * @author JiFeng
 *
 *         2018年3月2日
 */
public interface MenuMapper {

	/**
	 * 查询所有菜单项
	 * 
	 * @return
	 */
	@Select("select id,name,parent,url from menu")
	public List<Menu> findAllMenu();

}

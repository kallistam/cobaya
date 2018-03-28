package com.tangcco.cobaya.service;

import java.util.List;

import com.tangcco.cobaya.beans.Menu;

/**
 * 菜单接口
 * 
 * @author JiFeng
 *
 *         2018年3月2日
 */
public interface MenuService {

	/**
	 * 查询所有的菜单项
	 * 
	 * @return
	 */
	public List<Menu> findAllMenu();

}

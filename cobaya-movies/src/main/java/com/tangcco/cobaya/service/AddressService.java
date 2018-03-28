package com.tangcco.cobaya.service;

import java.util.List;

import com.tangcco.cobaya.beans.Address;

/**
 * 地区信息接口
 * 
 * @author JiFeng
 *
 *         2018年3月2日
 */
public interface AddressService {

	/**
	 * 查询所有地区
	 * 
	 * @return
	 */
	public List<Address> findAllAddress();

}

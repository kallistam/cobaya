package com.tangcco.cobaya.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tangcco.cobaya.beans.Address;

/**
 * 
 * @author JiFeng
 *
 *         2018年3月2日
 */
public interface AddressMapper {
	/**
	 * 查询所有的地区信息
	 * 
	 * @return
	 */
	@Select("select id,name from address")
	public List<Address> findAllAddress();
}

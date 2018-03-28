package com.tangcco.cobaya.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tangcco.cobaya.beans.User;

public interface UserMapper {

	/**
	 * 手机注册
	 * 
	 * @param user
	 *            对象
	 * @return
	 */
	@Insert("insert into `user` (id,`name`,`account`,state,isvip,createtime,`phone`) values (#{user.id},#{user.name},#{user.account},1,#{user.isvip},#{user.createtime},#{user.phone})")
	Integer register(@Param("user") User user);

	/**
	 * 用户普通登录
	 * 
	 * @param phone
	 *            手机号
	 * @param password
	 *            密码
	 * @return
	 */
	@Select("select id,`name`,`account`,`password`,`phone`,state,isvip,createtime from `user` where `phone`= #{phone} and password = #{password}")
	User login(@Param("phone") String phone, @Param("password") String password);

	/**
	 * 检查用户账号是否存在
	 * 
	 * @param phone
	 *            用户账号
	 * @return
	 */
	// @Select("select COUNT(*) from `user` where `phone` = #{phone}")
	// Integer checkAccountExists(@Param("phone") String phone);

	/**
	 * 检查手机号是否存在
	 * 
	 * @param number
	 *            手机号
	 * @return
	 */
	@Select("select COUNT(*) from `user` where `phone` = #{number}")
	Integer checkPhoneLogin(@Param("number") String number);

	/**
	 * 手机号登录
	 * 
	 * @param phone
	 *            手机号
	 * @return
	 */
	@Select("select id,`name`,`account`,`password`,state,isvip,createtime from `user` where `phone` = #{phone}")
	User phoneLogin(@Param("phone") String phone);

}

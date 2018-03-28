package com.tangcco.cobaya.beans;

import java.util.Date;

public class User {
	private String id;

	private String name;

	private String account;

	private String password;

	private String phone;

	private String email;

	private Integer state;

	private String emailcode;

	private String createby;

	private String img;

	private Integer sex;

	// 是否是vip
	private Integer isvip;

	// 照片墙
	private String picwall;

	// 观影记录
	private String watchmark;

	// 用户积分
	private Integer score;

	// 是否有查看别人的信息权利
	private Integer lookOther;

	private Date createtime;

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getLookOther() {
		return lookOther;
	}

	public void setLookOther(Integer lookOther) {
		this.lookOther = lookOther;
	}

	// 用户自己上传的视频
	private String mytv;

	public String getMytv() {
		return mytv;
	}

	public void setMytv(String mytv) {
		this.mytv = mytv;
	}

	public Integer getIsvip() {
		return isvip;
	}

	public void setIsvip(Integer isvip) {
		this.isvip = isvip;
	}

	public String getPicwall() {
		return picwall;
	}

	public void setPicwall(String picwall) {
		this.picwall = picwall;
	}

	public String getWatchmark() {
		return watchmark;
	}

	public void setWatchmark(String watchmark) {
		this.watchmark = watchmark;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account == null ? null : account.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getEmailcode() {
		return emailcode;
	}

	public void setEmailcode(String emailcode) {
		this.emailcode = emailcode == null ? null : emailcode.trim();
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby == null ? null : createby.trim();
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img == null ? null : img.trim();
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + ", password=" + password + ", phone="
				+ phone + ", email=" + email + ", state=" + state + ", emailcode=" + emailcode + ", createby="
				+ createby + ", img=" + img + ", sex=" + sex + ", isvip=" + isvip + ", picwall=" + picwall
				+ ", watchmark=" + watchmark + ", score=" + score + ", lookOther=" + lookOther + ", createtime="
				+ createtime + ", mytv=" + mytv + "]";
	}

}
package com.tangcco.cobaya.beans;

import java.util.Date;

public class Movie {
	private String id;

	private String name;

	private String synopsis;

	private String url;

	private String cover;

	private Integer count;

	private String duration;

	private Date createtime;

	private Integer state;

	private String createby;

	private Integer score;

	private String movietypeid;

	private String addressid;

	private String director;

	private String actor;

	private Integer ismovie;

	private Integer isnew;

	private Integer ishot;

	private Integer isvip;

	// 推荐影片
	private Integer isrecommend;

	public Integer getIsrecommend() {
		return isrecommend;
	}

	public void setIsrecommend(Integer isrecommend) {
		this.isrecommend = isrecommend;
	}

	public Integer getIsvip() {
		return isvip;
	}

	public void setIsvip(Integer isvip) {
		this.isvip = isvip;
	}

	// 点赞
	private Integer thumbup;

	public Integer getThumbup() {
		return thumbup;
	}

	public void setThumbup(Integer thumbup) {
		this.thumbup = thumbup;
	}

	// 如果时电视剧多地址
	private String[] urlArr;

	// 注入影片类型
	private Movietype movietype;

	// 注入地区
	private Address address;

	public Movietype getMovietype() {
		return movietype;
	}

	public void setMovietype(Movietype movietype) {
		this.movietype = movietype;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String[] getUrlArr() {
		return urlArr;
	}

	public void setUrlArr(String[] urlArr) {
		this.urlArr = urlArr;
	}

	public Integer getIsnew() {
		return isnew;
	}

	public void setIsnew(Integer isnew) {
		this.isnew = isnew;
	}

	public Integer getIshot() {
		return ishot;
	}

	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}

	public Integer getIsmovie() {
		return ismovie;
	}

	public void setIsmovie(Integer ismovie) {
		this.ismovie = ismovie;
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

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis == null ? null : synopsis.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover == null ? null : cover.trim();
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration == null ? null : duration.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby == null ? null : createby.trim();
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getMovietypeid() {
		return movietypeid;
	}

	public void setMovietypeid(String movietypeid) {
		this.movietypeid = movietypeid == null ? null : movietypeid.trim();
	}

	public String getAddressid() {
		return addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid == null ? null : addressid.trim();
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director == null ? null : director.trim();
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor == null ? null : actor.trim();
	}
}
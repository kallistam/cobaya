package com.tangcco.cobaya.beans;

/**
 * 封装查询的内容
 * 
 * @author JiFeng
 *
 *         2018年3月5日
 */
public class SearchContentModel {

	private String id;
	private String name;
	private String actor;
	private String director;
	private String address;
	private String createTime;
	private String synopsis;
	private String cover;
	private Integer isnew;
	private Integer ishot;
	private Integer score;
	private String movietype;
	private Integer isvip;

	public Integer getIsvip() {
		return isvip;
	}

	public void setIsvip(Integer isvip) {
		this.isvip = isvip;
	}

	public String getMovietype() {
		return movietype;
	}

	public void setMovietype(String movietype) {
		this.movietype = movietype;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
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

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}

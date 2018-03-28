package com.tangcco.cobaya.beans;

public class Menu {
	private String id;

	private String name;

	private String parent;

	private Integer state;

	private String createby;

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent == null ? null : parent.trim();
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
}
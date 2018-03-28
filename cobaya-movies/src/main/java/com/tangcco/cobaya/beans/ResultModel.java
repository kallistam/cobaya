package com.tangcco.cobaya.beans;

import java.util.List;

public class ResultModel {

	// 数据
	private List<SearchContentModel> modelList;
	// 总页数
	private Integer pageCount;
	// 总数量
	private Integer totalCount;

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<SearchContentModel> getModelList() {
		return modelList;
	}

	public void setModelList(List<SearchContentModel> modelList) {
		this.modelList = modelList;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

}

package com.tangcco.cobaya.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.tangcco.cobaya.beans.Movie;
import com.tangcco.cobaya.beans.ResultModel;

/**
 * 
 * @author JiFeng
 *
 *         2018年3月3日
 */
public interface MovieService {

	/**
	 * 查询最新的影片信息
	 * 
	 * 分页
	 * 
	 * @param currentPage
	 *            当前页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public PageInfo<Movie> findNewTV(Integer currentPage, String addressid, String movieTypeid);

	/**
	 * 查询热门的影片信息
	 * 
	 * 分页
	 * 
	 * @param currentPage
	 *            当前页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public PageInfo<Movie> findHotTV(Integer currentPage, String addressid, String movieTypeid);

	/**
	 * 查询评分由高到低的影片信息
	 * 
	 * 分页
	 * 
	 * @param currentPage
	 *            当前页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public PageInfo<Movie> findSorce(Integer currentPage, String addressid, String movieTypeid);

	/**
	 * 随机查询八部推荐的电视剧
	 * 
	 * @return
	 */
	public List<Movie> findRecommendTV();

	/**
	 * 通过solr查询的结果
	 * 
	 * @param content
	 *            查询内容
	 * @param ishot
	 *            是否热门
	 * @param isnew
	 *            是否最新
	 * @param addressid
	 *            地区
	 * @param movieType
	 *            类型
	 * @param currentPage
	 *            当前页
	 * @return
	 */
	public ResultModel findCondition(String content, Integer ishot, Integer isnew, String addressid,
			Integer currentPage, String movieType);

	/**
	 * 加一个点电视剧详情页
	 * 
	 * @param movieId
	 *            电视剧编号
	 * @return
	 */
	public Movie loadPlay(String movieId);

	/**
	 * 查询除了当前影片的其他相关类型的影片
	 * 
	 * @param movietypeid
	 *            类型id
	 * @param movieid
	 *            当前影片id
	 * @return
	 */
	public List<Movie> findRelatedMovie(String movietypeid, String movieid);

	/**
	 * 查询评分由高到低的电影信息
	 * 
	 * 分页
	 * 
	 * @param currentPage
	 *            当前页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public PageInfo<Movie> findSorceMovie(Integer currentPage, String addressid, String movieTypeid);

	/**
	 * 查询最新的电影信息
	 * 
	 * 分页
	 * 
	 * @param currentPage
	 *            当前页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public PageInfo<Movie> findNewMovie(Integer currentPage, String addressid, String movieTypeid);

	/**
	 * 查询热门的电影信息
	 * 
	 * 分页
	 * 
	 * @param currentPage
	 *            当前页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public PageInfo<Movie> findHotMovie(Integer currentPage, String addressid, String movieTypeid);

	/**
	 * 查询评分从高到低的用户上传视频
	 * 
	 * @param currentPage
	 *            当前页
	 * @param addressid
	 *            地区
	 * @param movietypeid
	 *            类型
	 * @return
	 */
	public PageInfo<Movie> findSorcePao(Integer currentPage, String addressid, String movietypeid);

	/**
	 * 查询热门的用户上传视频
	 * 
	 * @param currentPage
	 *            当前页
	 * @param addressid
	 *            地区
	 * @param movietypeid
	 *            类型
	 * @return
	 */
	public PageInfo<Movie> findHotPao(Integer currentPage, String addressid, String movietypeid);

	/**
	 * 查询最新的用户上传视频
	 * 
	 * @param currentPage
	 *            当前页
	 * @param addressid
	 *            地区
	 * @param movietypeid
	 *            类型
	 * @return
	 */
	public PageInfo<Movie> findNewPao(Integer currentPage, String addressid, String movietypeid);

	/**
	 * 相关泡泡信息 四条
	 * 
	 * @param movieid
	 *            当前id
	 * @return
	 */
	public List<Movie> findPaoPaoRelated(String movieid);

	/**
	 * 相关新闻信息 四条
	 * 
	 * @param movieid
	 * 
	 * @return
	 */
	public List<Movie> findNewsRelated(String movieid);

	/**
	 * 查询播放页面 
	 * @return
	 */
	public List<Movie> findMovieByScore();

}

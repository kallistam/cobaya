package com.tangcco.cobaya.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tangcco.cobaya.beans.Movie;

/**
 * 
 * @author JiFeng
 *
 *         2018年3月3日
 */
public interface MovieMapper {

	/**
	 * 查询最新的影片信息
	 * 
	 * 分页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public List<Movie> findNewTV(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

	/**
	 * 查询最新的影片信息数量
	 * 
	 * 用于分页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public Integer findNewTVCount(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

	/**
	 * 查询热门的影片信息
	 * 
	 * 分页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public List<Movie> findHotTV(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

	/**
	 * 查询最热门影片信息数量
	 * 
	 * 用于分页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public Integer findHotTVCount(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

	/**
	 * 查询评分由高到低的影片信息
	 * 
	 * 分页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public List<Movie> findSorce(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

	/**
	 * 查询评分由高到低的影片信息数量
	 * 
	 * 用于分页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public Integer findSorceCount(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

	/**
	 * 随机查询八部推荐的电视剧
	 * 
	 * @return
	 */
	@Select("SELECT id,createtime,`name`,cover,score,isnew,isvip,ishot FROM movie WHERE state = 1 ORDER BY RAND() LIMIT 8")
	public List<Movie> findRecommendTV();

	/**
	 * 加载一个电视剧
	 * 
	 * @param movieId
	 *            电视剧编号
	 * @return
	 */
	public Movie loadPlay(@Param("movieId") String movieId);

	/**
	 * 查询除了当前影片的其他相关类型的影片
	 * 
	 * @param movietypeid
	 *            类型id
	 * @param movieid
	 *            当前影片id
	 * @return
	 */
	@Select("SELECT id,`name`,cover,url,actor,count,isvip,synopsis,score FROM movie WHERE movietypeid = #{movietypeid} AND id NOT IN (#{movieid}) order by score desc limit 3")
	public List<Movie> findRelatedMovie(@Param("movietypeid") String movietypeid, @Param("movieid") String movieid);

	/**
	 * 查询评分由高到低的电影信息数量
	 * 
	 * 用于分页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public List<Movie> findSorceMovie(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

	/**
	 * 查询评分由高到低的电影信息数量
	 * 
	 * 用于分页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public Integer findSorceMovieCount(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

	/**
	 * 查询最新电影信息
	 * 
	 * 用于分页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public List<Movie> findNewMovie(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

	/**
	 * 查询最新的电影信息数量
	 * 
	 * 用于分页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public Integer findNewMovieCount(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

	/**
	 * 查询热门电影信息
	 * 
	 * 用于分页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public List<Movie> findHotMovie(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

	/**
	 * 查询热门的电影信息数量
	 * 
	 * 用于分页
	 * 
	 * @param addressid
	 *            地区id
	 * @param movieTypeid
	 *            影片类型id
	 * @return
	 */
	public Integer findHotMovieCount(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

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
	public List<Movie> findSorcePao(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

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
	public List<Movie> findHotPao(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

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
	public List<Movie> findNewPao(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

	/**
	 * 查询评分从高到低的用户上传视频数量
	 * 
	 * @param currentPage
	 *            当前页
	 * @param addressid
	 *            地区
	 * @param movietypeid
	 *            类型
	 * @return
	 */
	public Integer findSorcePaoCount(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

	/**
	 * 查询热门的用户上传视频数量
	 * 
	 * @param currentPage
	 *            当前页
	 * @param addressid
	 *            地区
	 * @param movietypeid
	 *            类型
	 * @return
	 */
	public Integer findHotPaoCount(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

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
	public Integer findNewPaoCount(@Param("addressid") String addressid, @Param("movieTypeid") String movieTypeid);

	/**
	 * 相关泡泡信息 四条
	 * 
	 * @param movieid
	 *            当前id
	 * @return
	 */
	@Select("SELECT id,`name`,cover,url,isvip,actor,COUNT,synopsis,score FROM movie WHERE id NOT IN (#{movieid}) AND ismovie = 4 ORDER BY score DESC LIMIT 4")
	public List<Movie> findPaoPaoRelated(@Param("movieid") String movieid);

	/**
	 * 相关新闻信息 四条
	 * 
	 * @param movieid
	 *            当前id
	 * @return
	 */
	@Select("SELECT id,`name`,cover,url,isvip,actor,COUNT,synopsis,score FROM movie WHERE id NOT IN (#{movieid}) AND ismovie = 3 ORDER BY score DESC LIMIT 4")
	public List<Movie> findNewsRelated(@Param("movieid") String movieid);

}

package com.tangcco.cobaya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.tangcco.cobaya.beans.Movie;
import com.tangcco.cobaya.beans.MovieJson;
import com.tangcco.cobaya.beans.SingleMovieJson;
import com.tangcco.cobaya.service.MovieService;

@RestController
public class MovieController {

	// 注入电影服务
	@Autowired
	private MovieService movieService;

	/**
	 * 最新的电视剧信息
	 * 
	 * @param currentPage
	 *            当前页
	 * @param addressid
	 *            地区id
	 * @param movietypeid
	 *            影片类型
	 * @return
	 */
	@RequestMapping("/findNewTV/{currentPage}/{addressid}/{movietypeid}")
	public MovieJson findNewTV(@PathVariable("currentPage") Integer currentPage,
			@PathVariable("addressid") String addressid, @PathVariable("movietypeid") String movietypeid) {
		PageInfo<Movie> pagedate = movieService.findNewTV(currentPage, addressid, movietypeid);
		MovieJson movieJson = new MovieJson();
		movieJson.setCurrentPage(currentPage);
		movieJson.setMovieList(pagedate.getList());
		movieJson.setPages(pagedate.getPages());
		return movieJson;
	}

	/**
	 * 热门的电视剧信息
	 * 
	 * @param currentPage
	 *            当前页
	 * @param addressid
	 *            地区id
	 * @param movietypeid
	 *            影片类型
	 * @return
	 */
	@RequestMapping("/findHotTV/{currentPage}/{addressid}/{movietypeid}")
	public MovieJson findHotTV(@PathVariable("currentPage") Integer currentPage,
			@PathVariable("addressid") String addressid, @PathVariable("movietypeid") String movietypeid) {
		if (currentPage == null || currentPage == 0) {
			currentPage = 1;
		}
		PageInfo<Movie> pagedate = movieService.findHotTV(currentPage, addressid, movietypeid);
		MovieJson movieJson = new MovieJson();
		movieJson.setCurrentPage(currentPage);
		movieJson.setMovieList(pagedate.getList());
		movieJson.setPages(pagedate.getPages());
		return movieJson;
	}

	/**
	 * 评分查询电视剧
	 * 
	 * @param currentPage
	 *            当前页
	 * @param addressid
	 *            地区id
	 * @param movietypeid
	 *            影片类型
	 * @return
	 */
	@RequestMapping("/findSocreTV")
	public String findSorce(Model model, Integer currentPage, String addressid, String movietypeid) {
		PageInfo<Movie> pagedate = movieService.findSorce(currentPage, addressid, movietypeid);
		model.addAttribute("TVList", pagedate.getList());
		model.addAttribute("pages", pagedate.getPages());
		model.addAttribute("currentPage", currentPage);
		return "movieContent";
	}

	/**
	 * 加载电视剧模块
	 */
	@RequestMapping(value = "/series")
	public List<Movie> findRecommendTV() {
		return movieService.findRecommendTV();
	}

	/**
	 * 
	 * @param movietypeId
	 *            影片id
	 * @param model
	 * @return
	 */
	@RequestMapping("/loadMovie/{movieId}")
	public SingleMovieJson loadMovie(@PathVariable("movieId") String movieId) {
		// 加载详情影片信息
		Movie movie = movieService.loadPlay(movieId);
		// 影片的类型
		String movietypeid = movie.getMovietypeid();
		// 除去当前影片的其他影片(按评分进行显示)
		List<Movie> relatedMovie = movieService.findRelatedMovie(movietypeid, movie.getId());
		// 创建返回的对象进行封装
		SingleMovieJson singleMovieJson = new SingleMovieJson();
		singleMovieJson.setMovie(movie);
		singleMovieJson.setMovieList(relatedMovie);
		return singleMovieJson;
	}

	/**
	 * 查询评分从高到底 显示4条
	 * 
	 * @return
	 */
	@RequestMapping("/findMovieByScore")
	public List<Movie> findMovieByScore() {
		List<Movie> scoreMovieList = movieService.findMovieByScore();
		return scoreMovieList;
	}

	/**
	 * 电影模块的加载
	 */
	@RequestMapping("/comedy")
	public List<Movie> comedy() {
		return movieService.findRecommendTV();
	}

	/**
	 * 根据评分查询电影
	 * 
	 * @param currentPage
	 *            当前页
	 * @param addressid
	 *            地区id
	 * @param movietypeid
	 *            影片类型
	 * @return
	 */
	@RequestMapping("/findSocreMovie")
	public MovieJson findSorceMovie(Model model, Integer currentPage, String addressid, String movietypeid) {
		PageInfo<Movie> pagedate = movieService.findSorceMovie(currentPage, addressid, movietypeid);
		MovieJson movieJson = new MovieJson();
		movieJson.setCurrentPage(currentPage);
		movieJson.setMovieList(pagedate.getList());
		movieJson.setPages(pagedate.getPages());
		return movieJson;
	}

	/**
	 * 热门查询电影
	 * 
	 * @param currentPage
	 *            当前页
	 * @param addressid
	 *            地区id
	 * @param movietypeid
	 *            影片类型
	 * @return
	 */
	@RequestMapping("/findHotMovie/{currentPage}/{addressid}/{movietypeid}")
	public MovieJson findHotMovie(@PathVariable("currentPage") Integer currentPage,
			@PathVariable("addressid") String addressid, @PathVariable("movietypeid") String movietypeid) {
		PageInfo<Movie> pagedate = movieService.findHotMovie(currentPage, addressid, movietypeid);
		MovieJson movieJson = new MovieJson();
		movieJson.setCurrentPage(currentPage);
		movieJson.setMovieList(pagedate.getList());
		movieJson.setPages(pagedate.getPages());
		return movieJson;
	}

	/**
	 * 最新查询电影
	 * 
	 * @param currentPage
	 *            当前页
	 * @param addressid
	 *            地区id
	 * @param movietypeid
	 *            影片类型
	 * @return
	 */
	@RequestMapping("/findNewMovie/{currentPage}/{addressid}/{movietypeid}")
	public MovieJson findNewMovie(@PathVariable("currentPage") Integer currentPage,
			@PathVariable("addressid") String addressid, @PathVariable("movietypeid") String movietypeid) {
		PageInfo<Movie> pagedate = movieService.findNewMovie(currentPage, addressid, movietypeid);
		// model.addAttribute("movieList", pagedate.getList());
		// model.addAttribute("pages", pagedate.getPages());
		// model.addAttribute("currentPage", currentPage);
		MovieJson movieJson = new MovieJson();
		movieJson.setCurrentPage(currentPage);
		movieJson.setMovieList(pagedate.getList());
		movieJson.setPages(pagedate.getPages());
		return movieJson;
	}

	/**
	 * 泡泡模块
	 */
	@RequestMapping("/paopao")
	public List<Movie> paopao() {
		return movieService.findRecommendTV();
	}

	/**
	 * 根据评分查询泡泡
	 * 
	 * @param currentPage
	 *            当前页
	 * @param addressid
	 *            地区id
	 * @param movietypeid
	 *            影片类型
	 * @return
	 */
	@RequestMapping("/findSocrePao")
	public MovieJson findSocrePao(Model model, Integer currentPage, String addressid, String movietypeid) {
		PageInfo<Movie> pagedate = movieService.findSorcePao(currentPage, addressid, movietypeid);
		MovieJson movieJson = new MovieJson();
		movieJson.setCurrentPage(currentPage);
		movieJson.setMovieList(pagedate.getList());
		movieJson.setPages(pagedate.getPages());
		return movieJson;
	}

	/**
	 * 热门查询泡泡
	 * 
	 * @param currentPage
	 *            当前页
	 * @param addressid
	 *            地区id
	 * @param movietypeid
	 *            影片类型
	 * @return
	 */
	@RequestMapping("/findHotPao/{currentPage}/{addressid}/{movietypeid}")
	public MovieJson findHotPao(@PathVariable("currentPage") Integer currentPage,
			@PathVariable("addressid") String addressid, @PathVariable("movietypeid") String movietypeid) {
		PageInfo<Movie> pagedate = movieService.findHotPao(currentPage, addressid, movietypeid);
		MovieJson movieJson = new MovieJson();
		movieJson.setCurrentPage(currentPage);
		movieJson.setMovieList(pagedate.getList());
		movieJson.setPages(pagedate.getPages());
		return movieJson;
	}

	/**
	 * 最新查询泡泡
	 * 
	 * @param currentPage
	 *            当前页
	 * @param addressid
	 *            地区id
	 * @param movietypeid
	 *            影片类型
	 * @return
	 */
	@RequestMapping("/findNewPao/{currentPage}/{addressid}/{movietypeid}")
	public MovieJson findNewPao(@PathVariable("currentPage") Integer currentPage,
			@PathVariable("addressid") String addressid, @PathVariable("movietypeid") String movietypeid) {
		PageInfo<Movie> pagedate = movieService.findNewPao(currentPage, addressid, movietypeid);
		MovieJson movieJson = new MovieJson();
		movieJson.setCurrentPage(currentPage);
		movieJson.setMovieList(pagedate.getList());
		movieJson.setPages(pagedate.getPages());
		return movieJson;
	}

}

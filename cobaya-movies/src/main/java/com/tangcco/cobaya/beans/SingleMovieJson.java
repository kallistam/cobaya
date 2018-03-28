package com.tangcco.cobaya.beans;

import java.util.List;

/**
 * 单个视频信息详情
 * 
 * @author jifeng
 *
 *         2018年3月23日
 */
public class SingleMovieJson {

	private Movie movie;
	private List<Movie> movieList;
	private Integer size;

	// 相关电影
	private List<Movie> relatedMovieList;

	public List<Movie> getRelatedMovieList() {
		return relatedMovieList;
	}

	public void setRelatedMovieList(List<Movie> relatedMovieList) {
		this.relatedMovieList = relatedMovieList;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}

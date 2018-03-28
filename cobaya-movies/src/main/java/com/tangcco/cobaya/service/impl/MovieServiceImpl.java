package com.tangcco.cobaya.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tangcco.cobaya.beans.Movie;
import com.tangcco.cobaya.beans.ResultModel;
import com.tangcco.cobaya.beans.SearchContentModel;
import com.tangcco.cobaya.mapper.MovieMapper;
import com.tangcco.cobaya.service.MovieService;

/**
 * 
 * @author JiFeng
 *
 *         2018年3月3日
 */
@Service
public class MovieServiceImpl implements MovieService {

	// 当前页显示多少条数据
	private static final Integer PAGE_SIZE = 10;

	@Autowired
	private MovieMapper movieMapper;

	@Autowired
	private SolrClient client;

	@Override
	public PageInfo<Movie> findNewTV(Integer currentPage, String addressid, String movieTypeid) {
		if (currentPage == null) {
			currentPage = 1;
		}
		PageHelper.startPage(currentPage, 18);
		PageInfo<Movie> pagedate = new PageInfo<>(movieMapper.findNewTV(addressid, movieTypeid),
				movieMapper.findNewTVCount(addressid, movieTypeid));
		return pagedate;
	}

	@Override
	public PageInfo<Movie> findHotTV(Integer currentPage, String addressid, String movieTypeid) {
		if (currentPage == null) {
			currentPage = 1;
		}
		PageHelper.startPage(currentPage, 18);
		PageInfo<Movie> pagedate = new PageInfo<>(movieMapper.findHotTV(addressid, movieTypeid),
				movieMapper.findHotTVCount(addressid, movieTypeid));
		return pagedate;
	}

	@Override
	public PageInfo<Movie> findSorce(Integer currentPage, String addressid, String movieTypeid) {
		if (currentPage == null) {	
			currentPage = 1;
		}
		PageHelper.startPage(currentPage, 18);
		PageInfo<Movie> pagedate = new PageInfo<>(movieMapper.findSorce(addressid, movieTypeid),
				movieMapper.findSorceCount(addressid, movieTypeid));
		return pagedate;
	}

	@Override
	public List<Movie> findRecommendTV() {
		return movieMapper.findRecommendTV();
	}

	@Override
	public ResultModel findCondition(String content, Integer ishot, Integer isnew, String addressid,
			Integer currentPage, String movieType) {
		// 封装查询条件
		SolrQuery params = new SolrQuery();
		// 设置默认搜索域 其中product_keyworks是copy域 其中包含了两个域
		params.set("df", "movie_keywords");
		StringBuilder filterCondition = new StringBuilder();
		// 如果是热门条件设置为热门 否则设置为最新
		if (ishot != null || isnew != null) {
			if (ishot == 1) {
				filterCondition.append("movie_ishot:" + ishot);
				params.set("fq", filterCondition.toString());
			} else {
				filterCondition.append("movie_isnew:" + isnew);
				params.set("fq", filterCondition.toString());
			}
		}

		// 设置高亮器 打开
		params.setHighlight(true);
		// 设置高亮的 域名
		params.addHighlightField("movie_name,movie_actor,movie_synopsis,movie_director");
		// 设置高亮前后追加的 元素
		// 前面
		params.setHighlightSimplePre("<span style=\"color:red\">");
		// 后面
		params.setHighlightSimplePost("</span>");

		// 按照时间排序
		params.setSort("movie_createtime", ORDER.desc);

		// 如果page当前页为null 则设置其默认值为1
		if (currentPage == null) {
			currentPage = 1;
		}
		// 设置起始页 用 当前页 - 1 乘以 当前页的显示条数
		Integer start = (currentPage - 1) * PAGE_SIZE;
		// 设置起始页面
		params.setStart(start);
		// 设置一面显示多少数据
		params.setRows(PAGE_SIZE);

		params.setHighlightFragsize(1000);

		// 设置查询的值
		params.setQuery(content);
		try {
			// 执行查询
			QueryResponse response = client.query(params);
			Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
			// 文档结果集
			SolrDocumentList documentList = response.getResults();
			List<SearchContentModel> list = new ArrayList<SearchContentModel>();
			ResultModel result = new ResultModel();
			for (SolrDocument doc : documentList) {
				SearchContentModel model = new SearchContentModel();
				model.setActor(doc.get("movie_actor").toString());
				model.setAddress(doc.get("movie_address").toString());
				model.setCover(doc.get("movie_cover").toString());
				model.setCreateTime(doc.get("movie_createtime").toString());
				model.setDirector(doc.get("movie_director").toString());
				model.setId(doc.get("id").toString());
				model.setIshot(Integer.valueOf(doc.get("movie_ishot").toString()));
				model.setIsnew(Integer.valueOf(doc.get("movie_isnew").toString()));
				model.setName(doc.get("movie_name").toString());
				model.setSynopsis(doc.get("movie_synopsis").toString());
				model.setScore(Integer.valueOf(doc.get("movie_score").toString()));
				model.setMovietype(doc.get("movie_type").toString());
				model.setIsvip(Integer.valueOf(doc.get("movie_isvip").toString()));

				List<String> titleList = highlighting.get(doc.get("id").toString()).get("movie_name");
				List<String> actorList = highlighting.get(doc.get("id").toString()).get("movie_actor");
				List<String> synopsisList = highlighting.get(doc.get("id").toString()).get("movie_synopsis");
				List<String> directorList = highlighting.get(doc.get("id").toString()).get("movie_director");

				// 获取并设置高亮的字段movie_name
				if (titleList != null && titleList.size() > 0) {
					model.setName(titleList.get(0));
				}
				// 获取并设置高亮的字段movie_actor
				if (actorList != null && actorList.size() > 0) {
					model.setActor(actorList.get(0));
				}
				// 获取并设置高亮的字段movie_synopsis
				if (synopsisList != null && synopsisList.size() > 0) {
					model.setSynopsis(synopsisList.get(0));
				}
				// 获取并设置高亮的字段movie_director
				if (directorList != null && directorList.size() > 0) {
					model.setDirector(directorList.get(0));
				}
				list.add(model);
			}
			// 设置数据
			result.setModelList(list);
			// 设置总数量
			Long pageCount = documentList.getNumFound();
			result.setTotalCount(Integer.valueOf(pageCount.toString()));
			// 计算总页数
			Integer pages = (Integer.valueOf(pageCount.toString()) - 1) / PAGE_SIZE + 1;
			// 设置总页数
			result.setPageCount(pages);
			return result;
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Movie loadPlay(String movieId) {
		return movieMapper.loadPlay(movieId);
	}

	@Override
	public List<Movie> findRelatedMovie(String movietypeid, String movieid) {
		return movieMapper.findRelatedMovie(movietypeid, movieid);
	}

	@Override
	public PageInfo<Movie> findSorceMovie(Integer currentPage, String addressid, String movieTypeid) {
		if (currentPage == null) {
			currentPage = 1;
		}
		PageHelper.startPage(currentPage, 18);
		PageInfo<Movie> pagedate = new PageInfo<>(movieMapper.findSorceMovie(addressid, movieTypeid),
				movieMapper.findSorceMovieCount(addressid, movieTypeid));
		return pagedate;
	}

	@Override
	public PageInfo<Movie> findNewMovie(Integer currentPage, String addressid, String movieTypeid) {
		if (currentPage == null) {
			currentPage = 1;
		}
		PageHelper.startPage(currentPage, 18);
		PageInfo<Movie> pagedate = new PageInfo<>(movieMapper.findNewMovie(addressid, movieTypeid),
				movieMapper.findNewMovieCount(addressid, movieTypeid));
		return pagedate;
	}

	@Override
	public PageInfo<Movie> findHotMovie(Integer currentPage, String addressid, String movieTypeid) {
		if (currentPage == null) {
			currentPage = 1;
		}
		PageHelper.startPage(currentPage, 18);
		PageInfo<Movie> pagedate = new PageInfo<>(movieMapper.findHotMovie(addressid, movieTypeid),
				movieMapper.findHotMovieCount(addressid, movieTypeid));
		return pagedate;
	}

	@Override
	public PageInfo<Movie> findSorcePao(Integer currentPage, String addressid, String movietypeid) {
		if (currentPage == null) {
			currentPage = 1;
		}
		PageHelper.startPage(currentPage, 18);
		PageInfo<Movie> pagedate = new PageInfo<>(movieMapper.findSorcePao(addressid, movietypeid),
				movieMapper.findSorcePaoCount(addressid, movietypeid));
		return pagedate;
	}

	@Override
	public PageInfo<Movie> findHotPao(Integer currentPage, String addressid, String movietypeid) {
		if (currentPage == null) {
			currentPage = 1;
		}
		PageHelper.startPage(currentPage, 18);
		PageInfo<Movie> pagedate = new PageInfo<>(movieMapper.findHotPao(addressid, movietypeid),
				movieMapper.findHotPaoCount(addressid, movietypeid));
		return pagedate;
	}

	@Override
	public PageInfo<Movie> findNewPao(Integer currentPage, String addressid, String movietypeid) {
		if (currentPage == null) {
			currentPage = 1;
		}
		PageHelper.startPage(currentPage, 18);
		PageInfo<Movie> pagedate = new PageInfo<>(movieMapper.findNewPao(addressid, movietypeid),
				movieMapper.findNewPaoCount(addressid, movietypeid));
		return pagedate;
	}

	@Override
	public List<Movie> findPaoPaoRelated(String movieid) {
		return movieMapper.findPaoPaoRelated(movieid);
	}

	@Override
	public List<Movie> findNewsRelated(String movieid) {
		return movieMapper.findNewsRelated(movieid);
	}

	@Override
	public List<Movie> findMovieByScore() {
		return null;
	}

}

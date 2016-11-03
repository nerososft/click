package org.nero.click.data.service;

import org.nero.click.data.exception.news.NewsNotFoundException;
import org.nero.click.data.dto.Operate;
import org.nero.click.data.entity.News;

import java.util.List;

/**
 * Created by nero on 2016/10/14 0014.
 */
public interface INewsService {


    /**
     * 添加新闻
     * @param news
     * @return Operate<News>
     */
    Operate<News> addNews(News news);

    /**
     * 删除新闻
     * @param id
     * @return
     * @throws NewsNotFoundException
     */
    Operate<News> delNews(long id) throws NewsNotFoundException;

    /**
     * 修改新闻
     * @param id
     * @param news
     * @return
     * @throws NewsNotFoundException
     */
    Operate<News> modifyNews(long id,News news) throws NewsNotFoundException;

    /**
     * 根据id获取新闻
     * @param id
     * @return
     * @throws NewsNotFoundException
     */
    News getNewsById(long id) throws NewsNotFoundException;

    /**
     * 获取新闻列表
     * @param limit
     * @param offset
     * @return
     */
    List<News> getNews(long limit, long offset);


}

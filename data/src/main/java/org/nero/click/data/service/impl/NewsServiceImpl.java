package org.nero.click.admin.service.impl;

import org.nero.click.admin.dao.NewsDao;
import org.nero.click.admin.dto.Operate;
import org.nero.click.admin.entity.News;
import org.nero.click.admin.exception.news.NewsNotFoundException;
import org.nero.click.admin.service.INewsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nero on 2016/10/14 0014.
 */
@Service
public class NewsServiceImpl implements INewsService {


    private NewsDao newsDao;



    public Operate<News> addNews(News news) {
        Operate<News> operate;
        long newsId = newsDao.addNew(news.getTitle(),news.getContent());
        if(newsId<1){
            operate = new Operate<News>(false,"添加失败",null);
        }else{
            operate = new Operate<News>(true,"添加成功",null);
        }
        return operate;
    }

    public Operate<News> delNews(long id) throws NewsNotFoundException {
        Operate<News> operate;
        if(newsDao.getNewById(id)==null){
            throw new NewsNotFoundException();
        }else {
            long isDel = newsDao.delNew(id);
            if (isDel < 1) {
                operate = new Operate<News>(false, "删除失败", null);
            } else {
                operate = new Operate<News>(true, "删除成功", null);
            }
        }
        return operate;
    }

    public Operate<News> modifyNews(long id, News news) throws NewsNotFoundException {
        Operate<News> operate;
        if(newsDao.getNewById(id)==null){
            throw new NewsNotFoundException();
        }else {
            long isModify = newsDao.modiftNew(id, news.getTitle(), news.getContent());
            if (isModify < 1) {
                operate = new Operate<News>(false, "修改失败", null);
            } else {
                operate = new Operate<News>(true, "修改成功", null);
            }
        }
        return operate;
    }

    public News getNewsById(long id) {
        News news = newsDao.getNewById(id);
        if(news==null){
            throw  new NewsNotFoundException();
        }else{
            return news;
        }
    }

    public List<News> getNews(long limit, long offset) {
        return newsDao.getNews(limit,offset);
    }
}

package org.nero.click.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.click.admin.entity.News;

import java.util.List;

/**
 * Created by nero on 2016/10/14 0014.
 */
public interface NewsDao {


    int addNew(@Param("title") String title,
               @Param("content") String content);

    int delNew(long id);

    int modiftNew(@Param("id") long id,
                  @Param("title") String title,
                  @Param("content") String content);

    News getNewById(long id);

    List<News> getNews(@Param("limit") long limit,
                       @Param("offset") long offset);


}

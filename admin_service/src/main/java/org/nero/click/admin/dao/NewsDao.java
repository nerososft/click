package org.nero.click.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.click.admin.entity.News;

import java.util.List;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-5
 * Time   :  下午7:41
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

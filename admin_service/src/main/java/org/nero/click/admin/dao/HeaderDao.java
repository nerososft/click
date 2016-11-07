package org.nero.click.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.click.admin.entity.Header;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-5
 * Time   :  下午7:41
 */
public interface HeaderDao {
    /**
     * 获取网页头
     * @return
     */
    Header getHeader();

    /**
     * 设置网页头
     * @param title
     * @param label
     * @return
     */
    int modifyHeader(@Param("title") String title,
                     @Param("label") String label);

    /**
     * 添加
     * @param title
     * @param label
     * @return
     */
    int addHeader(@Param("title") String title,
                  @Param("label") String label);
}

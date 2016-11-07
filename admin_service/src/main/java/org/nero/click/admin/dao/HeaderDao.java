package org.nero.click.admin.dao;

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
    int modifyHeader(String title, String label);

    /**
     * 添加
     * @param title
     * @param label
     * @return
     */
    int addHeader(String title, String label);
}

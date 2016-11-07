package org.nero.click.admin.dao;

import org.click.admin.entity.Footer;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-5
 * Time   :  下午7:40
 */
public interface FooterDao {

    /**
     * 获取页脚
     * @return
     */
    Footer getFooter();

    /**
     * 设置页脚
     * @param label
     * @return
     */
    int setFooter(String label);
}

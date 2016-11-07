package org.nero.click.admin.dao;

import org.click.admin.entity.Logo;

import java.util.List;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-5
 * Time   :  下午7:41
 */
public interface LogoDao {

    /**
     * 添加友情logo
     * @param description
     * @param hrefUrl
     * @param imgUrl
     * @return
     */
    int addLogo(String description, String hrefUrl, String imgUrl);

    /**
     * 删除友情logo
     * @param id
     * @return
     */
    int delLogo(Long id);

    /**
     * 获取友情logo
     * @return
     */
    List<Logo> getLogos();
}

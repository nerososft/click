package org.nero.click.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.click.admin.entity.Banner;
import org.nero.click.sso.dto.Operate;

import java.util.List;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-5
 * Time   :  下午7:40
 */
public interface BannerDao {

    /**
     * 添加轮播图
     * @param description
     * @param imgUrl
     * @param hrefUrl
     * @return
     */
    int addBanner(@Param("description") String description,
                  @Param("imgUrl") String imgUrl,
                  @Param("hrefUrl") String hrefUrl);

    /**
     * 删除轮播图
     * @param id
     * @return
     */
    int delBanner(Long id);

    /**
     * 获取轮播图
     * @return
     */
    List<Banner> getBanners();

}

package org.nero.click.admin.service;

import org.click.admin.entity.*;
import org.nero.click.sso.dto.Operate;

import java.util.List;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-5
 * Time   :  下午7:32
 */
public interface IPageService {

    /**
     * 设置网页标题与顶部描述语句
     * @param title
     * @param label
     * @return
     */
    Operate<Header> setHeader(String title,String label);

    /**
     * 设置网页底部描述语
     * @param label
     * @return
     */
    Operate<Footer> setFooter(String label);

    /**
     * 添加友情链接
     * @param name
     * @param hrefUrl
     * @return
     */
    Operate<Link> addLink(String name,String hrefUrl);

    /**
     * 删除友情链接
     * @param id
     * @return
     */
    Operate<Link> delLink(Long id);

    /**
     * 添加顶部友情logo
     * @param descript
     * @param hrefUrl
     * @param imgUrl
     * @return
     */
    Operate<Logo> addLogo(String descript,String hrefUrl,String imgUrl);

    /**
     * 删除顶部友情logo
     * @param id
     * @return
     */
    Operate<Logo> delLogo(Long id);

    /**
     * 添加banner
     * @param descrip
     * @param imgUrl
     * @param hrefUrl
     * @return
     */
    Operate<Banner> addBanner(String descrip,String imgUrl,String hrefUrl);

    /**
     * 删除banner
     * @param id
     * @return
     */
    Operate<Banner> delBanner(Long id);

    /**
     * 获取网页标题与描述
     * @return
     */
    Operate<Header> getHeader();

    /**
     * 获取网页底部描述
     * @return
     */
    Operate<Footer> getFooter();

    /**
     * 获取友情链接
     * @return
     */
    Operate<List<Link>> getLinks();

    /**
     * 获取友情logo
     * @return
     */
    Operate<List<Logo>> getLogos();

    /**
     * 获取banner
     * @return
     */
    Operate<List<Banner>> getBanners();


}

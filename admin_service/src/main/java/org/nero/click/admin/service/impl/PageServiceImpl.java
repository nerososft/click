package org.nero.click.admin.service.impl;

import org.click.admin.entity.*;
import org.nero.click.admin.service.IPageService;
import org.nero.click.sso.dto.Operate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-5
 * Time   :  下午10:36
 */
@Service
public class PageServiceImpl implements IPageService {
    public Operate<Header> setHeader(String title, String label) {
        return null;
    }

    public Operate<Footer> setFooter(String label) {
        return null;
    }

    public Operate<Link> addLink(String name, String hrefUrl) {
        return null;
    }

    public Operate<Link> delLink(Long id) {
        return null;
    }

    public Operate<Logo> addLogo(String descript, String hrefUrl, String imgUrl) {
        return null;
    }

    public Operate<Logo> delLogo(Long id) {
        return null;
    }

    public Operate<Banner> addBanner(String descrip, String imgUrl, String hrefUrl) {
        return null;
    }

    public Operate<Banner> delBanner(Long id) {
        return null;
    }

    public Operate<Header> getHeader() {
        return null;
    }

    public Operate<Footer> getFooter() {
        return null;
    }

    public Operate<List<Link>> getLinks() {
        return null;
    }

    public Operate<List<Logo>> getLogos() {
        return null;
    }

    public Operate<List<Banner>> getBanners() {
        return null;
    }
}

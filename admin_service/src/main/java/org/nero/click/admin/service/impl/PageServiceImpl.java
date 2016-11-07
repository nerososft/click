package org.nero.click.admin.service.impl;

import org.click.admin.entity.*;
import org.nero.click.admin.dao.*;
import org.nero.click.admin.service.IPageService;
import org.nero.click.sso.dto.Operate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.click.admin.CONSTANT.CONSTANT.*;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-5
 * Time   :  下午10:36
 */
@Service
public class PageServiceImpl implements IPageService {


    

    @Autowired private HeaderDao headerDao;
    @Autowired private LogoDao logoDao;
    @Autowired private LinkDao linkDao;
    @Autowired private BannerDao bannerDao;
    @Autowired private FooterDao footerDao;

    public Operate<Header> setHeader(String title, String label) {
        if(headerDao.getHeader()!=null){
            int modify = headerDao.modifyHeader(title, label);
            if(modify<0){
                return new Operate<Header>(false,PAGE_SET_FAILED.DESC,new Header(title,label));
            }
        }else{
            int add =  headerDao.addHeader(title,label);
            if(add<0){
                return new Operate<Header>(false,PAGE_ADD_FAILED.DESC,new Header(title,label));
            }
        }
        return new Operate<Header>(true,PAGE_SET_SUCCESS.DESC,new Header(title,label));
    }

    public Operate<Footer> setFooter(String label) {
        if(footerDao.getFooter()!=null){
            int modify = footerDao.setFooter(label);
            if(modify<0){
                return new Operate<Footer>(false,PAGE_SET_FAILED.DESC,new Footer(label));
            }
        }else{
            int add =  footerDao.setFooter(label);
            if(add<0){
                return new Operate<Footer>(false,PAGE_ADD_FAILED.DESC,new Footer(label));
            }
        }
        return new Operate<Footer>(true,PAGE_SET_SUCCESS.DESC,new Footer(label));
    }

    public Operate<Link> addLink(String name, String hrefUrl) {
        int add = linkDao.addLink(name,hrefUrl);
        if(add<0){
            return new Operate<Link>(false,PAGE_ADD_FAILED.DESC,new Link(name,hrefUrl));
        }
        return new Operate<Link>(true,PAGE_ADD_SUCCESS.DESC,new Link(name,hrefUrl));
    }

    public Operate<Link> delLink(Long id) {
        int del = linkDao.delLink(id);
        if(del<0){
            return new Operate<Link>(false,PAGE_DEL_FAILED.DESC,null);
        }
        return new Operate<Link>(true,PAGE_DEL_SUCCESS.DESC,null);
    }

    public Operate<Logo> addLogo(String description, String hrefUrl, String imgUrl) {
        int add = logoDao.addLogo(description, hrefUrl, imgUrl);
        if(add<0){
            return new Operate<Logo>(false,PAGE_ADD_FAILED.DESC,new Logo(description, hrefUrl, imgUrl));
        }
        return new Operate<Logo>(true,PAGE_ADD_SUCCESS.DESC,new Logo(description, hrefUrl, imgUrl));
    }

    public Operate<Logo> delLogo(Long id) {
        int del = logoDao.delLogo(id);
        if(del<0){
            return new Operate<Logo>(false,PAGE_DEL_FAILED.DESC,null);
        }
        return new Operate<Logo>(true,PAGE_DEL_SUCCESS.DESC,null);
    }

    public Operate<Banner> addBanner(String description, String imgUrl, String hrefUrl) {
        int add = bannerDao.addBanner(description, imgUrl,hrefUrl);
        if(add<0){
            return new Operate<Banner>(false,PAGE_ADD_FAILED.DESC,new Banner(description, imgUrl,hrefUrl));
        }
        return new Operate<Banner>(true,PAGE_ADD_SUCCESS.DESC,new Banner(description, imgUrl,hrefUrl));

    }

    public Operate<Banner> delBanner(Long id) {
        int del = bannerDao.delBanner(id);
        if(del<0){
            return new Operate<Banner>(false,PAGE_DEL_FAILED.DESC,null);
        }
        return new Operate<Banner>(true,PAGE_DEL_SUCCESS.DESC,null);
    }

    public Operate<Header> getHeader() {
        return new Operate<Header>(true,headerDao.getHeader());
    }

    public Operate<Footer> getFooter() {
        return new Operate<Footer>(true,footerDao.getFooter());
    }

    public Operate<List<Link>> getLinks() {
        return new Operate<List<Link>>(true,linkDao.getLinks());
    }

    public Operate<List<Logo>> getLogos() {
        return new Operate<List<Logo>>(true,logoDao.getLogos());
    }

    public Operate<List<Banner>> getBanners() {
        return new Operate<List<Banner>>(true,bannerDao.getBanners());
    }
}

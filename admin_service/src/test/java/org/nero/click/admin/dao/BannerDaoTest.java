package org.nero.click.admin.dao;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-9
 * Time   :  下午9:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class BannerDaoTest {

    @Autowired
    private BannerDao bannerDao;

    @org.junit.Test
    public void addBanner() throws Exception {
        int add = bannerDao.addBanner("描述2","img","href");
        if(add<1){
            System.out.println("add failed");
        }else {
            System.out.println("add success!");
        }
    }

    @org.junit.Test
    public void delBanner() throws Exception {
        long id = 1;
        int del = bannerDao.delBanner(id);
        if(del<1){
            System.out.println("failed");
        }else {
            System.out.println("success");
        }
    }

    @org.junit.Test
    public void getBanners() throws Exception {
        System.out.println(bannerDao.getBanners());
    }

}
package org.nero.click.admin.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-9
 * Time   :  下午9:43
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class LinkDaoTest {

    @Autowired
    private LinkDao linkDao;

    @Test
    public void addLink() throws Exception {
        int add = linkDao.addLink("天外天","www.twt.wdu.cn");
        if(add<1){
            System.out.println("failed");
        }else{
            System.out.println("success");
        }
    }

    @Test
    public void delLink() throws Exception {
        int add = linkDao.delLink(1);
        if(add<1){
            System.out.println("failed");
        }else{
            System.out.println("success");
        }
    }

    @Test
    public void getLinks() throws Exception {
        System.out.println(linkDao.getLinks());
    }

}
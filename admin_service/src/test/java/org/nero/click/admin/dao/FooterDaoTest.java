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
public class FooterDaoTest {

    @Autowired
    private FooterDao footerDao;

    @Test
    public void getFooter() throws Exception {
        System.out.println(footerDao.getFooter());
    }

    @Test
    public void setFooter() throws Exception {
        int set = footerDao.setFooter("新标签");
        if(set<1){
            System.out.println("failed");
        }else {
            System.out.println("success");
        }
    }

}
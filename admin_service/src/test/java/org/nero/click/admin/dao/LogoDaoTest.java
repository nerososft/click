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
public class LogoDaoTest {

    @Autowired
    private LogoDao logoDao;

    @Test
    public void addLogo() throws Exception {
        int add = logoDao.addLogo("天外天","www.twt.wdu.cn","ssss");
        if(add<1){
            System.out.println("failed");
        }else{
            System.out.println("success");
        }
    }

    @Test
    public void delLogo() throws Exception {
        int add = logoDao.delLogo(1);
        if(add<1){
            System.out.println("failed");
        }else{
            System.out.println("success");
        }
    }

    @Test
    public void getLogos() throws Exception {
        System.out.println(logoDao.getLogos());
    }

}
package org.nero.click.admin.dao;

import org.click.admin.entity.Header;
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
public class HeaderDaoTest {

    @Autowired
    private HeaderDao headerDao;

    @Test
    public void getHeader() throws Exception {
        System.out.println(headerDao.getHeader());
    }

    @Test
    public void modifyHeader() throws Exception {
        int modify = headerDao.modifyHeader("新的官网","新的口号");
        if(modify<1){
            System.out.println("failed");
        }else{
            System.out.println("success");
        }
    }

    @Test
    public void addHeader() throws Exception {

    }

}
package org.nero.click.data.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/4
 * Time   下午9:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class DeflectionDaoTest {

    @Autowired
    private DeflectionDao deflectionDao;

    @Test
    public void getDel() throws Exception {
        System.out.println(deflectionDao.getDel("1","gbm","c").size());
    }



}
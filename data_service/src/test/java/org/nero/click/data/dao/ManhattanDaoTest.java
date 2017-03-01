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
 * Date   2017/2/26
 * Time   下午10:51
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class ManhattanDaoTest {


    @Autowired
    private ManhattanDao manhattanDao;

    @Test
    public void getMoutainData() throws Exception {
        System.out.println(manhattanDao.getManhattanData("1","c"));
    }

    @Test
    public void getSampleAll() throws Exception {
        System.out.println(manhattanDao.getSampleAll("cead",
                "e",
                manhattanDao.getManhattanData("1","e"),
                "t"));
    }

    @Test
    public void getManhattan() throws Exception {

    }

}
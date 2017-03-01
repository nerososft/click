package org.nero.click.data.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/1/19
 * Time   下午11:45
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class MoutainDaoTest {


    @Autowired
    private MoutainDao moutainDao;


    @Test
    public void getMoutainData() throws Exception {
        System.out.println(moutainDao.getMoutainData("1","c").toString());
    }

    @Test
    public void getSample() throws Exception {
        System.out.println(moutainDao.getSample("1","gbm","n","e","y","0","1"));
    }

    @Test
    public void getMoutain() throws Exception {
        List<Long> geneid = new ArrayList<Long>();
        geneid.add(Long.valueOf(1));
        geneid.add(Long.valueOf(2));
        geneid.add(Long.valueOf(3));
        geneid.add(Long.valueOf(4));
        geneid.add(Long.valueOf(5));

        System.out.println(moutainDao.getMoutain(geneid,"c","t","l","mid","gbm"));
    }

}
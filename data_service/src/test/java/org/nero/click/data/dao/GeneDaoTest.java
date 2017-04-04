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
 * Date   2016/12/26
 * Time   下午4:54
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class GeneDaoTest {
    @Autowired
    private GeneDao geneDao;
    @Test
    public void findGene() throws Exception {
        System.out.println(geneDao.findGene("c","BBBB"));
    }

}
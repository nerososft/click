package org.nero.click.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nero on 2016/10/25 0025.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ManhattanDaoTest {

    @Resource
    private ManhattanDao manhattanDao;

    @Test
    public void getGeneId() throws Exception {
        List<Integer> chrom  = new ArrayList<Integer>();
        chrom.add(22);
        System.out.println(manhattanDao.getGeneId(chrom));
    }

    @Test
    public void getPropertyId() throws Exception {
        List<Integer> geneid = new ArrayList<Integer>();
        geneid.add(1);
        geneid.add(2);
        geneid.add(3);
        System.out.println(manhattanDao.getPropertyId(geneid));
    }

    @Test
    public void manhattan() throws Exception {
        List<Integer> proid = new ArrayList<Integer>();
        proid.add(1);
        proid.add(2);
        proid.add(3);
        proid.add(4);
        proid.add(5);
        proid.add(6);
        proid.add(7);
        proid.add(8);
        proid.add(9);

        String table = "proplggn";
        System.out.println(manhattanDao.manhattan(proid,table));
    }

    @Test
    public void fuckingAllTest() throws Exception{
        List<Integer> chrom  = new ArrayList<Integer>();
        chrom.add(22);

        System.out.println(manhattanDao.manhattan(manhattanDao.getPropertyId(manhattanDao.getGeneId(chrom)),"proplggn"));
    }

}
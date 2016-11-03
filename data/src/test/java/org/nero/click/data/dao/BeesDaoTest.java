package org.nero.click.admin.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.click.admin.dto.Point;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Author nero
 * Date   2016/10/16 0016
 * Time   19:35
 * Email  nerosoft@outlook.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class BeesDaoTest {

    @Resource
    private BeesDao genepDao;

    @Test
    public void getGeneId() throws Exception {
        List<String> s = new ArrayList<String>();
        s.add("NHSL2");
        s.add("GGA1");

        System.out.println( genepDao.getGeneId(s));
    }
    @Test
    public void getPropertyId() throws Exception {
        List<Integer> integerlist = new ArrayList<Integer>();
        integerlist.add(24002);
        integerlist.add(23309);
        List<Integer> s = genepDao.getPropertyId(integerlist,"gbmtID");
        System.out.println(s);
    }
    @Test
    public void getBeesPoints() throws Exception {

        List<Integer> s = new ArrayList<Integer>();
        s.add(14239967);
        s.add(14239968);
        List<Point> p = genepDao.getBeesPoints(s,"proplggn");
        System.out.println(p);
    }
    @Test
    public void getBox() throws Exception {
        List<String> cancertype = new ArrayList<String>();
        List<String> genename  = new ArrayList<String>();
        cancertype.add("GBM");
        genename.add("CPTP");
        System.out.println(genepDao.getBox(cancertype,genename));
    }


}
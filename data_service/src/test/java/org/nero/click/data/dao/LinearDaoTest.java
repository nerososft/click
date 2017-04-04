package org.nero.click.data.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.click.data.dto.linear.LinearPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Whishou on 2017/4/4.
 * Email: whishoutan@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class LinearDaoTest {

    @Autowired
    private LinearDao linearDao;
    @Test
    public void getLinearId() throws Exception{
        System.out.println(linearDao.getLinearId("NPSR1-AS1"));
    }
    @Test
    public void getLinearPoint() throws Exception{
        List<LinearPoint> point= linearDao.getLinearPoint("brca","38","e","t","y");
        System.out.println(point);
    }
    @Test
    public void getLinearPoint2() throws Exception{
        List<LinearPoint> point2=linearDao.getLinearPoint2("brca","38","c","t","y");
        System.out.println(point2);
    }

}

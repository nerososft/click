package org.nero.click.data.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.click.data.entity.VolcanoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Whishou on 2017/4/9.
 * Email: whishoutan@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class VolcanoDaoTest {
    @Autowired
    private VolcanoDao volcanoDao;

    @Test
    public void getVolcanoData() throws Exception{
        List<VolcanoData> data=volcanoDao.getVolcanoData("gbm","e");
        System.out.println(data);
    }
}
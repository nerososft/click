package org.nero.click.data.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.click.data.dto.MoutainPoint;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


/**
 * Author nero
 * Date   2016/10/20 0020
 * Time   23:47
 * Email  nerosoft@outlook.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class MoutainDaoTest {

    @Resource
    private MoutainDao moutainDao;

    @Test
    public void moutain() throws Exception {
        List<MoutainPoint> moutainPoints = moutainDao.moutain("8","avgGBMn");
        System.out.println(moutainPoints);
    }

}
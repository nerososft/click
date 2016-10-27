package org.nero.click.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.click.utils.rendom.RandomString;
import org.springframework.aop.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-6
 * time: 下午6:02.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring/spring-dao.xml")
public class GeneDaoTest {

    //@Resource
    //private GeneDao geneDao;
    @Test
    public void selectAll() throws Exception {


        List<PointText> list = new ArrayList<PointText>();
        Random random = new Random();
        for(int j = 0;j<250;j++) {
            int top = random.nextInt(500);
            for (int i = 0; i < 2000; i++) {
                PointText pointText = new PointText(j,random.nextInt(top) , new RandomString().getRandomString(8));
                list.add(pointText);
            }
        }

        FileWriter fileWriter = new FileWriter(System.getProperty("user.dir")+ File.separator+"points.js",true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("var dataset = " + list.toString());
        bufferedWriter.flush();
        bufferedWriter.close();

    }

    @Test
    public void queryByGenes() throws Exception {

    }

}
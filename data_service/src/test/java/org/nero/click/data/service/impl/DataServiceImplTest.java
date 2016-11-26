package org.nero.click.data.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.click.data.dto.Point;
import org.nero.click.data.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-25
 * Time   :  下午7:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class DataServiceImplTest {

    @Autowired
    private IDataService dataService;

    @Test
    public void beeswarm() throws Exception {

        List<String> genes = new ArrayList<String>();
        genes.add("EGFR");
        genes.add("IHH");

        List<Point> p = dataService.beeswarm(genes,"lgg","n","c","y","0","1");

        System.out.println(p.toString());
    }

}
package org.nero.click.data.dao;

import javassist.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.click.data.dto.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-25
 * Time   :  下午7:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class BeesDaoTest {

    @Autowired
    private BeesDao beesDao;

    @Test
    public void getGeneId() throws Exception {
        List<String> genes = new ArrayList<String>();
        genes.add("EGFR");
        genes.add("IHH");
        List<Integer> ids = beesDao.getGenesId(genes,"c");
        System.out.println(ids);
    }
    @Test
    public void getTables(){
        System.out.println(beesDao.getTables().toString());
    }

    @Test
    public void getColumns(){
        String cancer = "paad";
        String normal = "n";
        String datatype = "c";
        String islog = "l";
        String index ="0";
        String page = "1";
        String table =cancer+normal+datatype+islog+index+page;
        List<String> propNames = beesDao.getColumns(cancer,normal,datatype,islog,index,page);

    }
    @Test
    public void getBeesPoints() {
        List<String> genes = new ArrayList<String>();
        genes.add("EGFR");
        genes.add("IHH");
        List<Integer> ids = beesDao.getGenesId(genes,"c");
        //List<Point> values = beesDao.getData(ids,"");
        //System.out.println(values.toString());
    }


}
package org.nero.click.data.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.click.data.dao.BeesDao;
import org.nero.click.data.dao.MoutainDao;
import org.nero.click.data.dto.Point;
import org.nero.click.data.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private BeesDao beesDao;

    @Autowired
    private MoutainDao moutainDao;


    @Test
    public void checkGene() throws Exception {
        System.out.println(dataService.checkGene("c","EGFR,MIB2,ADM,390284,ACADL"));
    }
    @Test
    public void beeswarm() throws Exception {

        List<String> genes = new ArrayList<String>();
        genes.add("EGFR");
        //genes.add("IHH");

        String cancerType = "gbm,lgg";
        String[] strings1 = cancerType.split(",");

        List<List<List<Point>>> allgens = new ArrayList<List<List<Point>>>();
        double x = 0.0;
        for (String aStrings1 : strings1) {
            List<List<Point>> genesteam = new ArrayList<List<Point>>();
            //查询样本
            List<Point> bees = dataService.beeswarm(genes,aStrings1,"n","e","y","0","1");
            for (Point point : bees) {
                point.setX(point.getX() + x);
            }
            //添加样本
            genesteam.add(bees);
            allgens.add(genesteam);
        }


        System.out.println(allgens.toString());
    }
    @Test
    public void getMoutainData() throws Exception {
        System.out.println(dataService.getMoutainData("1","c"));
    }

    @Test
    public void getChromosomeValue() throws Exception {

        List<Double> samples = moutainDao.getSample("1","gbm","t","e","y","0","1");//.getData(geneId,"gbm","t","e","y","0","1");

        for (Double sample:samples){
            System.out.println(sample);
        }

        System.out.println(dataService.getChromosomeValue(samples,"mean"));
    }

    @Test
    public void getMantainPoint() throws Exception {
        System.out.println(dataService.getMantainPoint("1","c","gbm","l","mid"));
    }

    @Test
    public void getCyto() throws Exception {
        System.out.println(dataService.getCyto(dataService.getMoutainData("1","c")).toString());
    }

    @Test
    public void getArm() throws Exception {
        System.out.println(dataService.getArm(dataService.getMoutainData("1","c")).toString());
    }

    @Test
    public void moutain() throws Exception {
        dataService.moutain("gbm","1","c","l","mid");
    }
    @Test
    public void getManhattan() throws Exception {
        System.out.println(dataService.getManhattan("cead","e"));
    }

}
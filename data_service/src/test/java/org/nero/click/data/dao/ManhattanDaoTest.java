package org.nero.click.data.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.click.data.dto.Point;
import org.nero.click.data.dto.manhattan.ManhattanPoint;
import org.nero.click.data.entity.SimpleGene;
import org.nero.click.data.utils.TTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.awt.image.SampleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/2/26
 * Time   下午10:51
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class ManhattanDaoTest {



    @Autowired
    private ManhattanDao manhattanDao;

    @Test
    public void getMoutainData() throws Exception {
        System.out.println(manhattanDao.getManhattanData("1","c"));
    }

    @Test
    public void getSampleAll() throws Exception {
        List<String> geneid = new ArrayList<String>();

        List<SimpleGene> ss = manhattanDao.getManhattanData("1","e");
        for(SimpleGene simpleGene :ss ){
            geneid.add(String.valueOf(simpleGene.getID()));
        }

        List<ManhattanPoint> genes1 = manhattanDao.getSampleAll("cead",
                "e",
                geneid,
                "t","l");
        List<ManhattanPoint> genes2 = manhattanDao.getSampleAll("cead",
                "e",
                geneid,
                "n","l");


        Map<String,List<Double>> mapa = new HashMap<String, List<Double>>();
        Map<String,List<Double>> mapb = new HashMap<String, List<Double>>();

        for(ManhattanPoint a:genes1){
            if(mapa.get(String.valueOf(a.getGeneId()))==null){
                List<Double> doubles = new ArrayList<Double>();
                doubles.add(a.getY());
                mapa.put(String.valueOf(a.getGeneId()),doubles);
            }else{
                mapa.get(String.valueOf(a.getGeneId())).add(a.getY());
            }
        }
        for(ManhattanPoint b:genes2){
            if(mapb.get(String.valueOf(b.getGeneId()))==null){
                List<Double> doubles = new ArrayList<Double>();
                doubles.add(b.getY());
                mapb.put(String.valueOf(b.getGeneId()),doubles);
            }else{
                mapb.get(String.valueOf(b.getGeneId())).add(b.getY());
            }
        }

        List<Double> ttttttt = new ArrayList<Double>();
        for(String gen:geneid){
            ttttttt.add(TTest.test(mapa.get(gen),mapb.get(gen)));
        }
        System.out.println("________________________________________");
        System.out.println(ttttttt.size());
        System.out.println("________________________________________");
        System.out.println(ttttttt);
    }

    @Test
    public void getManhattan() throws Exception {

    }
    @Test
    public void getPanhattanData() throws Exception {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println(manhattanDao.getPanhattanData("1","c","gbm"));
        System.out.println("--------------------------------------------------------------------------");
    }
}
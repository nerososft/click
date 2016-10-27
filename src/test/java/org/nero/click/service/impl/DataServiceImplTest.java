package org.nero.click.service.impl;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.click.cache.CacheThread;
import org.nero.click.cache.ICacheService;
import org.nero.click.dto.MoutainPoint;
import org.nero.click.dto.Point;
import org.nero.click.service.IDataService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.resource.spi.AuthenticationMechanism;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-6
 * time: 下午5:57.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class DataServiceImplTest {

    @Autowired
    private IDataService dataService;

    @Autowired
    private ICacheService cacheService;


    @Test
    public void beeswarm() throws Exception {
        List<String> strings = new ArrayList<String>();
            String genes = "PRAMEF5,DDX11L1,NOC2L,ID3,GPN2";
        String[] strings1 = genes.split(",");


        if(cacheService.isDiskCached(genes,System.getProperty("user.dir")+ File.separator+"cache/beesworm/")){
            //有缓存
            System.out.println("cache:"+System.getProperty("user.dir")+ File.separator+"cache/beesworm/DDX11L1.js");
        }else{
            //无缓存

            List<Point> allgens = new ArrayList<Point>();
            double x = 0.0;
            for (String aStrings1 : strings1) {
                //构造查询基因list
                List<String> stringList = new ArrayList<String>();
                stringList.add(aStrings1);
                //查询正常样本
                List<Point> t = dataService.beeswarm(stringList, "proplggn");
                for (Point point : t) {
                    point.setX(point.getX() + x);
                    allgens.add(point);
                }
                System.out.println(t.size());
                //查询非正常样本
                List<Point> n = dataService.beeswarm(stringList, "proplggt");
                for (Point point : n) {
                    point.setX(point.getX() + x);
                    allgens.add(point);
                }
                System.out.println(n.size());
                x += 3.0;
            }
            //初始化缓存线程
            CacheThread cacheThread = new CacheThread(cacheService,
                    System.getProperty("user.dir")+ File.separator+"cache/beesworm/",
                    genes,
                    allgens.toString());
            //调用异步磁盘缓存
            cacheThread.start();
            System.out.println("cached:"+System.getProperty("user.dir")+ File.separator+"cache/beesworm/DDX11L1.js");
        }
    }

    @Test
    public void moutain() throws Exception {

        List<MoutainPoint> moutainPoints = dataService.moutain("1","avgGBMn");
        float x = 0;
        for(MoutainPoint m:moutainPoints){
            m.setX(x);
            x+=0.001;
        }
        System.out.println(moutainPoints);
    }

}
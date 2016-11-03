package org.nero.click.admin.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.click.admin.cache.CacheThread;
import org.nero.click.admin.dto.MoutainPoint;
import org.nero.click.admin.dto.Point;
import org.nero.click.admin.service.IDataService;
import org.nero.click.admin.cache.ICacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
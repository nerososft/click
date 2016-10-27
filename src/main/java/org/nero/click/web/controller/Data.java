package org.nero.click.web.controller;

import org.nero.click.cache.CacheThread;
import org.nero.click.cache.ICacheService;
import org.nero.click.dto.MoutainPoint;
import org.nero.click.dto.Operate;
import org.nero.click.dto.Point;
import org.nero.click.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.*;

/**
 * Author nero
 * Date   2016/10/16 0016
 * Time   22:07
 * Email  nerosoft@outlook.com
 */
@RestController
@Controller
@RequestMapping("/data")
public class Data {

    @Autowired
    private IDataService iDataService;

    @Autowired
    private ICacheService iCacheService;

    @RequestMapping(value = "/{genename}/{cancertype}/beeswarm",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<Point>> beesworm(@PathVariable("genename") String genes,
                                         @PathVariable("cancertype") String cancertype) {
        String[] strings1 = genes.split(",");
        if (iCacheService.isDiskCached(genes, System.getProperty("user.dir") + File.separator + "cache/beesworm/")) {
            //有缓存
            return new Operate<List<Point>>(false,
                    System.getProperty("user.dir") + File.separator + "cache/beesworm/" + genes,
                    null);
        } else {
            //无缓存

            List<Point> allgens = new ArrayList<Point>();
            double x = 0.0;
            for (String aStrings1 : strings1) {
                //构造查询基因list
                List<String> stringList = new ArrayList<String>();
                stringList.add(aStrings1);
                //查询正常样本
                List<Point> t = iDataService.beeswarm(stringList, "prop"+cancertype+"n");
                for (Point point : t) {
                    point.setX(point.getX() + x);
                    allgens.add(point);
                }
                System.out.println(t.size());
                //查询非正常样本
                List<Point> n = iDataService.beeswarm(stringList, "prop"+cancertype+"t");
                for (Point point : n) {
                    point.setX(point.getX() + x);
                    allgens.add(point);
                }
                System.out.println(n.size());
                x += 3.0;
            }
            //初始化缓存线程
            CacheThread cacheThread = new CacheThread(iCacheService,
                    System.getProperty("user.dir") + File.separator + "cache/beesworm/",
                    genes,
                    allgens.toString());
            //调用异步磁盘缓存
            cacheThread.start();
            return new Operate<List<Point>>(true, allgens);
        }
    }


    @RequestMapping(value = "/{genename}/{cancertype}/beeswarmnew",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<List<List<Point>>>> beeswormnew(@PathVariable("genename") String genes,
                                                        @PathVariable("cancertype") String cancertype) {
        String[] strings1 = genes.split(",");
        if (iCacheService.isDiskCached(genes, System.getProperty("user.dir") + File.separator + "cache/beesworm/")) {
            //有缓存
            return new Operate<List<List<List<Point>>>>(false,
                    System.getProperty("user.dir") + File.separator + "cache/beeswormnew/" + genes,
                    null);
        } else {
            //无缓存

            List<List<List<Point>>> allgens = new ArrayList<List<List<Point>>>();
            double x = 0.0;
            for (String aStrings1 : strings1) {
                List<List<Point>> genesteam = new ArrayList<List<Point>>();

                //构造查询基因list
                List<String> stringList = new ArrayList<String>();
                stringList.add(aStrings1);
                //查询正常样本
                List<Point> t = iDataService.beeswarm(stringList, "prop"+cancertype+"n");
                for (Point point : t) {
                    point.setX(point.getX() + x);
                }
                System.out.println(t.size());
                //查询非正常样本
                List<Point> n = iDataService.beeswarm(stringList, "prop"+cancertype+"t");
                for (Point point : n) {
                    point.setX(point.getX() + x);
                }
                System.out.println(n.size());
                x += 3.0;
                //添加正常样本
                genesteam.add(t);
                //添加不正常样本
                genesteam.add(n);

                allgens.add(genesteam);
            }

            //初始化缓存线程
            CacheThread cacheThread = new CacheThread(iCacheService,
                    System.getProperty("user.dir") + File.separator + "cache/beesworm/",
                    genes,
                    allgens.toString());
            //调用异步磁盘缓存
            cacheThread.start();
            return new Operate<List<List<List<Point>>>>(true,allgens);
        }
    }


    @RequestMapping(value = "/{chrom}/{type}/moutain",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<MoutainPoint>> moutain(@PathVariable("chrom") String chrom,
                                               @PathVariable("type") String type) {
        List<MoutainPoint> moutainPoints = iDataService.moutain(chrom,type);
        float x = 0;
        for(MoutainPoint m:moutainPoints){
            m.setX(x);
            x+=0.001;
        }

        return new Operate<List<MoutainPoint>>(true,moutainPoints);

    }
}
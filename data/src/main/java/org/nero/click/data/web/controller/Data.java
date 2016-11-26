package org.nero.click.data.web.controller;

import org.nero.click.Consumer;
import org.nero.click.data.dto.MoutainPoint;
import org.nero.click.data.dto.Operate;
import org.nero.click.data.dto.Point;
import org.nero.click.data.service.IDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    private IDataService iDataService;


    @RequestMapping(value = "/{genename}/{cancertype}/beeswarmnew",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<List<List<Point>>>> beeswormnew(@PathVariable("genename") String genes,
                                                        @PathVariable("cancertype") String cancertype) {

        try {
            iDataService = (IDataService) Consumer.singleton().getBean("IDataService");

            ///List<Point> p = dataService.beeswarm(genes,"lgg","n","c","y","0","1");

            String[] strings1 = genes.split(",");

            List<List<List<Point>>> allgens = new ArrayList<List<List<Point>>>();
            double x = 0.0;
            for (String aStrings1 : strings1) {
                List<List<Point>> genesteam = new ArrayList<List<Point>>();

                //构造查询基因list
                List<String> stringList = new ArrayList<String>();
                stringList.add(aStrings1);
                //查询正常样本
                List<Point> t = iDataService.beeswarm(stringList, "prop" + cancertype + "n");
                for (Point point : t) {
                    point.setX(point.getX() + x);
                }
                System.out.println(t.size());
                //查询非正常样本
                List<Point> n = iDataService.beeswarm(stringList, "prop" + cancertype + "t");
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

            return new Operate<List<List<List<Point>>>>(true, allgens);
        }catch (IllegalStateException e){
            return new Operate<List<List<List<Point>>>>(false, "服务异常！", null);
        }
    }


    @RequestMapping(value = "/{chrom}/{type}/moutain",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<MoutainPoint>> moutain(@PathVariable("chrom") String chrom,
                                               @PathVariable("type") String type) {

        iDataService =(IDataService)  Consumer.singleton().getBean("IDataService");

        List<MoutainPoint> moutainPoints = iDataService.moutain(chrom,type);
        float x = 0;
        for(MoutainPoint m:moutainPoints){
            m.setX(x);
            x+=0.001;
        }

        return new Operate<List<MoutainPoint>>(true,moutainPoints);

    }
}
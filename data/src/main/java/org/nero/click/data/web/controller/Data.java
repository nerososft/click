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


    /**
     * find data by cancer type
     * @param genes
     * @param cancerType
     * @param dataType
     * @param value
     * @return
     */
    @RequestMapping(value = "/{genename}/{cancertype}/{datatype}/{value}/bycancer",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<List<List<Point>>>> bycancer(@PathVariable("genename") String genes,
                                                        @PathVariable("cancertype") String cancerType,
                                                        @PathVariable("datatype") String dataType,
                                                        @PathVariable("value") String value) {

        try {
            iDataService = (IDataService) Consumer.singleton().getBean("IDataService");


            String[] strings1 = genes.split(",");

            List<List<List<Point>>> allgens = new ArrayList<List<List<Point>>>();
            double x = 0.0;
            for (String aStrings1 : strings1) {
                List<List<Point>> genesteam = new ArrayList<List<Point>>();

                //构造查询基因list
                List<String> stringList = new ArrayList<String>();
                stringList.add(aStrings1);
                //查询正常样本
                List<Point> t = iDataService.beeswarm(stringList,cancerType,"n",dataType,value,"0","1");
                for (Point point : t) {
                    point.setX(point.getX() + x);
                }
                System.out.println(t.size());
                //查询非正常样本
                x+=1.0;
                List<Point> n = iDataService.beeswarm(stringList,cancerType,"t",dataType,value,"0","1");
                for (Point point : n) {
                    point.setX(point.getX() + x);
                }
                System.out.println(n.size());
                x += 2.0;
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

    /**
     * find data by gene
     * @param genes
     * @param cancerType
     * @param dataType
     * @param value
     * @return
     */
    @RequestMapping(value = "/{genename}/{cancertype}/{datatype}/{value}/bygene",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<List<List<Point>>>> bygene(@PathVariable("genename") String genes,
                                                   @PathVariable("cancertype") String cancerType,
                                                   @PathVariable("datatype") String dataType,
                                                   @PathVariable("value") String value) {

        try {
            iDataService = (IDataService) Consumer.singleton().getBean("IDataService");


            String[] strings1 = cancerType.split(",");

            List<String> genename = new ArrayList<String>();
            genename.add(genes);

            List<List<List<Point>>> allgens = new ArrayList<List<List<Point>>>();
            double x = 0.0;
            for (String aStrings1 : strings1) {
                List<List<Point>> genesteam = new ArrayList<List<Point>>();

                //查询正常样本
                List<Point> t = iDataService.beeswarm(genename,aStrings1,"n",dataType,value,"0","1");
                for (Point point : t) {
                    point.setX(point.getX() + x);
                }
                System.out.println(t.size());
                //查询非正常样本
                x+=1.0;
                List<Point> n = iDataService.beeswarm(genename,aStrings1,"t",dataType,value,"0","1");
                for (Point point : n) {
                    point.setX(point.getX() + x);
                }
                System.out.println(n.size());
                x += 2.0;
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



    @RequestMapping(value = "/{chrom}/{type}/bychrom",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<MoutainPoint>> bychrom(@PathVariable("chrom") String chrom,
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
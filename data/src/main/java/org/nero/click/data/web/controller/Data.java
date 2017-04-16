package org.nero.click.data.web.controller;

import org.apache.ibatis.annotations.Param;
import org.nero.click.Consumer;
import org.nero.click.data.dto.Operate;
import org.nero.click.data.dto.Point;
import org.nero.click.data.dto.linear.LinearCalPoint;
import org.nero.click.data.dto.manhattan.MTPoint;
import org.nero.click.data.dto.moutain.Moutain;
import org.nero.click.data.dto.volcano.VolcanoPoint;
import org.nero.click.data.entity.PGene;
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
    /***********************************************UTILS**************************************************************/
    /**
     * 样本x轴打散
     * @param bees
     * @return
     */
    public List<List<List<Point>>> xBeaten(List<List<List<Point>>> bees){
        double distance = 0.0;
        for(List<List<Point>> list_list_point:bees){
            //+1
            for (int j = 0;j<list_list_point.get(0).size();j++) {
                list_list_point.get(0).get(j).setX(list_list_point.get(0).get(j).getX() + distance);
            }
            distance+=1.0;
        }
        return bees;
    }

    /**
     * 双样本合并再打散
     * @param bees1
     * @param bees2
     * @return
     */
    public Operate<List<List<List<Point>>>> combineBees(Operate<List<List<List<Point>>>> bees1,Operate<List<List<List<Point>>>> bees2){
        //合并
        for(int i = 0;i<bees1.getData().size();i++){
            bees1.getData().get(i).add(bees2.getData().get(i).get(0));
        }

        double distance = 0.0;
        //x轴打散
        for(List<List<Point>> list_list_point:bees1.getData()){
            //n
            //+1
            for (int j = 0;j<list_list_point.get(0).size();j++) {
                list_list_point.get(0).get(j).setX(list_list_point.get(0).get(j).getX() + distance);
            }
            distance+=1.0;
            //t
            //+2
            for (int j = 0;j<list_list_point.get(1).size();j++) {
                list_list_point.get(1).get(j).setX(list_list_point.get(1).get(j).getX() + distance);
            }
            distance+=2.0;

        }

        return bees1;
    }
    /************************************************CHECK************************************************************/
    /**
     * 基因名称检测
     * @param geneName
     * @param dataType
     * @return
     */
    @RequestMapping(value = "/{genename}/{datatype}/gene/check",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Boolean> checkGene(@PathVariable("genename")String geneName,
                                      @PathVariable("datatype")String dataType){
        try {
            iDataService = (IDataService) Consumer.singleton().getBean("IDataService");
            return iDataService.checkGene(dataType,geneName);
        }catch (IllegalStateException e){
            return new Operate<Boolean>(false, "服务异常！", null);
        }
    }

    /**
     * 检查癌症名称
     * @param cancerName
     * @param dataType
     * @return
     */
    @RequestMapping(value = "/{cancername}/{datatype}/cancer/check",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Boolean> ckeckCancer(@PathVariable("cancername")String cancerName,
                                        @PathVariable("datatype")String dataType){
        try {
            iDataService = (IDataService) Consumer.singleton().getBean("IDataService");
            return iDataService.checkCancer(dataType,cancerName);
        }catch (IllegalStateException e){
            return new Operate<Boolean>(false, "服务异常！", null);
        }
    }
    /***********************************************BY CANCER*********************************************************/
    /**
     * 获取cancer bees数据
     * @param genes
     * @Param simpleType
     * @param cancerType
     * @param dataType
     * @param value
     * @return
     */
    public Operate<List<List<List<Point>>>> get_cancer_bees(String genes,
                                                     String simpleType,
                                                     String cancerType,
                                                     String dataType,
                                                     String value){
        try {
            iDataService = (IDataService) Consumer.singleton().getBean("IDataService");


            String[] strings1 = genes.split(",");

            List<List<List<Point>>> allgens = new ArrayList<List<List<Point>>>();
            for (String aStrings1 : strings1) {
                List<List<Point>> genesteam = new ArrayList<List<Point>>();
                //构造查询基因list
                List<String> stringList = new ArrayList<String>();
                stringList.add(aStrings1);
                //查询样本
                List<Point> bees = iDataService.beeswarm(stringList,cancerType,simpleType,dataType,value,"0","1");

                //添加样本
                genesteam.add(bees);
                allgens.add(genesteam);
            }

            return new Operate<List<List<List<Point>>>>(true, allgens);
        }catch (IllegalStateException e){
            return new Operate<List<List<List<Point>>>>(false, "服务异常！", null);
        }
    }
    /**
     * 查询正常样本
     * @param genes
     * @param cancerType
     * @param dataType
     * @param value
     * @return
     */
    public Operate<List<List<List<Point>>>> bycancer_nonmalignant(String genes,
                                                                  String cancerType,
                                                                  String dataType,
                                                                  String value){
       return get_cancer_bees(genes,"n",cancerType,dataType,value);
    }

    /**
     * 查询不正常样本
     * @param genes
     * @param cancerType
     * @param dataType
     * @param value
     * @return
     */
    public Operate<List<List<List<Point>>>> bycancer_tumor(String genes,
                                                           String cancerType,
                                                           String dataType,
                                                           String value){
        return get_cancer_bees(genes,"t",cancerType,dataType,value);
    }

    /**
     * 查询nonmalignant样本
     * @param genes
     * @param cancerType
     * @param dataType
     * @param value
     * @return
     */
    @RequestMapping(value = "/{genename}/{cancertype}/{datatype}/{value}/bycancer/nonmalignant",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<List<List<Point>>>> bycancer_nonmalignant_api(@PathVariable("genename") String genes,
                                                     @PathVariable("cancertype") String cancerType,
                                                     @PathVariable("datatype") String dataType,
                                                     @PathVariable("value") String value) {
        Operate<List<List<List<Point>>>> bees_nonmalignant =  bycancer_nonmalignant(genes,cancerType,dataType,value);
        if(bees_nonmalignant.isState()) {
            return new Operate<List<List<List<Point>>>>(true,xBeaten(bees_nonmalignant.getData()));
        }
        return bees_nonmalignant;

    }

    /**
     * 查询tumor样本
     * @param genes
     * @param cancerType
     * @param dataType
     * @param value
     * @return
     */
    @RequestMapping(value = "/{genename}/{cancertype}/{datatype}/{value}/bycancer/tumor",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<List<List<Point>>>> bycancer_tumor_api(@PathVariable("genename") String genes,
                                                                      @PathVariable("cancertype") String cancerType,
                                                                      @PathVariable("datatype") String dataType,
                                                                      @PathVariable("value") String value) {

        Operate<List<List<List<Point>>>> bees_tumor =  bycancer_tumor(genes,cancerType,dataType,value);
        if(bees_tumor.isState()) {
            return new Operate<List<List<List<Point>>>>(true,xBeaten(bees_tumor.getData()));
        }
        return bees_tumor;

    }
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
    public Operate<List<List<List<Point>>>> bycancer_api(@PathVariable("genename") String genes,
                                                        @PathVariable("cancertype") String cancerType,
                                                        @PathVariable("datatype") String dataType,
                                                        @PathVariable("value") String value) {

        List<List<List<Point>>> allBees = new ArrayList<List<List<Point>>>();

        Operate<List<List<List<Point>>>> byCancerNonmalignant = bycancer_nonmalignant(genes,cancerType,dataType,value);
        Operate<List<List<List<Point>>>> byCancerTumor = bycancer_tumor(genes,cancerType,dataType,value);

        if(byCancerNonmalignant.isState()&&byCancerTumor.isState()){

            //合并
            return combineBees(byCancerNonmalignant,byCancerTumor);

        }
        return byCancerNonmalignant.isState()?byCancerTumor:byCancerNonmalignant;
    }



    /***********************************************BY GENE ***********************************************************/
    /**
     * 获取样本bygene
     * @param genes
     * @param simpleType
     * @param cancerType
     * @param dataType
     * @param value
     * @return
     */
    public Operate<List<List<List<Point>>>> get_gene_bees(String genes,
                                                            String simpleType,
                                                            String cancerType,
                                                            String dataType,
                                                            String value){
        try {
            iDataService = (IDataService) Consumer.singleton().getBean("IDataService");


            String[] strings1 = cancerType.split(",");

            List<String> genename = new ArrayList<String>();
            genename.add(genes);
            List<List<List<Point>>> allgens = new ArrayList<List<List<Point>>>();
            double x = 0.0;
            for (String aStrings1 : strings1) {
                List<List<Point>> genesteam = new ArrayList<List<Point>>();
                //查询样本
                List<Point> bees = iDataService.beeswarm(genename,aStrings1,simpleType,dataType,value,"0","1");
                for (Point point : bees) {
                    point.setX(point.getX() + x);
                }
                //添加样本
                genesteam.add(bees);
                allgens.add(genesteam);
            }

            return new Operate<List<List<List<Point>>>>(true, allgens);
        }catch (IllegalStateException e){
            return new Operate<List<List<List<Point>>>>(false, "服务异常！", null);
        }
    }

    /**
     * 获取n样本bygene
     * @param genes
     * @param cancerType
     * @param dataType
     * @param value
     * @return
     */
    public Operate<List<List<List<Point>>>> bygene_nonmalignant(String genes,
                                                                  String cancerType,
                                                                  String dataType,
                                                                  String value){
        return get_gene_bees(genes,"n",cancerType,dataType,value);
    }

    /**
     * 获取t样本bygene
     * @param genes
     * @param cancerType
     * @param dataType
     * @param value
     * @return
     */
    public Operate<List<List<List<Point>>>> bygene_tumor(String genes,
                                                           String cancerType,
                                                           String dataType,
                                                           String value){
        return get_gene_bees(genes,"t",cancerType,dataType,value);
    }


    /**
     * 获取n样本API
     * @param genes
     * @param cancerType
     * @param dataType
     * @param value
     * @return
     */
    @RequestMapping(value = "/{genename}/{cancertype}/{datatype}/{value}/bygene/nonmalignant",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<List<List<Point>>>> bygene_nonmalignant_api(@PathVariable("genename") String genes,
                                                                      @PathVariable("cancertype") String cancerType,
                                                                      @PathVariable("datatype") String dataType,
                                                                      @PathVariable("value") String value) {
        Operate<List<List<List<Point>>>> bees_nonmalignant =  bygene_nonmalignant(genes,cancerType,dataType,value);
        if(bees_nonmalignant.isState()) {
            return new Operate<List<List<List<Point>>>>(true,xBeaten(bees_nonmalignant.getData()));
        }
        return bees_nonmalignant;

    }

    /**
     * 查询tumor样本API
     * @param genes
     * @param cancerType
     * @param dataType
     * @param value
     * @return
     */
    @RequestMapping(value = "/{genename}/{cancertype}/{datatype}/{value}/bygene/tumor",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<List<List<Point>>>> bygene_tumor_api(@PathVariable("genename") String genes,
                                                               @PathVariable("cancertype") String cancerType,
                                                               @PathVariable("datatype") String dataType,
                                                               @PathVariable("value") String value) {

        Operate<List<List<List<Point>>>> bees_tumor =  bygene_tumor(genes,cancerType,dataType,value);
        if(bees_tumor.isState()) {
            return new Operate<List<List<List<Point>>>>(true,xBeaten(bees_tumor.getData()));
        }
        return bees_tumor;

    }
    /**
     * bygene API
     * @param genes
     * @param cancerType
     * @param dataType
     * @param value
     * @return
     *
     */
    @RequestMapping(value = "/{genename}/{cancertype}/{datatype}/{value}/bygene",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<List<List<Point>>>> bygene_api(@PathVariable("genename") String genes,
                                                         @PathVariable("cancertype") String cancerType,
                                                         @PathVariable("datatype") String dataType,
                                                         @PathVariable("value") String value) {

        List<List<List<Point>>> allBees = new ArrayList<List<List<Point>>>();

        Operate<List<List<List<Point>>>> byGeneNonmalignant = bygene_nonmalignant(genes,cancerType,dataType,value);
        Operate<List<List<List<Point>>>> byGeneTumor = bygene_tumor(genes,cancerType,dataType,value);

        if(byGeneNonmalignant.isState()&&byGeneTumor.isState()){

            //合并
            return combineBees(byGeneNonmalignant,byGeneTumor);

        }
        return byGeneNonmalignant.isState()?byGeneTumor:byGeneNonmalignant;
    }


    /***********************************************MOUTAIN*************************************************************/


    //http://47.88.77.83:8080/data/data/gbm/1/c/l/mean/bychromosomes

    @RequestMapping(value = "/{cancerType}/{chromosomes}/{dataType}/{value}/{showValue}/bychromosomes",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Moutain> byChromosomes(@PathVariable("cancerType") String cancerType,
                                          @PathVariable("chromosomes") String chromosomes,
                                          @PathVariable("dataType") String dataType,
                                          @PathVariable("value") String value,
                                          @PathVariable("showValue") String showValue) {
        try {
            iDataService = (IDataService) Consumer.singleton().getBean("IDataService");


            return new Operate<Moutain>(true, iDataService.moutain(cancerType, chromosomes, dataType, value, showValue));
        }catch (IllegalStateException e){
            return new Operate<Moutain>(false,"服务异常！",null);
        }

    }


    /*********************************************曼哈顿**************************************************/
    @RequestMapping(value = "/{cancerType}/{dataType}/bydeflect",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<List<Point>>> getDeflection(@PathVariable("cancerType") String cancerType,
                                                   @PathVariable("dataType") String dataType){

        try{
            iDataService = (IDataService) Consumer.singleton().getBean("IDataService");

            return new Operate<List<List<Point>>>(true,iDataService.getManhattan(cancerType,dataType));
        }catch(IllegalStateException e){
            return new Operate<List<List<Point>>>(false,"服务异常！",null);
        }

    }
    @RequestMapping(value = "/{cancerType}/{dataType}/bymanhattan",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<List<Point>>> getManhattan(@PathVariable("cancerType") String cancerType,
                                                    @PathVariable("dataType") String dataType){

        try{
            iDataService = (IDataService) Consumer.singleton().getBean("IDataService");
            List<List<Point>>  manhattan = iDataService.getManhattan(cancerType,dataType);

            for(List<Point> ml:manhattan){
                for(Point m:ml) {
                    m.setY(Math.abs(m.getY()));
                }
            }
            return new Operate<List<List<Point>>>(true,manhattan);
        }catch(IllegalStateException e){
            return new Operate<List<List<Point>>>(false,"服务异常！",null);
        }

    }

//    String cancerType1, String cancerType2, String normal1, String normal2, String dataType, String isLog
    @RequestMapping(value = "/{cancertype1}/{cancertype2}/{normal1}/{normal2}/{datatype}/{islog}/bytanhattan",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<List<MTPoint>>> getTanhattan(@PathVariable("cancertype1") String cancerType1,
                                                     @PathVariable("cancertype2") String cancerType2,
                                                     @PathVariable("normal1") String normal1,
                                                     @PathVariable("normal2") String normal2,
                                                     @PathVariable("datatype") String datatype,
                                                     @PathVariable("islog") String islog){

        try{
            iDataService = (IDataService) Consumer.singleton().getBean("IDataService");
            List<List<MTPoint>>  manhattan = iDataService.getTanhattan(cancerType1,cancerType2,normal1,normal2,datatype,islog);
            return new Operate<List<List<MTPoint>>>(true,manhattan);
        }catch(IllegalStateException e){
            return new Operate<List<List<MTPoint>>>(false,"服务异常！",null);
        }

    }

    @RequestMapping(value = "/{cancertype}/{dataType}/bypanhattan",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<List<PGene>>> getPanhattan(@PathVariable("cancertype") String cancerType,
                                                   @PathVariable("dataType") String dataType){

        try{
            iDataService = (IDataService) Consumer.singleton().getBean("IDataService");
            List<List<PGene>>  manhattan = iDataService.getPanhattan(cancerType,dataType);
            return new Operate<List<List<PGene>>>(true,manhattan);
        }catch(IllegalStateException e){
            return new Operate<List<List<PGene>>>(false,"服务异常！",null);
        }

    }

    @RequestMapping(value = "/{cancertype}/{dataType}/bydeflection",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<List<PGene>>> byDeflection(@PathVariable("cancertype") String cancerType,
                                                   @PathVariable("dataType") String dataType){

        try{
            iDataService = (IDataService) Consumer.singleton().getBean("IDataService");
            List<List<PGene>>  manhattan = iDataService.getDeflection(cancerType,dataType);
            return new Operate<List<List<PGene>>>(true,manhattan);
        }catch(IllegalStateException e){
            return new Operate<List<List<PGene>>>(false,"服务异常！",null);
        }

    }


    /***********************************************LINEAR*************************************************************/

    /**
     * Linear Point
     * Created by Whishou
     * Email: whishoutan@gmail.com
     * date: 2017/2/24
     * @param cancerType
     * @param geneName
     * @param dataType
     * @param dataType2
     * @param sampleType
     * @param isLog
     * @return
     */


    @RequestMapping(value = "/{cancerType}/{geneName}/{dataType}/{dataType2}/{sampleType}/{isLog}/linearPoint",
            method = RequestMethod.GET,
            produces = {"application/json;charest=UTF-8"})

    @ResponseBody
    public List<LinearCalPoint> getAll(@PathVariable("cancerType") String cancerType,
                                       @PathVariable("geneName") String geneName,
                                       @PathVariable("dataType") String dataType,
                                       @PathVariable("dataType2") String dataType2,
                                       @PathVariable("sampleType") String sampleType,
                                       @PathVariable("isLog") String isLog){
        try {
            iDataService = (IDataService) Consumer.singleton().getBean("IDataService");

            List<LinearCalPoint> calculate=iDataService.calculate(cancerType,geneName,dataType,dataType2,sampleType,isLog);
            return calculate;
        }
        catch (IllegalStateException e){
            List<LinearCalPoint> error= new ArrayList<LinearCalPoint>();
            error.add(new LinearCalPoint());
            return error;
        }
    }

    /***********************************************VOLCANO*************************************************************/

    /**
     * Volcano plot
     * Created by Whishou
     * Email: whishoutan@gmail.com
     * date: 2017/4/9
     * @param cancerType
     * @param dataType
     * @return 
     */

    @RequestMapping(value = "/{cancerType}/{dataType}/volcano",
            method = RequestMethod.GET,
            produces = {"application/json;charest=UTF-8"})

    @ResponseBody
    public List<VolcanoPoint> getPoint(@PathVariable("cancerType") String cancerType,
                                       @PathVariable("dataType") String dataType)
    {
        try {
            iDataService = (IDataService) Consumer.singleton().getBean("IDataService");
            List<VolcanoPoint> point=iDataService.getVolcanoPoint(cancerType,dataType);
            return point;
        }
        catch (IllegalAccessError e) {
            List<VolcanoPoint> error=new ArrayList<VolcanoPoint>();
            error.add(new VolcanoPoint());
            return error;
        }
    }

}
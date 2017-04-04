package org.nero.click.data.service.impl;

import org.nero.click.data.dao.*;
import org.nero.click.data.dto.Operate;
import org.nero.click.data.dto.Point;
import org.nero.click.data.dto.deflection.DPoint;
import org.nero.click.data.dto.linear.LinearCalPoint;
import org.nero.click.data.dto.linear.LinearPoint;
import org.nero.click.data.dto.manhattan.MTPoint;
import org.nero.click.data.dto.manhattan.ManhattanPoint;
import org.nero.click.data.dto.moutain.Arm;
import org.nero.click.data.dto.moutain.Cyto;
import org.nero.click.data.dto.moutain.MPoint;
import org.nero.click.data.dto.moutain.Moutain;
import org.nero.click.data.entity.DGene;
import org.nero.click.data.entity.Gene;
import org.nero.click.data.entity.PGene;
import org.nero.click.data.entity.SimpleGene;
import org.nero.click.data.service.IDataService;
import org.nero.click.data.utils.TTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-6
 * time: 下午5:53.
 */
@SuppressWarnings("ALL")
@Service
public class DataServiceImpl implements IDataService {

    @Autowired
    private BeesDao beesDao;

    @Autowired
    private GeneDao geneDao;

    @Autowired
    private MoutainDao moutainDao;


    @Autowired
    private ManhattanDao manhattanDao;

    @Autowired
    private DeflectionDao deflectionDao;

    @Autowired
    private LinearDao linearDao;

    public Operate<Boolean> checkGene(String dataType, String geneName){
        String[] genes = geneName.split(",");
        List<String> unCorrectGene  = new ArrayList<String>();
        for(String gene:genes){
            if(geneDao.findGene(dataType,gene)==null){
                unCorrectGene.add(gene);
            }
        }
        if(unCorrectGene.size()!=0){
            return new Operate<Boolean>(true,unCorrectGene.toString(),false);
        }
        return new Operate<Boolean>(true,true);
    }

    /**
     * 尚未完成
     * 暂时搁置
     * 数据类型判断
     *
     * @return
     */
    public Operate<List<String>> getCancers(String dataType){
        List<String> cancer = beesDao.getTables();
        if(cancer !=null){
            Set<String> cancerNames = new HashSet<String>();
            for(String cancerTable:cancer){
                String[] cancerName = cancerTable.split("_");//截取癌症名称数组
                if(cancerName[1].equals(dataType)) {                //判断数据类型
                    cancerNames.add(cancerName[0]);
                }
            }

            String[] cancer_ = (String[])cancerNames.toArray();
            List<String> result_cancer  = new ArrayList<String>();

            for(String cancerName_:cancer_){
                result_cancer.add(cancerName_);
            }
            return new Operate<List<String>>(true,result_cancer);
        }
        return new Operate<List<String>>(false,null);
    }


    public Operate<Boolean> checkCancer(String dataType, String cancerName){
        String[] cancers = cancerName.split(",");
        List<String> unCorrectGene  = new ArrayList<String>();
        Operate<List<String>> result_cancers = getCancers(dataType);
        for(String tmp:cancers){
            unCorrectGene.add(tmp);
        }
        if(result_cancers!=null){
            for(String be_check_cancer:cancers){
                for(String src_check_cancer:result_cancers.getData()){
                    if(be_check_cancer.equals(src_check_cancer)){
                        if(unCorrectGene.contains(be_check_cancer)){
                            unCorrectGene.remove(be_check_cancer);
                        }
                        continue;
                    }
                }
            }

            if(unCorrectGene.size()!=0){
                return new Operate<Boolean>(true,unCorrectGene.toString(),false);
            }
            return new Operate<Boolean>(true,true);
        }
        return new Operate<Boolean>(true, false);
    }


    public List<Point> beeswarm(List<String> geneName, String CancerType,String normal,String dataType,String value,String index,String page) {


        List<Point> points = beesDao.getData(beesDao.getGenesId(geneName,dataType),
                CancerType,
                normal,
                dataType,
                value,
                index,
                page);

        return points;
    }

    public List<Gene> getMoutainData(String chromosomes, String dataType) {

        return moutainDao.getMoutainData(chromosomes,dataType);
    }


    public Double getChromosomeValue(List<Double> samples, String valueType/*mid or mean*/) {

        Double value = 0.0;

        if("mid".equals(valueType)){//取中位数
            samples.sort(new Comparator<Double>() {
                public int compare(Double o1, Double o2) {
                    if(o1>o2){
                        return 1;
                    }
                    return -1;
                }
            });
            if(samples.size()%2==0){
                value = samples.get(samples.size()/2);
            }else{
                value = (samples.get(samples.size()/2)+samples.get(samples.size()/2+1))/2;
            }

        }else if("mean".equals(valueType)){//取均值
            Double sum = 0.0;
            for(Double point:samples){
                sum+=point;
            }
            value = sum/samples.size();
        }

        return value;
    }

    public List<List<MPoint>> getMantainPoint(String chromosomes, String dataType, String cancerType,String value, String showValue) {

        List<List<MPoint>> result = new ArrayList<List<MPoint>>();

        List<MPoint> tPoints = new ArrayList<MPoint>();
        List<MPoint> nPoints = new ArrayList<MPoint>();


        List<Gene> genes = getMoutainData(chromosomes,dataType);

        List<Long> geneid = new ArrayList<Long>();
        for(Gene gene:genes){
            geneid.add(gene.getID());
        }
        //System.out.println(geneid.size());

        List<Double> nData = moutainDao.getMoutain(geneid,dataType,"n",value,showValue,cancerType);
        List<Double> tData = moutainDao.getMoutain(geneid,dataType,"t",value,showValue,cancerType);

        //System.out.println(nData.size()+"----"+tData.size());

        int i = 0;
        for(Gene gene:genes){

            //List<Double> tmpNPoint = moutainDao.getSample(String.valueOf(gene.getID()),cancerType,"n",dataType,value,"0","1");//临时样本

            nPoints.add(new MPoint(gene.getGeneName(),gene.getUcStart(),nData.get(i)));

            //List<Double> tmpTPoint = moutainDao.getSample(String.valueOf(gene.getID()),cancerType,"t",dataType,value,"0","1");//临时样本

            tPoints.add(new MPoint(gene.getGeneName(),gene.getUcStart(),tData.get(i)));
            i++;
        }
        result.add(nPoints);
        result.add(tPoints);

        //System.out.println(i);

       return result;

    }

    public List<Cyto> getCyto(List<Gene> samples) {

        Map<Long,String> cytoMap = new HashMap<Long, String>();
        List<Cyto> cytoList = new ArrayList<Cyto>();

        for(Gene gene:samples){
            if(!cytoMap.containsValue(gene.getUcCyto())){
                cytoMap.put(gene.getUcStart(),gene.getUcCyto());
                cytoList.add(new Cyto(gene.getUcStart(),gene.getUcCyto()));
            }
        }

        return cytoList;
    }

    public Arm getArm(List<Gene> samples) {

        boolean isFoundArm = false;

        for(Gene gene:samples){
            if(!isFoundArm) {
                if ("q".equals(gene.getUnArm())) {
                    isFoundArm = true;
                    return new Arm(gene.getUcStart());
                }
            }
        }
        return null;
    }

    public Moutain moutain(String cancerType,String chromosomes, String dataType, String value, String showValue) {
        List<Gene> samples = getMoutainData(chromosomes,dataType);
        return new Moutain(getMantainPoint(chromosomes,dataType,cancerType,value,showValue),getCyto(samples),getArm(samples));
    }

    public List<String> getMGeneId(List<SimpleGene> simpleGenes) {
        List<String> geneid = new ArrayList<String>();
        for(SimpleGene ss:simpleGenes){
            geneid.add(String.valueOf(ss.getID()));
        }
        return geneid;
    }
    /**
     * 曼哈顿数据出来啦
     * @param cancerType
     * @return
     */
    public List<List<Point>> getManhattan(String cancerType,String dataType){
        List<List<ManhattanPoint>> manhattanData =  new ArrayList<List<ManhattanPoint>>();


        for(int i = 0;i<22;i++){ //22对染色体

            List<String> geneid = new ArrayList<String>();
            Map<String,String> geneMap = new HashMap<String, String>();
            List<SimpleGene> ss = manhattanDao.getManhattanData(String.valueOf(i),dataType);
            for(SimpleGene simpleGene :ss ){
                geneid.add(String.valueOf(simpleGene.getID()));
                geneMap.put(String.valueOf(simpleGene.getID()),simpleGene.getucStart());
            }

            List<ManhattanPoint> genes = manhattanDao.getSampleAll(cancerType,dataType,
                    geneid,
                    "t","l");
            for(ManhattanPoint mp:genes){
                mp.setX(Double.valueOf(geneMap.get(String.valueOf(mp.getGeneId()))));
            }

            manhattanData.add(genes);
        }


        List<List<Point>> all = new ArrayList<List<Point>>();
        for(List<ManhattanPoint> mp:manhattanData){
            List<Point> mmmp = new ArrayList<Point>();
            for(ManhattanPoint mppp:mp){
                mmmp.add(new Point(mppp.getX(),mppp.getY(),mppp.getSampleID()));
            }
            all.add(mmmp);
        }
        return all;
    }
    public List<List<MTPoint>> getTanhattan(String cancerType1,String cancerType2,String normal1,String normal2,String dataType,String isLog){
        List<List<MTPoint>> result =  new ArrayList<List<MTPoint>>();
        for(int i = 1;i<22;i++) {
            List<String> geneid = new ArrayList<String>();
            Map<String,String> geneMap = new HashMap<String, String>();
            List<SimpleGene> ss = manhattanDao.getManhattanData(String.valueOf(i), dataType);
            for (SimpleGene simpleGene : ss) {
                geneid.add(String.valueOf(simpleGene.getID()));
                geneMap.put(String.valueOf(simpleGene.getID()),simpleGene.getucStart());
            }

            List<ManhattanPoint> genes1 = manhattanDao.getSampleAll(cancerType1,
                    dataType,
                    geneid,
                    normal1,isLog);
            List<ManhattanPoint> genes2 = manhattanDao.getSampleAll(cancerType2,
                    dataType,
                    geneid,
                    normal2,isLog);

            Map<String, List<Double>> mapa = new HashMap<String, List<Double>>();
            Map<String, List<Double>> mapb = new HashMap<String, List<Double>>();

            for (ManhattanPoint a : genes1) {
                if (mapa.get(String.valueOf(a.getGeneId())) == null) {
                    List<Double> doubles = new ArrayList<Double>();
                    doubles.add(a.getY());
                    mapa.put(String.valueOf(a.getGeneId()), doubles);
                } else {
                    mapa.get(String.valueOf(a.getGeneId())).add(a.getY());
                }
            }
            for (ManhattanPoint b : genes2) {
                if (mapb.get(String.valueOf(b.getGeneId())) == null) {
                    List<Double> doubles = new ArrayList<Double>();
                    doubles.add(b.getY());
                    mapb.put(String.valueOf(b.getGeneId()), doubles);
                } else {
                    mapb.get(String.valueOf(b.getGeneId())).add(b.getY());
                }
            }

            List<MTPoint> ttttttt = new ArrayList<MTPoint>();
            for (String gen : geneid) {
                ttttttt.add(new MTPoint(geneMap.get(gen),TTest.test(mapa.get(gen), mapb.get(gen)),gen));
            }
            result.add(ttttttt);
        }
        return result;
    }

    public List<List<PGene>> getPanhattan(String cancerType,String dataType){
        List<List<PGene>> result =  new ArrayList<List<PGene>>();
        for(int i = 1;i<22;i++) {
            List<PGene> pGenes= manhattanDao.getPanhattanData(String.valueOf(i),dataType,cancerType);
            result.add(pGenes);
        }
        return result;
    }


    /**
     * Linear regression
     * Created by Whishou
     * Email: whishoutan@gmail.com
     * date: 2017/2/24
     */


    public List<LinearPoint> getLinearPoint(String cancerType, String geneName, String dataType, String sampleType, String isLog){
        String geneId= linearDao.getLinearId(geneName);
        return linearDao.getLinearPoint(cancerType,geneId,dataType, sampleType,isLog);
    }

    public List<LinearPoint> getLinearPoint2(String cancerType, String geneName, String dataType2, String sampleType, String isLog){
        String geneId= linearDao.getLinearId(geneName);
        return linearDao.getLinearPoint2(cancerType, geneId, dataType2,sampleType,isLog);
    }

    public List<LinearCalPoint> calculate(String cancerType, String geneName, String dataType, String dataType2, String sampleType, String isLog){
        List<LinearCalPoint> all= new ArrayList<LinearCalPoint>();
        List<LinearPoint> e= getLinearPoint(cancerType,geneName,dataType,sampleType,isLog);
        List<LinearPoint> c= getLinearPoint2(cancerType,geneName,dataType2,sampleType,isLog);
        for (LinearPoint a:e) {
            for (LinearPoint b : c) {
                if (a.getSampleID().equals(b.getSampleID())) {
                    all.add(new LinearCalPoint(a.getY(),b.getY(),a.getSampleID()));
                }
            }
        }
        return all;

    }

    /**
     * deflection 单癌症双样本校验
     *
     * @param cancerType
     * @param dataType
     * @return
     */
    public List<List<PGene>> getDeflection(String cancerType,String dataType){

        List<List<PGene>> result = new ArrayList<List<PGene>>();
        for(int i = 1;i<22;i++) {

            List<DGene> pGenes = deflectionDao.getDel(String.valueOf(i), cancerType, dataType);
            List<PGene> result_l = new ArrayList<PGene>();
            for(DGene d:pGenes){
                if(d.getMen()>d.getMet()){
                    d.setPvalue(String.valueOf(-Double.valueOf(d.getPvalue())));
                }
                result_l.add(new PGene(d.getId(),d.getUcStart(),d.getPvalue()));
            }
            result.add(result_l);
        }

        return result;
    }
}

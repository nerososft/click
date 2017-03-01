package org.nero.click.data.service.impl;

import org.apache.ibatis.annotations.Param;
import org.nero.click.data.dao.GeneDao;
import org.nero.click.data.dao.ManhattanDao;
import org.nero.click.data.dto.Operate;
import org.nero.click.data.dto.Point;
import org.nero.click.data.dao.BeesDao;
import org.nero.click.data.dao.MoutainDao;
import org.nero.click.data.dto.moutain.Arm;
import org.nero.click.data.dto.moutain.Cyto;
import org.nero.click.data.dto.moutain.MPoint;
import org.nero.click.data.dto.moutain.Moutain;
import org.nero.click.data.entity.Gene;
import org.nero.click.data.service.IDataService;
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


    /**
     * 曼哈顿数据出来啦
     * @param cancerType
     * @return
     */
    public List<List<Point>> getManhattan(String cancerType,String dataType){
        List<List<Point>> manhattanData =  new ArrayList<List<Point>>();

        for(int i = 0;i<22;i++){ //22对染色体
            manhattanData.add(manhattanDao.getSampleAll(cancerType,dataType,manhattanDao.getManhattanData(String.valueOf(i),dataType),"t"));
        }
        return manhattanData;
    }
}

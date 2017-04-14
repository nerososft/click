package org.nero.click.data.service;

import org.apache.ibatis.annotations.Param;
import org.nero.click.data.dto.Operate;
import org.nero.click.data.dto.Point;
import org.nero.click.data.dto.linear.LinearPoint;
import org.nero.click.data.dto.manhattan.MTPoint;
import org.nero.click.data.dto.manhattan.ManhattanPoint;
import org.nero.click.data.dto.moutain.Arm;
import org.nero.click.data.dto.moutain.Cyto;
import org.nero.click.data.dto.moutain.MPoint;
import org.nero.click.data.dto.moutain.Moutain;
import org.nero.click.data.entity.Gene;
import org.nero.click.data.entity.PGene;
import org.nero.click.data.entity.SimpleGene;
import org.nero.click.data.entity.VolcanoData;

import java.util.List;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-6
 * time: 下午5:53.
 */
public interface IDataService {
    /**
     * 查询基因是否存在
     * 可动态检验用户输入基因是否合法
     *
     * @param dataType
     * @param geneName
     * @return 是否存在
     */
    Operate<Boolean> checkGene(String dataType, String geneName);

    /**
     * 检查癌症名称
     * @param dataType
     * @param cancerName
     * @return
     */
    Operate<Boolean> checkCancer(String dataType, String cancerName);

    /**
     * 获取所有癌症
     * @return
     */
    Operate<List<String>> getCancers(String dataType);

    /**
     * 根据基因名数组和癌症查询样本数据
     * @param geneName
     * @param CancerType
     * @param normal
     * @param dataType
     * @param value
     * @return
     */
    List<Point> beeswarm(List<String> geneName, String CancerType,String normal,String dataType,String value,String index,String page);


    /*=================================================================================================================*/
    /**
     * 山形图，根据染色体查询
     *  @Param chromes 染色体
     *  @Param 数据类型，c or e or m
     */
    List<Gene> getMoutainData(String chromosomes, String dataType);


    /**
     * 获取染色体基因对应数值 mid／mean
     * @param samples
     * @param valueType
     * @return
     */
    Double getChromosomeValue(List<Double> samples,String valueType);


    /**
     * CancerType, Chromosome , mean or median values, log
     * @param chromosomes
     * @param dataType
     * @param value
     * @param showValue
     * @return
     */
    List<List<MPoint>> getMantainPoint(String chromosomes, String dataType,String cancerType,String value,String showValue);


    /**
     * 获取cyto
     * @param samples
     * @return
     */
    List<Cyto> getCyto(List<Gene> samples);

    /**
     * 获取大臂小臂间隔
     * @param samples
     * @return
     */
    Arm getArm(List<Gene> samples);


    /**
     * 山形图数据整合
     * @param chromosomes
     * @param dataType
     * @param value
     * @param showValue
     * @return
     */
    Moutain moutain(String cancerType,String chromosomes, String dataType,String value,String showValue);


    List<String> getMGeneId(List<SimpleGene> simpleGenes);

    /**
     * 曼哈顿数据出来啦
     * @param cancerType
     * @return
     */
    List<List<Point>> getManhattan(String cancerType, String dataType);

    /**
     * 获取曼哈顿，新的T检验得出的结果
     * @param cancerType1
     * @param cancerType2
     * @param normal1
     * @param normal2
     * @param dataType
     * @param isLog
     * @return
     */
    List<List<MTPoint>> getTanhattan(String cancerType1, String cancerType2, String normal1, String normal2, String dataType, String isLog);

    /**
     * 获取曼哈顿通过pvalue
     * author ： Neroyang
     * email ：nerosoft@outlook.com
     * date 2017-3-26 下午
     * @param dataType
     * @return
     */
    List<List<PGene>> getPanhattan(String cancerType,String dataType);

    /**
     * Linear regression点数据
     * Created by Whishou
     * Email: whishoutan@gmail.com
     * date: 2017/2/24
     */

    List<LinearPoint> getLinearPoint(String cancerType, String geneId, String dataType, String sampleType, String isLog);

    List<LinearPoint> getLinearPoint2(String cancerType, String geneId,String dataType2, String sampleType, String isLog);


    /**
     * deflection
     * author:neroYang
     * email:nerosoft@outlook.com
     * date: 2017/4/2
     * @param cancerType
     * @param dataType
     * @return
     */
    List<List<PGene>> getDeflection(String cancerType,String dataType);


    /**
     * Volcano plot
     * Created by Whishou
     * Email:whishoutan@gmail.com
     * date: 2017/4/9
     * @param cancerType
     * @param dataType
     * @return
     */

    List<VolcanoData> getVolcanoData(String cancerType, String dataType);

    /**
     * Mattest
     * Created by Whishou
     * Email: whishoutan@gmail.com
     * date: 2017/4/14
     */

    Object mattest(List<Float> x,List<Float> y);
}

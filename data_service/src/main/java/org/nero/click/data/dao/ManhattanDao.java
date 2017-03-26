package org.nero.click.data.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.click.data.dto.Point;
import org.nero.click.data.dto.manhattan.ManhattanPoint;
import org.nero.click.data.entity.Gene;
import org.nero.click.data.entity.PGene;
import org.nero.click.data.entity.SimpleGene;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/2/26
 * Time   下午9:24
 */
public interface ManhattanDao {


    /**
     * 获取相应染色体基因数据
     * @param chromosome
     * @param dataType
     * @return
     */
    List<SimpleGene> getManhattanData(@Param("chromosome") String chromosome,
                                      @Param("dataType") String dataType);

    /**
     * 获取曼哈顿所有样本
     * @param cancerType
     * @param dataType
     * @param geneId
     * @return
     */
    List<ManhattanPoint> getSampleAll(@Param("cancerType") String cancerType,
                                      @Param("dataType") String dataType,
                                      @Param("geneId") List<String> geneId,
                                      @Param("normal") String normal,
                                      @Param("islog") String islog);

    /**
     * 直接获取曼哈顿含pvalue数据
     * author : NeroYang
     * email  : nerosoft@outlook.com
     * date   : 2017-3-26 下午
     * @param chromosome
     * @param dataType
     * @return
     */
    List<PGene> getPanhattanData(@Param("chromosome") String chromosome,
                                 @Param("dataType") String dataType,
                                 @Param("cancerType") String cancerType);



}

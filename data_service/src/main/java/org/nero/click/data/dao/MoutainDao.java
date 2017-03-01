package org.nero.click.data.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.click.data.entity.Gene;

import java.util.List;

/**
 * Author nero
 * Date   2016/10/20 0020
 * Time   23:05
 * Email  nerosoft@outlook.com
 */
public interface MoutainDao {

    /**
     * 获取相应染色体基因数据
     * @param chromosome
     * @param dataType
     * @return
     */
    List<Gene> getMoutainData(@Param("chromosome") String chromosome,
                              @Param("dataType") String dataType);


    /**
     * 获取对应样本数据
     * @param cancerType
     * @param normal
     * @param dataType
     * @param value
     * @param index
     * @param page
     * @return
     */
    List<Double> getSample(@Param("geneId") String geneId,
                           @Param("cancerType") String cancerType,
                           @Param("normal") String normal,
                           @Param("dataType") String dataType,
                           @Param("value") String value,
                           @Param("index") String index,
                           @Param("page") String page);


    List<Double> getMoutain(@Param("geneId") List<Long> geneId,
                      @Param("dataType") String dataType,
                      @Param("normal") String normal,
                      @Param("isLog") String isLog,
                      @Param("which") String which,
                      @Param("cancerType") String cancerType);

}

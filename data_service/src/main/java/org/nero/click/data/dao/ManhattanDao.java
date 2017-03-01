package org.nero.click.data.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.click.data.dto.Point;
import org.nero.click.data.entity.Gene;

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
    List<String> getManhattanData(@Param("chromosome") String chromosome,
                              @Param("dataType") String dataType);

    /**
     * 获取曼哈顿所有样本
     * @param cancerType
     * @param dataType
     * @param geneId
     * @return
     */
    List<Point> getSampleAll(@Param("cancerType") String cancerType,
                             @Param("dataType") String dataType,
                             @Param("geneId") List<String> geneId,
                             @Param("normal") String normal);



}

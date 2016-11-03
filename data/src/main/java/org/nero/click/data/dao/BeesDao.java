package org.nero.click.admin.dao;

/**
 * Author nero
 * Date   2016/10/16 0016
 * Time   19:31
 * Email  nerosoft@outlook.com
 */

import org.apache.ibatis.annotations.Param;
import org.nero.click.admin.dto.Box;
import org.nero.click.admin.dto.Point;

import java.util.List;

/**
 * 基本基因竖
 */
public interface BeesDao {

    /**
     * 根据基因名称获取基因id
     * @param genename
     * @return
     */
    List<Integer> getGeneId(List<String> genename);


    /**
     * 根据基因id和表名获取样本id
     * @param geneid
     * @return
     */
    List<Integer> getPropertyId(@Param("list") List<Integer> geneid,
                                @Param("fuckcid") String cid);

    /**
     * 根据样本id在相应的数据表table查询
     * @param propid
     * @param table
     * @return
     */
    List<Point> getBeesPoints(@Param("list") List<Integer> propid,
                              @Param("table") String table);


    /**
     * 获取箱型图数据
     * @param cancerType
     * @param genename
     * @return
     */
    List<Box> getBox(@Param("cancertype") List<String> cancerType,
                     @Param("genename") List<String> genename);

}

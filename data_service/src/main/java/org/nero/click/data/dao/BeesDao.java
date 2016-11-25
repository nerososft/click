package org.nero.click.data.dao;

/**
 * Author nero
 * Date   2016/10/16 0016
 * Time   19:31
 * Email  nerosoft@outlook.com
 */

import org.apache.ibatis.annotations.Param;
import org.nero.click.data.dto.Point;
import org.nero.click.data.dto.Box;

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


    //以下是新的数据库查找设计
    List<Integer> getGenesId(@Param("list") List<String> geneName,
                             @Param("dataType") String dataType);

    List<String> getTables();

    List<String> getColumns(@Param("cancerType") String cancerType,
                            @Param("normal") String normal,
                            @Param("dataType") String dataType,
                            @Param("value") String value,
                            @Param("index") String index,
                            @Param("page") String page);

    List<Point> getData(@Param("list") List<Integer> genesid,
                          @Param("cancerType") String cancerType,
                          @Param("normal") String normal,
                          @Param("dataType") String dataType,
                          @Param("value") String value,
                          @Param("index") String index,
                          @Param("page") String page);

}

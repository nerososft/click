package org.nero.click.data.dao;

/**
 * Author nero
 * Date   2016/10/16 0016
 * Time   19:31
 * Email  nerosoft@outlook.com
 */

import org.apache.ibatis.annotations.Param;
import org.nero.click.data.dto.Point;

import java.util.List;

/**
 * 基本基因竖
 */
public interface BeesDao {

    //以下是新的数据库查找设计
    //获取基因id
    List<Integer> getGenesId(@Param("list") List<String> geneName,
                             @Param("dataType") String dataType);

    //查找所有表
    List<String> getTables();

    //查找所有字段
    List<String> getColumns(@Param("cancerType") String cancerType,
                            @Param("normal") String normal,
                            @Param("dataType") String dataType,
                            @Param("value") String value,
                            @Param("index") String index,
                            @Param("page") String page);

    //查找point
    List<Point> getData(@Param("list") List<Integer> genesid,
                          @Param("cancerType") String cancerType,
                          @Param("normal") String normal,
                          @Param("dataType") String dataType,
                          @Param("value") String value,
                          @Param("index") String index,
                          @Param("page") String page);

}

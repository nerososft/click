package org.nero.click.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.click.admin.dto.Point;

import java.util.List;

/**
 * Author nero
 * Date   2016/10/21 0021
 * Time   18:49
 * Email  nerosoft@outlook.com
 */
public interface ManhattanDao {


    /**
     * 根据染色体获取基因id
     * @param ucChrom
     * @return
     */
    List<Integer> getGeneId(List<Integer> ucChrom);

    /**
     * 根据基因获取propertyId
     * @param gengId
     * @return
     */
    List<Integer> getPropertyId(List<Integer> gengId);


    /**
     * 获取麦哈顿图数据
     * @param ptopertyId
     * @param cancerTable
     * @return
     */
    List<Point> manhattan(@Param("list") List<Integer> ptopertyId,
                          @Param("table") String cancerTable);


}

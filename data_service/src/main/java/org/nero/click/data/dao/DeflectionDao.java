package org.nero.click.data.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.click.data.dto.Point;
import org.nero.click.data.dto.deflection.DPoint;
import org.nero.click.data.entity.DGene;
import org.nero.click.data.entity.PGene;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/4
 * Time   下午9:17
 */
public interface DeflectionDao {

    List<DGene> getDel(@Param("chroosome") String chroosome,
                       @Param("cancerType") String cancerType,
                       @Param("dataType") String dataType);

}

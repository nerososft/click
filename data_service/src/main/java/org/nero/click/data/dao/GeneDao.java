package org.nero.click.data.dao;

import org.apache.ibatis.annotations.Param;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-6
 * time: 下午4:55.
 */
public interface GeneDao {

    String findGene(@Param("dataType") String dataType,
                    @Param("geneName") String geneName);
}

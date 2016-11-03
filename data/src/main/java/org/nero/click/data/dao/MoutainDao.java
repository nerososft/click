package org.nero.click.data.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.click.data.dto.MoutainPoint;
import java.util.List;

/**
 * Author nero
 * Date   2016/10/20 0020
 * Time   23:05
 * Email  nerosoft@outlook.com
 */
public interface MoutainDao {
    /**
     * 查询moutain图数据
     * @param chromosomes
     * @param type
     * @return
     */
    List<MoutainPoint> moutain(@Param("chromosomes") String chromosomes,
                               @Param("type") String type);
}

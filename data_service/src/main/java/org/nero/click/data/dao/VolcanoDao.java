package org.nero.click.data.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.click.data.entity.VolcanoData;

import java.util.List;

/**
 * Created by Whishou on 2017/4/9.
 * Email: whishoutan@gmail.com
 */
public interface VolcanoDao {
    //获取Volcano数据
    List<VolcanoData> getVolcanoData(@Param("cancerType") String cancerType,
                                     @Param("dataType") String dataType);
}
package org.nero.click.data.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.click.data.dto.linear.LinearPoint;

import java.util.List;

/**
 * Created by Whishou on 2017/4/4.
 * Email: whishoutan@gmail.com
 */
public interface LinearDao {
    //获取gene id
    String getLinearId(@Param("geneName") String geneName);

    //获取Linear图x轴数据
    List<LinearPoint> getLinearPoint(@Param("cancerType") String cancerType,
                                     @Param("geneId") String geneId,
                                     @Param("dataType") String dataType,
                                     @Param("sampleType") String sampleType,
                                     @Param("isLog") String isLog
    );
    //获取Linear图y轴点数据
    List<LinearPoint> getLinearPoint2(@Param("cancerType") String cancerType,
                                      @Param("geneId") String geneId,
                                      @Param("dataType2") String dataType2,
                                      @Param("sampleType") String sampleType,
                                      @Param("isLog") String isLog
    );


}
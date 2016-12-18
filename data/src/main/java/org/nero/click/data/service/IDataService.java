package org.nero.click.data.service;


import org.nero.click.data.dto.MoutainPoint;
import org.nero.click.data.dto.Point;

import java.util.List;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-6
 * time: 下午5:53.
 */
public interface IDataService {
    /**
     *
     * @param geneName
     * @param CancerType
     * @param normal
     * @param dataType
     * @param value
     * @param index
     * @param page
     * @return
     */
    List<Point> beeswarm(List<String> geneName, String CancerType,String normal,String dataType,String value,String index,String page);

    /**
     * 山形图，根据染色体查询
     *  @Param chromes 染色体
     *  @Param 数据类型，平均是or中位数
     */
    List<MoutainPoint> moutain(String chromosomes, String type);

}

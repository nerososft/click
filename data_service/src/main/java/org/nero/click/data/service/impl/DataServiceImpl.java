package org.nero.click.data.service.impl;

import org.nero.click.data.dto.Point;
import org.nero.click.data.dao.BeesDao;
import org.nero.click.data.dao.MoutainDao;
import org.nero.click.data.dto.MoutainPoint;
import org.nero.click.data.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-6
 * time: 下午5:53.
 */
@Service
public class DataServiceImpl implements IDataService {

    @Autowired
    private BeesDao beesDao;

    @Autowired
    private MoutainDao moutainDao;




    public List<Point> beeswarm(List<String> genename, String CancerType) {

        String cid  = CancerType.substring(4)+"ID";
        if(beesDao==null){
            System.out.println("dao null");
        }

        List<Point> points = beesDao.getBeesPoints(beesDao.getPropertyId(beesDao.getGeneId(genename),cid),CancerType);

        return points;
    }

    public List<MoutainPoint> moutain(String chromosomes, String type) {

        return moutainDao.moutain(chromosomes,type);
    }
}

package org.nero.click.service.impl;

import org.nero.click.cache.impl.CacheServiceImpl;
import org.nero.click.dao.BeesDao;
import org.nero.click.dao.MoutainDao;
import org.nero.click.dto.MoutainPoint;
import org.nero.click.dto.Point;
import org.nero.click.service.IDataService;
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
public class DataServiceImpl extends CacheServiceImpl implements IDataService {

    @Autowired
    private BeesDao beesDao;

    @Autowired
    private MoutainDao moutainDao;




    public List<Point> beeswarm(List<String> genename, String CancerType) {
        //"prop"+cancertype+"n"
        //gbmtID
        String cid  = CancerType.substring(4)+"ID";

        System.out.println(cid+"||||||||||||||||||||||||");

        List<Point> points = beesDao.getBeesPoints(beesDao.getPropertyId(beesDao.getGeneId(genename),cid),CancerType);

        return points;
    }

    public List<MoutainPoint> moutain(String chromosomes, String type) {

        return moutainDao.moutain(chromosomes,type);
    }
}

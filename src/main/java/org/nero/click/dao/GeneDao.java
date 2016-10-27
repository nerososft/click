package org.nero.click.dao;

import org.nero.click.entity.Gene;

import java.util.List;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-6
 * time: 下午4:55.
 */
public interface GeneDao {

    List<Gene> selectAll();

    List<Gene> queryByGenes(List<String> genes,
                            String cancerType,
                            String biaoDaLiang,
                            String copyNum,
                            String jiaJiHua,
                            String isNormal,
                            String boxLineTu,
                            String isLog,
                            String isZ,
                            String isT);
}

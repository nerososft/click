package org.nero.click.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.click.admin.entity.Resource;

import java.util.List;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-15
 * Time   :  下午9:07
 */
public interface ResourceDao {

    /**
     * 根据哈希码查找资源
     * @param md5Code 哈希校验码
     * @return 资源
     */
    Resource findByMd5(@Param("hash") String md5Code);


    /**
     * 添加资源
     * @param fileName 资源名称
     * @param filePath 资源路劲
     * @param hashCode 哈希检验码
     * @param fileSize 资源大小
     * @param fileFormat 资源格式
     * @param uploaderId 上穿者ID
     * @return 0 or resourceId
     */
    int addResource(String fileName,String filePath,String hashCode,String fileSize,String fileFormat,long uploaderId);

    /**
     * 删除（屏蔽）资源通过资源ID
     * @param resourceId 资源id
     * @return 0 or resourceId
     */
    int deleteResourceById(long resourceId);

    /**
     * 删除（屏蔽）资源通过哈希校验码
     * @param md5Code 哈希校验码
     * @return 0 or resourceId
     */
    int deleteResourceByMd5(String md5Code);


    /**
     * 获取资源
     * @param resourceId 资源id
     * @return 资源 or null
     */
    Resource getResource(long resourceId);

    /**
     * 通过校验码获取资源
     * @param hashCode 校验码
     * @return 资源列表 or null
     */
    List<Resource> getResourceByHash(String hashCode);


    /**
     * 通过资源格式获取资源
     * @param type 资源格式
     * @return 资源列比 or null
     */
    List<Resource> getResourceByType(String type);

    /**
     * 获取所有资源
     * @return 资源列表 or null
     */
    List<Resource> getResource();

}

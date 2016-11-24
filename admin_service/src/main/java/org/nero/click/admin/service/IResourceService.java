package org.nero.click.admin.service;

import org.click.admin.entity.Resource;
import org.nero.click.sso.dto.Operate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-13
 * Time   :  下午5:30
 */
public interface IResourceService {


    /**
     * 储存资源
     * @param file
     * @param uploaderId
     * @param fileName
     * @return
     */
    Operate<Resource> addResource(MultipartFile file, long uploaderId, String fileName);


    /**
     * 获取资源
     * @param resourceId
     * @return
     */
    Operate<Resource> getResourceById(long resourceId);

    /**
     * 获取所有资源
     * @return
     */
    Operate<List<Resource>> getResource();


}

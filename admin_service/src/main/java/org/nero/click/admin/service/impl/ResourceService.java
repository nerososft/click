package org.nero.click.admin.service.impl;

import org.click.admin.entity.Resource;
import org.nero.click.admin.service.IResourceService;
import org.nero.click.common.utils.file.FileType;
import org.nero.click.sso.dto.Operate;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.click.admin.CONSTANT.CONSTANT.*;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-13
 * Time   :  下午5:49
 */
public class ResourceService implements IResourceService {

    public boolean isTypeAllow(String type){

        Map<String,Boolean> allowMap = new HashMap<String, Boolean>();

        allowMap.put("jpg",true);                               //允许jpg
        allowMap.put("png",true);                               //允许png

        if(allowMap.get(type)!=null && allowMap.get(type)){
            return true;
        }
        return false;
    }

    public Operate<Resource> addResource(MultipartFile file, long uploaderId, String fileName) {
        if(!file.isEmpty()){
            try {
                byte[] fileByte = file.getBytes();
                if(isTypeAllow(FileType.getFileType(fileByte))){
                    FileOutputStream fileOutputStream = null;
                    BufferedOutputStream bufferedOutputStream = null;
                    try {
                        String filePath = "";                   //读取commom.properties获得
                        fileOutputStream = new FileOutputStream(filePath+fileName);
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        bufferedOutputStream.write(fileByte);
                        bufferedOutputStream.flush();
                        return new Operate<Resource>(true, FILE_UPLOAD_SUCCESS.DESC,new Resource(
                                fileName,                       //文件名
                                filePath,                       //文件地址
                                null,                           //hashCodo
                                null,                           //文件大小
                                FileType.getFileType(fileByte), //文件真实格式
                                uploaderId,                     //上传者id
                                null,                           //上传时间
                                -1                              //资源id
                        ));
                    }catch (IOException e){
                        return new Operate<Resource>(false,FILE_ERROR.DESC,null);
                    }finally {
                        bufferedOutputStream.close();
                        fileOutputStream.close();
                    }
                }
                return new Operate<Resource>(false,FILE_FORMAT_UNSUPPORED.DESC,null);//格式不让上传
            } catch (IOException e) {
                return new Operate<Resource>(false,FILE_ERROR.DESC,null);
            }
        }
        return new Operate<Resource>(false,FILE_NULL.DESC,null);
    }

    public Operate<Resource> getResource(long resourceId) {
        return null;
    }
}

package org.nero.click.admin.service.impl;

import org.click.admin.entity.Resource;
import org.nero.click.admin.dao.ResourceDao;
import org.nero.click.admin.service.IResourceService;
import org.nero.click.common.utils.file.FileType;
import org.nero.click.common.utils.md5.FileDiffUtil;
import org.nero.click.common.utils.rendom.RandomString;
import org.nero.click.sso.dto.Operate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.click.admin.CONSTANT.CONSTANT.*;

/**
 * Author :  nero
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-13
 * Time   :  下午5:49
 */
public class ResourceServiceImpl implements IResourceService {


    @Autowired
    private ResourceDao resourceDao;



    public boolean isTypeAllow(String type){

        Map<String,Boolean> allowMap = new HashMap<String, Boolean>();

        allowMap.put("jpg",true);                               //允许jpg
        allowMap.put("png",true);                               //允许png

        if(allowMap.get(type)!=null && allowMap.get(type)){
            return true;
        }
        return false;
    }

    public Operate<Resource> addResource(MultipartFile file, long uploaderId, String realFileName) {
        if(!file.isEmpty()){
            try {
                byte[] fileByte = file.getBytes();

                String fileType = FileType.getFileType(fileByte);//文件真实格式
                if(isTypeAllow(fileType)){

                    String md5Code = FileDiffUtil.getMD5(fileByte);//获取文件MD5
                    Resource resource = resourceDao.findByMd5(md5Code);
                    String filePath = "";                   //读取commom.properties获得
                    String fileName;
                    String realResourcePath;                //文件系统资源地址

                    if(resource==null){

                        RandomString randomString = new RandomString();
                        String dbFilePath = randomString.getRandomString(64)+String.valueOf(System.currentTimeMillis());
                        fileName = FileDiffUtil.getMD5(dbFilePath.getBytes());//数据库资源名称

                        realResourcePath = filePath+File.separator+fileName;

                        FileOutputStream fileOutputStream = null;
                        BufferedOutputStream bufferedOutputStream = null;
                        try {
                            fileOutputStream = new FileOutputStream(realResourcePath);
                            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                            bufferedOutputStream.write(fileByte);
                            bufferedOutputStream.flush();
                        }catch (IOException e){
                            return new Operate<Resource>(false,FILE_ERROR.DESC,null);
                        }finally {
                            bufferedOutputStream.close();
                            fileOutputStream.close();
                        }
                    }else{//MD5校验码一致，不必磁盘储存，添加数据库记录即可。
                        realResourcePath =resource.getFilepath();
                        md5Code = resource.getHashCode();
                    }
                    //添加数据库记录
                    if(resourceDao.addResource(realFileName,realResourcePath,md5Code,null,fileType,uploaderId)<1){
                        return new Operate<Resource>(false, FILE_UPLOAD_FAILED.DESC,null);
                    }
                    return new Operate<Resource>(true, FILE_UPLOAD_SUCCESS.DESC,new Resource(
                            realFileName,                   //文件名
                            realResourcePath,               //文件地址
                            md5Code,                        //hashCodo
                            null,                           //文件大小
                            fileType,                       //文件真实格式
                            uploaderId,                     //上传者id
                            null,                           //上传时间
                            -1                              //资源id
                    ));
                }
                return new Operate<Resource>(false,FILE_FORMAT_UNSUPPORED.DESC,null);//格式不让上传
            } catch (IOException e) {
                return new Operate<Resource>(false,FILE_ERROR.DESC,null);
            }
        }
        return new Operate<Resource>(false,FILE_NULL.DESC,null);
    }


    public Operate<Resource> getResourceById(long resourceId) {
        return new Operate<Resource>(true,resourceDao.getResourceById(resourceId));
    }

    public Operate<List<Resource>> getResource() {
        return new Operate<List<Resource>>(true,resourceDao.getResource());
    }
}



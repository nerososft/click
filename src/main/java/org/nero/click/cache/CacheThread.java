package org.nero.click.cache;

import org.nero.click.cache.impl.CacheServiceImpl;

import java.io.File;

/**
 * Author nero
 * Date   2016/10/18 0018
 * Time   11:01
 * Email  nerosoft@outlook.com
 */
public class CacheThread extends Thread {

    private ICacheService cacheService;
    private String filePath;
    private String fileName;
    private String cache;


    public CacheThread(ICacheService cacheService, String filePath, String fileName, String cache) {
        this.cacheService = cacheService;
        this.filePath = filePath;
        this.fileName = fileName;
        this.cache = cache;
    }

    public ICacheService getCacheService() {
        return cacheService;
    }

    public void setCacheService(CacheServiceImpl cacheService) {
        this.cacheService = cacheService;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    //异步缓存
    public void run() {
        cacheService.diskCache(fileName,filePath,cache);
    }
}

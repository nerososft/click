package org.nero.click.data.cache.impl;

import org.nero.click.data.cache.ICacheService;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Author nero
 * Date   2016/10/17 0017
 * Time   12:31
 * Email  nerosoft@outlook.com
 */
@Service
public abstract class CacheServiceImpl implements ICacheService {


    public boolean isDiskCached(String cacheName, String cachePath) {
        File cacheFile = new File(cachePath+cacheName);
        return cacheFile.isFile();
    }

    public void diskCache(String cacheName, String cachePath, String cache) {
        if(!isDiskCached(cacheName,cachePath)){
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(cachePath+cacheName,true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(cache);
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

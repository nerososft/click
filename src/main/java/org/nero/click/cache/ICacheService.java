package org.nero.click.cache;

/**
 * Author nero
 * Date   2016/10/17 0017
 * Time   12:31
 * Email  nerosoft@outlook.com
 */
public interface ICacheService {


    boolean isDiskCached(String cacheName,String cachePath);

    void diskCache(String cacheName,String cachePath,String cache);


}

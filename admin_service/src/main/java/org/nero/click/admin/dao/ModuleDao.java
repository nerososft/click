package org.nero.click.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.click.admin.entity.Module;

import java.util.List;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-14
 * Time   :  下午9:59
 */
public interface ModuleDao {


    /**
     * 添加模块数据
     * @param moduleName
     * @param moduleDesc
     * @param moduleUrl
     * @param moduleImgUrl
     * @return
     */
    int addModule(@Param("name") String moduleName,
                  @Param("desc") String moduleDesc,
                  @Param("url")  String moduleUrl,
                  @Param("img")  String moduleImgUrl);

    /**
     * 删除模块数据
     * @param id
     * @return
     */
    int delModule(@Param("id") long id);

    /**
     * 修改模块数据
     * @param id
     * @param moduleName
     * @param moduleDesc
     * @param moduleUrl
     * @param moduleImgUrl
     * @return
     */
    int updateModule(@Param("id")   long id,
                     @Param("name") String moduleName,
                     @Param("desc") String moduleDesc,
                     @Param("url")  String moduleUrl,
                     @Param("img")  String moduleImgUrl);

    /**
     * 获取模块数据
     * @return
     */
    List<Module> getModules();
}

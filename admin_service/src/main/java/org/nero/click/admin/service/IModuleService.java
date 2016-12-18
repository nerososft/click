package org.nero.click.admin.service;

import org.click.admin.entity.Module;
import org.nero.click.sso.dto.Operate;

import java.util.List;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-14
 * Time   :  下午8:51
 */
public interface IModuleService {


    /**
     * 添加模块
     * @param module
     * @return
     */
    Operate<Module> addModule(Module module);

    /**
     * 更新模块
     * @param neeModule
     * @param moduleId
     * @return
     */
    Operate<Module> updateModule(Module neeModule,long moduleId);

    /**
     * 删除模块
     * @param moduleId
     * @return
     */
    Operate<Module> delModule(long moduleId);

    /**
     * 获取模块列表
     * @return
     */
    Operate<List<Module>> getModules();

}

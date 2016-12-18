package org.nero.click.admin.service.impl;

import org.click.admin.entity.Module;
import org.nero.click.admin.dao.ModuleDao;
import org.nero.click.admin.service.IModuleService;
import org.nero.click.sso.dto.Operate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static org.click.admin.CONSTANT.CONSTANT.MODULE_ADD_ERROE;
import static org.click.admin.CONSTANT.CONSTANT.MODULE_DELETE_ERROR;
import static org.click.admin.CONSTANT.CONSTANT.MODULE_UPDATE_ERROR;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-14
 * Time   :  下午8:54
 */
@Service
public class ModuleServiceImpl implements IModuleService {

    @Autowired
    private ModuleDao moduleDao;

    public Operate<Module> addModule(Module module) {

        if(moduleDao.addModule(module.getModuleName(),
                module.getModuleDesc(),
                module.getModuleUrl(),
                module.getModuleImgUrl())<1){
            return new Operate<Module>(false,MODULE_ADD_ERROE.DESC,null);
        }

        return new Operate<Module>(true,module);
    }

    public Operate<Module> updateModule(Module newModule, long moduleId) {

        if(moduleDao.updateModule(moduleId,
                newModule.getModuleName(),
                newModule.getModuleDesc(),
                newModule.getModuleUrl(),
                newModule.getModuleImgUrl())<1){
            return new Operate<Module>(false,MODULE_UPDATE_ERROR.DESC,null);
        }
        return new Operate<Module>(true,newModule);
    }

    public Operate<Module> delModule(long moduleId) {
        if(moduleDao.delModule(moduleId)<1){
            return new Operate<Module>(false,MODULE_DELETE_ERROR.DESC,null);
        }
        return new Operate<Module>(true,null);
    }

    public Operate<List<Module>> getModules() {

        return new Operate<List<Module>>(true,moduleDao.getModules());
    }
}

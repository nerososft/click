package org.nero.click.admin.web.controller;

import org.nero.click.admin.Consumer;
import org.nero.click.admin.service.IResourceService;
import org.nero.click.sso.dto.Operate;
import org.nero.click.sso.service.IAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

import static org.click.admin.CONSTANT.CONSTANT.*;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-13
 * Time   :  下午5:51
 */
@Controller
@RestController
@RequestMapping("/resource")
public class Resource {

    private IAuthService iAuthService;
    private IResourceService iResourceService;

    @RequestMapping(value = "/{id}/{token}/auth/{filename}/upload",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    @ResponseBody

    public Operate<org.click.admin.entity.Resource> upload(@PathVariable("id") long uid,
                                                           @PathVariable("token") String token,
                                                           @PathVariable("filename") String fileName,
                                                           @RequestParam("file") MultipartFile file){

        try{
            iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (!iAuthService.auth(uid, token)) {
                return new Operate<org.click.admin.entity.Resource>(false, ADMIN_AUTH_FAILED.DESC, null);
            }
            iResourceService = (IResourceService) Consumer.singleton().getBean("IResourceService");

            if(file.isEmpty()) {
                return new Operate<org.click.admin.entity.Resource>(false,"null",null);
            }else {
                try {
                    byte[] bytes = file.getBytes();
                    return iResourceService.addResource(bytes, uid, fileName);
                } catch (IOException e) {
                    return new Operate<org.click.admin.entity.Resource>(false,"byte failed",null);
                }
            }

        }catch (IllegalStateException e){
            return new Operate<org.click.admin.entity.Resource>(false, "auth service doesn't work,no provider", null);
        }

    }

    @RequestMapping(value = "/{id}/{token}/auth/all",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<List<org.click.admin.entity.Resource>> getAll(@PathVariable("id") long uid,
                                                                 @PathVariable("token") String token){
        try{
            iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (!iAuthService.auth(uid, token)) {
                return new Operate<List<org.click.admin.entity.Resource>>(false, ADMIN_AUTH_FAILED.DESC, null);
            }
            iResourceService = (IResourceService) Consumer.singleton().getBean("IResourceService");
            return iResourceService.getResource();

        }catch (IllegalStateException e){
            return new Operate<List<org.click.admin.entity.Resource>>(false, "auth service doesn't work,no provider", null);
        }
    }


}

package org.nero.click.admin.web.controller;

import org.click.admin.dto.Layout;
import org.click.admin.entity.*;
import org.nero.click.admin.Consumer;
import org.nero.click.admin.service.IAuthService;
import org.nero.click.admin.service.IPageService;
import org.nero.click.sso.dto.Operate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import static org.click.admin.CONSTANT.CONSTANT.ADMIN_AUTH_FAILED;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-7
 * Time   :  下午6:48
 */
@Controller
@RestController
@RequestMapping("/page")
public class Page {

    private IPageService iPageService;

    private IAuthService iAuthService;



    @RequestMapping(value = "/{random}/get",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Layout> getPage(){
        iPageService = (IPageService) Consumer.singleton().getBean("IPageService");

        try {
            return new Operate<Layout>(true, new Layout(
                    iPageService.getHeader().getData(),
                    iPageService.getFooter().getData(),
                    iPageService.getLinks().getData(),
                    iPageService.getLogos().getData(),
                    iPageService.getBanners().getData()
            ));
        }catch (NullPointerException e){
            return new Operate<Layout>(false,new Layout(
                    new Header("标题","标签"),
                    new Footer("页脚"),
                    null,null,null
            ));
        }
    }

    @RequestMapping(value = "/header/{uid}/{token}/auth/{title}/{label}/set",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public  Operate<Header> setHeader(@PathVariable("uid") Long id,
                                      @PathVariable("token") String token,
                                      @PathVariable("title") String title,
                                      @PathVariable("label") String label){
        iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
        if(!iAuthService.auth(id,token)){
            return new Operate<Header>(false,ADMIN_AUTH_FAILED.DESC,null);
        }else{
            return iPageService.setHeader(title,label);
        }
    }


    @RequestMapping(value = "/footer/{uid}/{token}/auth/{label}/set",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public  Operate<Footer> setFooter(@PathVariable("uid") Long id,
                                      @PathVariable("token") String token,
                                      @PathVariable("label") String label){
        iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
        if(!iAuthService.auth(id,token)){
            return new Operate<Footer>(false,ADMIN_AUTH_FAILED.DESC,null);
        }else{
            return iPageService.setFooter(label);
        }

    }

    @RequestMapping(value = "/link/{uid}/{token}/auth/{name}/{hrefUrl}/add",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public  Operate<Link> addLink(@PathVariable("uid") Long id,
                                  @PathVariable("token") String token,
                                  @PathVariable("name") String name,
                                  @PathVariable("hrefUrl") String hrefUrl){
        iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
        if(!iAuthService.auth(id,token)){
            return new Operate<Link>(false,ADMIN_AUTH_FAILED.DESC,null);
        }else{
            return iPageService.addLink(name,hrefUrl);
        }
    }

    @RequestMapping(value = "/link/{uid}/{token}/auth/{id}/delete",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Link> delLink(@PathVariable("uid") Long uid,
                                 @PathVariable("token") String token,
                                 @PathVariable("id") Long id){
        iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
        if(!iAuthService.auth(uid,token)){
            return new Operate<Link>(false,ADMIN_AUTH_FAILED.DESC,null);
        }else{
            return iPageService.delLink(id);
        }
    }


    @RequestMapping(value = "/logo/{uid}/{token}/auth/{description}/{hrefUrl}/{imgUrl}/add",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public  Operate<Logo> addLogo(@PathVariable("uid") Long uid,
                                  @PathVariable("token") String token,
                                  @PathVariable("description") String description,
                                  @PathVariable("hrefUrl") String hrefUrl,
                                  @PathVariable("imgUrl") String imgUrl){
        iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
        if(!iAuthService.auth(uid,token)){
            return new Operate<Logo>(false,ADMIN_AUTH_FAILED.DESC,null);
        }else{
            return iPageService.addLogo(description,hrefUrl,imgUrl);
        }
    }


    @RequestMapping(value = "/logo/{uid}/{token}/auth/{id}/delete",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public  Operate<Logo> delLogo(@PathVariable("uid") Long uid,
                                  @PathVariable("token") String token,
                                  @PathVariable("id") Long id){
        iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
        if(!iAuthService.auth(uid,token)){
            return new Operate<Logo>(false,ADMIN_AUTH_FAILED.DESC,null);
        }else{
            return iPageService.delLogo(id);
        }
    }

    @RequestMapping(value = "/banner/{uid}/{token}/auth/{description}/{hrefUrl}/{imgUrl}/add",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Banner> addBanner(@PathVariable("uid") Long uid,
                                     @PathVariable("token") String token,
                                     @PathVariable("description") String description,
                                     @PathVariable("hrefUrl") String hrefUrl,
                                     @PathVariable("imgUrl") String imgUrl){
        iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
        if(!iAuthService.auth(uid,token)){
            return new Operate<Banner>(false,ADMIN_AUTH_FAILED.DESC,null);
        }else{
            return iPageService.addBanner(description,imgUrl,hrefUrl);
        }
    }

    @RequestMapping(value = "/banner/{uid}/{token}/auth/{id}/delete",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Banner> delBanner(@PathVariable("uid") Long uid,
                                     @PathVariable("token") String token,
                                     @PathVariable("id") Long id){
        iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
        if(!iAuthService.auth(uid,token)){
            return new Operate<Banner>(false,ADMIN_AUTH_FAILED.DESC,null);
        }else{
            return iPageService.delBanner(id);
        }
    }

}

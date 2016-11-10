package org.nero.click.admin.web.controller;

import org.click.admin.dto.Layout;
import org.click.admin.entity.*;
import org.nero.click.admin.Consumer;
import org.nero.click.sso.service.IAuthService;
import org.nero.click.admin.service.IPageService;
import org.nero.click.sso.dto.Operate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;


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
    public Operate<Layout> page() {
        try {
            iPageService = (IPageService) Consumer.singleton().getBean("IPageService");
            try {
                return new Operate<Layout>(true, new Layout(
                        iPageService.getHeader().getData(),
                        iPageService.getFooter().getData(),
                        iPageService.getLinks().getData(),
                        iPageService.getLogos().getData(),
                        iPageService.getBanners().getData()
                ));
            } catch (NullPointerException e) {
                return new Operate<Layout>(false, "connection failed!", new Layout(
                        null, null,
                        null, null, null
                ));
            }
        } catch (IllegalStateException e) {
            return new Operate<Layout>(false, "service doesn't work,no provider", null);
        }
    }
    @RequestMapping(value = "{uid}/{token}/auth/{random}/get",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Layout> getPage(@PathVariable("uid") long id,
                                   @PathVariable("token") String token) {
        try {
            iPageService = (IPageService) Consumer.singleton().getBean("IPageService");
            iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (!iAuthService.auth(id, token)) {
                return new Operate<Layout>(false, ADMIN_AUTH_FAILED.DESC, null);
            }
            try {
                return new Operate<Layout>(true, new Layout(
                        iPageService.getHeader().getData(),
                        iPageService.getFooter().getData(),
                        iPageService.getLinks().getData(),
                        iPageService.getLogos().getData(),
                        iPageService.getBanners().getData()
                ));
            } catch (NullPointerException e) {
                return new Operate<Layout>(false, "connection failed!", new Layout(
                        null, null,
                        null, null, null
                ));
            }
        } catch (IllegalStateException e) {
            return new Operate<Layout>(false, "service doesn't work,no provider", null);
        }
    }

    @RequestMapping(value = "/header/{uid}/{token}/auth/{title}/{label}/set",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Header> setHeader(@PathVariable("uid") long id,
                                     @PathVariable("token") String token,
                                     @PathVariable("title") String title,
                                     @PathVariable("label") String label) {
        try {
            iPageService = (IPageService) Consumer.singleton().getBean("IPageService");

            iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (!iAuthService.auth(id, token)) {
                return new Operate<Header>(false, ADMIN_AUTH_FAILED.DESC, null);
            } else {
                return iPageService.setHeader(title,label);
            }
        } catch (IllegalStateException e) {
            return new Operate<Header>(false, "service doesn't work,no provider", null);
        }
    }


    @RequestMapping(value = "/footer/{uid}/{token}/auth/{label}/set",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Footer> setFooter(@PathVariable("uid") Long id,
                                     @PathVariable("token") String token,
                                     @PathVariable("label") String label) {
        try {
            iPageService = (IPageService) Consumer.singleton().getBean("IPageService");

            iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (!iAuthService.auth(id, token)) {
                return new Operate<Footer>(false, ADMIN_AUTH_FAILED.DESC, null);
            } else {
                return iPageService.setFooter(label);
            }
        } catch (IllegalStateException e) {
            return new Operate<Footer>(false, "service doesn't work,no provider", null);
        }

    }

    @RequestMapping(value = "/link/{uid}/{token}/auth/{name}/{hrefUrl}/add",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Link> addLink(@PathVariable("uid") Long id,
                                 @PathVariable("token") String token,
                                 @PathVariable("name") String name,
                                 @PathVariable("hrefUrl") String hrefUrl) {
        try {
            iPageService = (IPageService) Consumer.singleton().getBean("IPageService");

            iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (!iAuthService.auth(id, token)) {
                return new Operate<Link>(false, ADMIN_AUTH_FAILED.DESC, null);
            } else {
                return iPageService.addLink(name, hrefUrl);
            }
        } catch  (IllegalStateException e) {
            return new Operate<Link>(false, "service doesn't work,no provider", null);
        }
    }

    @RequestMapping(value = "/link/{uid}/{token}/auth/{id}/delete",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Link> delLink(@PathVariable("uid") Long uid,
                                 @PathVariable("token") String token,
                                 @PathVariable("id") Long id) {
        try {
            iPageService = (IPageService) Consumer.singleton().getBean("IPageService");

            iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (!iAuthService.auth(uid, token)) {
                return new Operate<Link>(false, ADMIN_AUTH_FAILED.DESC, null);
            } else {
                return iPageService.delLink(id);
            }
        } catch (IllegalStateException e) {
            return new Operate<Link>(false, "service doesn't work,no provider", null);
        }
    }


    @RequestMapping(value = "/logo/{uid}/{token}/auth/{description}/{hrefUrl}/{imgUrl}/add",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Logo> addLogo(@PathVariable("uid") Long uid,
                                 @PathVariable("token") String token,
                                 @PathVariable("description") String description,
                                 @PathVariable("hrefUrl") String hrefUrl,
                                 @PathVariable("imgUrl") String imgUrl) {
        try {
            iPageService = (IPageService) Consumer.singleton().getBean("IPageService");

            iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (!iAuthService.auth(uid, token)) {
                return new Operate<Logo>(false, ADMIN_AUTH_FAILED.DESC, null);
            } else {
                return iPageService.addLogo(description, hrefUrl, imgUrl);
            }
        } catch (IllegalStateException e) {
            return new Operate<Logo>(false, "service doesn't work,no provider", null);
        }
    }


    @RequestMapping(value = "/logo/{uid}/{token}/auth/{id}/delete",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Logo> delLogo(@PathVariable("uid") Long uid,
                                 @PathVariable("token") String token,
                                 @PathVariable("id") Long id) {
        try {
            iPageService = (IPageService) Consumer.singleton().getBean("IPageService");

            iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (!iAuthService.auth(uid, token)) {
                return new Operate<Logo>(false, ADMIN_AUTH_FAILED.DESC, null);
            } else {
                return iPageService.delLogo(id);
            }
        } catch (IllegalStateException e) {
            return new Operate<Logo>(false, "service doesn't work,no provider", null);
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
                                     @PathVariable("imgUrl") String imgUrl) {
        try {
            iPageService = (IPageService) Consumer.singleton().getBean("IPageService");

            iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (!iAuthService.auth(uid, token)) {
                return new Operate<Banner>(false, ADMIN_AUTH_FAILED.DESC, null);
            } else {
                return iPageService.addBanner(description, imgUrl, hrefUrl);
            }
        } catch (IllegalStateException e) {
            return new Operate<Banner>(false, "service doesn't work,no provider", null);
        }
    }

    @RequestMapping(value = "/banner/{uid}/{token}/auth/{id}/delete",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Banner> delBanner(@PathVariable("uid") Long uid,
                                     @PathVariable("token") String token,
                                     @PathVariable("id") Long id) {
        try {
            iPageService = (IPageService) Consumer.singleton().getBean("IPageService");

            iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (!iAuthService.auth(uid, token)) {
                return new Operate<Banner>(false, ADMIN_AUTH_FAILED.DESC, null);
            } else {
                return iPageService.delBanner(id);
            }
        } catch (IllegalStateException e) {
            return new Operate<Banner>(false, "service doesn't work,no provider", null);
        }
    }

}

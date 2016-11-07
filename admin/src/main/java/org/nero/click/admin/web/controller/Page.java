package org.nero.click.admin.web.controller;

import org.click.admin.dto.Layout;
import org.nero.click.admin.Consumer;
import org.nero.click.admin.service.IPageService;
import org.nero.click.sso.dto.Operate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-7
 * Time   :  下午6:48
 */
@Controller
@RestController

@RequestMapping("/admin")
public class Page {
    private IPageService iPageService;

    @RequestMapping(value = "/page",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<Layout> getPage(){
        iPageService = (IPageService) Consumer.singleton().getBean("IPageService");

        return new Operate<Layout>(true,new Layout(
                iPageService.getHeader().getData(),
                iPageService.getFooter().getData(),
                iPageService.getLinks().getData(),
                iPageService.getLogos().getData(),
                iPageService.getBanners().getData()
        ));
    }
}

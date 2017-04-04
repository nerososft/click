package org.nero.click.sso.web.controller;

import org.nero.click.Consumer;
import org.nero.click.sso.dto.*;
import org.nero.click.sso.entity.Access;
import org.nero.click.sso.entity.AccessRequest;
import org.nero.click.sso.entity.Authpair;
import org.nero.click.sso.service.IAccessService;
import org.nero.click.sso.service.IAuthService;
import org.nero.click.sso.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/3/5
 * Time   下午5:46
 */
@Controller
@RequestMapping("/thrid")
public class ThirdSSO {

    private IAccessService iAccessService;

    private IAuthService iAuthService;

    private IUserService iUserService;



    @RequestMapping(value = "/{appKey}/{appSecretKey}/{timestamp}/{hash}/access",
            method = RequestMethod.GET)
    @ResponseBody
    public Operate<AccessToken> Access(@PathVariable("appKey") String appKey,
                                         @PathVariable("appSecretKey") String appSecrtKey,
                                         @PathVariable("timestamp") String timestamp,
                                         @PathVariable("hash") String hash){
        try{

            iAccessService = (IAccessService) Consumer.singleton().getBean("IAccessService");

            return iAccessService.access(new AccessRequest(appKey,appSecrtKey,timestamp,hash));

        }catch(IllegalStateException e){

            return new Operate<AccessToken>(false,"远程服务异常",null);

        }

    }


    @RequestMapping(value = "/{accessToken}/getLogin",
            method = RequestMethod.GET)
    public ModelAndView thirdLogin(@PathVariable("accessToken") String accessToken){

        Map<String,Operate<Access>> result = new HashMap<String, Operate<Access>>();
        try{

            iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");

            Operate<Access> ticketOperate =  iAuthService.thirdLogin(new AccessToken(new Token(accessToken)));


            result = new HashMap<String, Operate<Access>>();

            result.put("result",ticketOperate);

            return  new ModelAndView("login",result);


        }catch(IllegalStateException e){
            result = new HashMap<String, Operate<Access>>();

            result.put("result",null);

            return  new ModelAndView("error",result);
        }

    }

    @RequestMapping(value = "/{email}/{password}/{ticket}/login",
            method = RequestMethod.GET)
    @ResponseBody
    public Operate<FeedBack> login(@PathVariable("email") String email,
                        @PathVariable("password") String password,
                        @PathVariable("ticket") String ticket){
        try{

            iAuthService = (IAuthService) Consumer.singleton().getBean("IAuthService");

            return iAuthService.thirdLoginAccess(new Ticket(ticket),new Authpair(email,password));

        }catch(IllegalStateException e){

            return  new Operate<FeedBack>(false,"远程服务异常",null);

        }

    }

    @RequestMapping(value = "/{ticket}/{utoken}/getuserinfo",
            method = RequestMethod.GET)
    @ResponseBody
    public Operate<UserInfo> getUserInfo(@PathVariable("ticket") String ticket,
                                         @PathVariable("utoken") String utoken){
        try{
            iUserService = (IUserService) Consumer.singleton().getBean("IUserService");

            return iUserService.getUserInfo(new Token(ticket),new Token(utoken));

        }catch(IllegalStateException e){
            return new Operate<UserInfo>(false,"远程服务异常",null);
        }
    }

}

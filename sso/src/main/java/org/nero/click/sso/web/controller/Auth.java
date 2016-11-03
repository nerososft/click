package org.nero.click.sso.web.controller;

import org.nero.click.common.utils.md5.MD5;
import org.nero.click.common.utils.rendom.RandomString;
import org.nero.click.common.utils.verifycode.Verify;
import org.nero.click.common.utils.verifycode.exception.VerifyFailedException;
import org.nero.click.sso.dto.Operate;
import org.nero.click.sso.entity.Authpair;
import org.nero.click.sso.entity.User;
import org.nero.click.sso.exceptions.user.*;
import org.nero.click.sso.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-1
 * time: 下午2:16.
 */
@Controller
@RestController
@RequestMapping("sso")
public class Auth {

    @Autowired
    private IUserService userService;



    @RequestMapping(value = "/{code}/auth",
            method = RequestMethod.GET)
    public String authCode(
            @PathVariable("code") String code,
            HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", 0);

        Verify verify = new Verify(request);
        try{
            verify.checkVerify(code);
            return "ok";
        }catch (VerifyFailedException e){
            return "error";
        }
    }


    @RequestMapping(value = "/{email}/{password}/{code}/auth",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<User> login(@PathVariable("email") String email,
                               @PathVariable("password") String password,
                               @PathVariable("code") String code,
                               HttpServletRequest request,
                               HttpServletResponse response){
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", 0);

        Verify verify = new Verify(request);
        Operate<User> userOperate;
        try {
            System.out.println("code------:"+code+"-----"+verify.getVerifyCode());
            verify.checkVerify(code);
            userOperate = userService.Login(new Authpair(email,password));
        }catch (VerifyFailedException e){
            userOperate = new Operate<User>(false,e.getMessage(),null);
        } catch(LoginException e){
            userOperate = new Operate<User>(false,e.getMessage(),null);
        }catch (NoSuchAlgorithmException e) {
            userOperate = new Operate<User>(false,e.getMessage(),null);
        } catch (UnsupportedEncodingException e) {
            userOperate = new Operate<User>(false,e.getMessage(),null);
        }

        return userOperate;
    }

    @RequestMapping(value = "/{email}/{password}/{username}/add",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<User> register(@PathVariable("password") String password,
                                  @PathVariable("email")String email,
                                  @PathVariable("username")String username){

        Operate userOperate;
        try {
            String token = new MD5().EncoderByMd5(new RandomString().getRandomString(128));
            User user = new User(password,"null",token,email,username);
            userOperate = userService.Register(user);
        }catch(RegisterException e){
            userOperate = new Operate<User>(false,null);
        } catch (UnsupportedEncodingException e) {
            userOperate = new Operate<User>(false,null);
        } catch (NoSuchAlgorithmException e) {
            userOperate = new Operate<User>(false,null);
        }
        return userOperate;
    }
    @RequestMapping(value = "/{token}/add",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<User> registerAuth(@PathVariable("token") String token){

        Operate<User> userOperate;
        try {
            userOperate = userService.RegisterAuth(token);

        }catch(NoSuchUserException e) {
            userOperate = new Operate<User>(false,null);
        }catch(RegisterException e){
            userOperate = new Operate<User>(false,null);
        }catch(TimeOutException e){
            userOperate = new Operate<User>(false,null);
        }catch(ActiveException e){
            userOperate = new Operate<User>(false,null);
        } catch (NoSuchAlgorithmException e) {
            userOperate = new Operate<User>(false,null);
        } catch (UnsupportedEncodingException e) {
            userOperate = new Operate<User>(false,null);
        }

        return userOperate;
    }

}

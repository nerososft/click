package org.nero.click.web.controller;

import org.nero.click.dto.Operate;
import org.nero.click.entity.User;
import org.nero.click.entity.Authpair;
import org.nero.click.exception.user.*;
import org.nero.click.service.IUserService;
import org.nero.click.utils.md5.MD5;
import org.nero.click.utils.rendom.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-1
 * time: 下午2:16.
 */
@Controller
@RequestMapping("/")
public class Auth {

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/{email}/{password}/auth",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<User> login(@PathVariable("email") String email,
                               @PathVariable("password") String password){
        Operate<User> userOperate;
        try {
            userOperate = userService.Login(new Authpair(email,password));
        }catch(LoginException e){
            userOperate = new Operate<User>(false,null);
        }catch (NoSuchAlgorithmException e) {
            userOperate = new Operate<User>(false,null);
        } catch (UnsupportedEncodingException e) {
            userOperate = new Operate<User>(false,null);
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

package org.nero.click.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.click.entity.Authpair;
import org.nero.click.entity.User;
import org.nero.click.exception.user.*;
import org.nero.click.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

/**
 * Author nero
 * Date   2016/10/14 0014
 * Time   21:28
 * Email  nerosoft@outlook.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class UserServiceImplTest {


    @Autowired
    private IUserService iUserService;

    @Test
    public void login() throws Exception {
        try {
            System.out.println(iUserService.Login(new Authpair("nerosoft@outlook.com", "password")));
        }catch(LoginException e){
            System.out.println(e.getMessage());
        }catch(NoSuchAlgorithmException e){
            System.out.println(e.getMessage());
        }catch(UnsupportedEncodingException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void register() throws Exception {
        try {
            System.out.println(iUserService.Register(new User("password", "15122372903", "token", "nerosoft@outlook.com.com", "兴锋")));
        }catch (RegisterException e){
            System.out.println(e.getMessage());
        }catch(UnsupportedEncodingException e){
            System.out.println(e.getMessage());
        }catch(NoSuchAlgorithmException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void registerAuth() throws Exception {
        try {
            System.out.println(iUserService.RegisterAuth("K5nwQthxRN2QzqS0lL9xTw=="));
        }catch(NoSuchUserException e){
            System.out.println(e.getMessage());
        }catch (ActiveException e) {
            System.out.println(e.getMessage());
        }catch(RegisterException e){
            System.out.println(e.getMessage());
        }catch(TimeOutException e){
            System.out.println(e.getMessage());
        }catch(UnsupportedEncodingException e){
            System.out.println(e.getMessage());
        }catch(NoSuchAlgorithmException e){
            System.out.println(e.getMessage());
        }
    }

}
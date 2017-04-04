package org.nero.click.sso.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.click.sso.dto.AccessToken;
import org.nero.click.sso.dto.Ticket;
import org.nero.click.sso.dto.Token;
import org.nero.click.sso.entity.Authpair;
import org.nero.click.sso.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/3/6
 * Time   上午9:27
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class AuthServiceImplTest {

    @Autowired
    private IAuthService iAuthService;


    @Test
    public void thirdLogin2() throws Exception {
        System.out.println(iAuthService.thirdLogin(new AccessToken(new Token("ba9c5d39aeb7d73f11daf169ea814ff4"))));
    }

    @Test
    public void thirdLoginAccess2() throws Exception {
        System.out.println(iAuthService.thirdLoginAccess(new Ticket("99f7644e6111995b87b8d9f8c42049d6"),new Authpair("admin@click.org","click")));
    }

    @Test
    public void getAppInfoByKey() throws Exception {
        System.out.println(iAuthService.getAppInfoByKey("testappkey","testappsecretkey"));
    }

    @Test
    public void getAppInfoByTicket1() throws Exception {
        System.out.println(iAuthService.getAppInfoByTicket(new Ticket("42aecee383bc0949d135c8f3bc373b5c")));
    }


    @Test
    public void auth() throws Exception {
        System.out.println(iAuthService.auth(1,"42aecee383bc0949d135c8f3bc373b5c"));
    }

    @Test
    public void thirdLogin() throws Exception {
        System.out.println(iAuthService.thirdLogin(new AccessToken(new Token("accesstoken"))));
    }

}
package org.nero.click.sso.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.click.sso.entity.AccessRequest;
import org.nero.click.sso.service.IAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/3/5
 * Time   下午7:31
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class AccessServiceImplTest {

    @Autowired
    private IAccessService iAccessService;


    @Test
    public void access() throws Exception {
        System.out.println(iAccessService.access(new AccessRequest("testappkey","testappsecretkey","222","qwesafe")));
    }

}
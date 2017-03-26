package org.nero.click.sso.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/3/5
 * Time   下午7:21
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class AccessDaoTest {
    @Test
    public void findByAccessToken() throws Exception {
        System.out.println(accessDao.findByAccessToken("accesstoken"));
    }

    @Autowired
    private AccessDao accessDao;

    @org.junit.Test
    public void findByAccessRequest() throws Exception {
        System.out.println(accessDao.findByAccessRequest("testappkey","testappsecretkey"));
    }

    @org.junit.Test
    public void updateAccessToken() throws Exception {
        System.out.println(accessDao.updateAccessToken("testappkey","newtoken",Long.valueOf(10086)));
    }

}
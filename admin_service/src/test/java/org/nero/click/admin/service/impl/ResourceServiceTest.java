package org.nero.click.admin.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nero.click.admin.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-14
 * Time   :  下午3:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class ResourceServiceTest {

    @Autowired
    private IResourceService iResourceService;


    @Test
    public void isTypeAllow() throws Exception {

        //iResourceService.addResource(,1,"上传文件测试")
    }

    @Test
    public void addResource() throws Exception {

    }

    @Test
    public void getResource() throws Exception {

    }

}
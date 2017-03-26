package org.nero.click.sso.service.impl;

import org.nero.click.common.utils.md5.FileDiffUtil;
import org.nero.click.common.utils.rendom.RandomString;
import org.nero.click.sso.dao.AccessDao;
import org.nero.click.sso.dto.AccessToken;
import org.nero.click.sso.dto.Application;
import org.nero.click.sso.dto.Operate;
import org.nero.click.sso.dto.Token;
import org.nero.click.sso.entity.Access;
import org.nero.click.sso.entity.AccessRequest;
import org.nero.click.sso.service.IAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.nero.click.sso.CONSTANT.NOT_ACCESS;
import static org.nero.click.sso.CONSTANT.NOT_ACTIVE;
import static org.nero.click.sso.CONSTANT.SSO_ERROR;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2016/12/19
 * Time   上午1:07
 */
@Service
public class AccessServiceImpl implements IAccessService {


    @Autowired
    private AccessDao accessDao;

    @Transactional
    public Operate<AccessToken> access(AccessRequest accessRequest) {


        System.out.println(accessRequest);

        Access access;

        try{

            access = accessDao.findByAccessRequest(accessRequest.getAppKey(),accessRequest.getSecretKey());

            if(access.getIsactive().equals("1")) {

                RandomString randomString = new RandomString();

                String rands = randomString.getRandomString(64) + String.valueOf(System.currentTimeMillis());

                String token = FileDiffUtil.getMD5(rands.getBytes());

                Long expirationTime = System.currentTimeMillis() + 60 * 1000 * 60 * 2;

                if (accessDao.updateAccessToken(accessRequest.getAppKey(), token, expirationTime) < 1) {

                    return new Operate<AccessToken>(false, SSO_ERROR.DESC, null);

                }

                return new Operate<AccessToken>(true, "", new AccessToken(new Token(token), expirationTime));

            }

            return new Operate<AccessToken>(false,NOT_ACTIVE.DESC,null);

        }catch(NullPointerException e) {

            return new Operate<AccessToken>(false, NOT_ACCESS.DESC, null);

        }

    }

    public Operate<Application> getApplicationInfo(Token token) {
        return null;
    }
}

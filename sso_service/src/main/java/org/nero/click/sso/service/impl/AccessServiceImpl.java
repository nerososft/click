package org.nero.click.sso.service.impl;

import org.nero.click.sso.dao.AccessDao;
import org.nero.click.sso.dto.AccessToken;
import org.nero.click.sso.dto.Application;
import org.nero.click.sso.dto.Operate;
import org.nero.click.sso.dto.Token;
import org.nero.click.sso.entity.Access;
import org.nero.click.sso.entity.AccessRequest;
import org.nero.click.sso.service.IAccessService;

import static org.nero.click.sso.CONSTANT.NOT_ACCESS;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2016/12/19
 * Time   上午1:07
 */
public class AccessServiceImpl implements IAccessService {


    private AccessDao accessDao;

    public Operate<AccessToken> access(AccessRequest accessRequest) {
        Access access = accessDao.findByAccessRequest(accessRequest.getAppKey(),accessRequest.getSecretKey());
        if(access!=null){

        }
        return new Operate<AccessToken>(false,NOT_ACCESS.DESC,null);
    }

    public Operate<Application> getApplicationInfo(Token token) {
        return null;
    }
}

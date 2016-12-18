package org.nero.click.sso.service.impl;

import org.nero.click.sso.dto.AccessToken;
import org.nero.click.sso.dto.Application;
import org.nero.click.sso.dto.Operate;
import org.nero.click.sso.dto.Token;
import org.nero.click.sso.entity.AccessRequest;
import org.nero.click.sso.service.IAccessService;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2016/12/19
 * Time   上午1:07
 */
public class AccessServiceImpl implements IAccessService {

    public Operate<AccessToken> access(AccessRequest accessRequest) {
        return null;
    }

    public Operate<Application> getApplicationInfo(Token token) {
        return null;
    }
}

package org.nero.click.sso.service;

import org.nero.click.sso.dto.AccessToken;
import org.nero.click.sso.dto.Application;
import org.nero.click.sso.dto.Operate;
import org.nero.click.sso.dto.Token;
import org.nero.click.sso.entity.AccessRequest;
import org.springframework.stereotype.Service;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2016/12/19
 * Time   上午1:06
 */
public interface IAccessService {

    /**
     * 授权获取访问令牌
     * 该令牌可调出登录系统
     * 配合用户访问令牌可访问用户信息
     *
     * @param accessRequest 认证请求信息
     * @return 访问令牌
     */
    Operate<AccessToken> access(AccessRequest accessRequest);


    /**
     * 获取第三方应用信息
     *
     * @param token 访问令牌
     * @return 应用信息
     */
    Operate<Application> getApplicationInfo(Token token);


}

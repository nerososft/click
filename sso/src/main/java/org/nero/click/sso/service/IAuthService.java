package org.nero.click.sso.service;


import org.nero.click.sso.dto.*;
import org.nero.click.sso.entity.Access;
import org.nero.click.sso.entity.Authpair;
import org.nero.click.sso.entity.User;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-7
 * Time   :  下午9:01
 */
public interface IAuthService {
    /**
     * token认证
     * @param id
     * @param token
     * @return
     */
    boolean auth(long id,String token);

    /**
     * 第三方登录
     * @param token 第三方应用访问令牌
     * @return 用户访问令牌
     */
    Operate<Access> thirdLogin(AccessToken token);


    /**
     * 第三方用户登陆认证
     * @param token
     * @param authpair
     * @return
     */
    Operate<FeedBack> thirdLoginAccess(Ticket token, Authpair authpair);


    /**
     * 通过秘钥获取第三方应用信息
     * @param appKey
     * @param appSecretKey
     * @return
     */
    Operate<AccessInfo> getAppInfoByKey(String appKey,String appSecretKey);


    /**
     * 通过平台认证ticket获取第三方应用信息
     * @param ticket
     * @return
     */
    Operate<AccessInfo> getAppInfoByTicket(Ticket ticket);

}

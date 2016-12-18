package org.nero.click.sso.service;


import org.nero.click.sso.dto.Operate;
import org.nero.click.sso.dto.Token;
import org.nero.click.sso.entity.Authpair;

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
     * @param authpair 用户邮箱和密码
     * @return 用户访问令牌
     */
    Operate<Token> thirdLogin(Token token, Authpair authpair);



}

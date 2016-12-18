package org.nero.click.sso.service;

import org.nero.click.sso.dto.Token;
import org.nero.click.sso.dto.UserInfo;
import org.nero.click.sso.entity.Authpair;
import org.nero.click.sso.entity.User;
import org.nero.click.sso.dto.Operate;
import org.nero.click.sso.exceptions.user.LoginException;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-1
 * time: 下午2:15.
 */
public interface IUserService {

    Operate Login(Authpair authpair) throws LoginException,NoSuchAlgorithmException, UnsupportedEncodingException;

    Operate Register(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    Operate RegisterAuth(String token) throws NoSuchAlgorithmException, UnsupportedEncodingException;


    /**
     * 第三方应用获取用户信息
     *
     * @param appToken 第三方应用访问令牌
     * @param userToken 用户访问令牌
     * @return 基本用户信息
     */
    Operate<UserInfo> getUserInfo(Token appToken,Token userToken);

}

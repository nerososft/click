package org.nero.click.sso.service;

import org.nero.click.sso.dto.Operate;
import org.nero.click.sso.entity.Authpair;
import org.nero.click.sso.entity.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-1
 * time: 下午2:15.
 */
public interface IUserService {

    Operate Login(Authpair authpair) throws NoSuchAlgorithmException, UnsupportedEncodingException;

    Operate Register(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    Operate RegisterAuth(String token) throws NoSuchAlgorithmException, UnsupportedEncodingException;

}

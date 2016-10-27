package org.nero.click.service;

import org.nero.click.dto.Operate;
import org.nero.click.entity.User;
import org.nero.click.entity.Authpair;

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

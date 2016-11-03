package org.nero.click.sso.service.impl;

import org.nero.click.common.utils.Constant;
import org.nero.click.common.utils.md5.MD5;
import org.nero.click.common.utils.rendom.RandomString;
import org.nero.click.sso.dao.UserDao;
import org.nero.click.sso.entity.Authpair;
import org.nero.click.sso.entity.User;
import org.nero.click.sso.exceptions.user.*;
import org.nero.click.sso.service.IUserService;
import org.nero.click.sso.service.observer.RegisterObserver;
import org.nero.click.sso.dto.Operate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-1
 * time: 下午2:27.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public synchronized Operate Login(Authpair authpair) throws LoginException, NoSuchAlgorithmException, UnsupportedEncodingException {
        User user = userDao.queryByEmail(authpair.getEmail());
        if (user == null) {
            throw new LoginException("用户不存在");
        } else if (user.getIsactive() == Constant.NOT_ACTIVE.flag) {
            throw new LoginException("用户未激活");
        } else {
            if(!authpair.getPassword().equals(user.getPassword())){
                throw new LoginException("密码错误");
            }else if (userDao.update(user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getPhone(),
                    new MD5().EncoderByMd5(new RandomString().getRandomString(128)),
                    user.getCtime()) < 1) {
                throw new LoginException("登陆失败");
            }else{
                //此处session注入domain

            }
        }
        return new Operate<User>(true, userDao.queryByEmail(authpair.getEmail()));
    }

    public synchronized Operate Register(User user) throws RegisterException, UnsupportedEncodingException, NoSuchAlgorithmException {
        User haveuser = userDao.queryByEmail(user.getEmail());
        String token = new MD5().EncoderByMd5(new RandomString().getRandomString(128));
        if (haveuser != null && haveuser.getIsactive()==1) {
            throw new RegisterException("该邮箱已经绑定");
        } else if(haveuser!=null && haveuser.getIsactive()==0){
            if(userDao.update(haveuser.getId(),user.getUsername(),
                    user.getPassword(),user.getEmail(),
                    user.getPhone(),
                    token,
                    new java.sql.Timestamp(System.currentTimeMillis())) < 1){
                throw new RegisterException("注册失败");
            }
        }
        //此处发邮件
        new RegisterObserver().update(null, user);

        return new Operate<User>(true, user);

    }

    @Transactional
    public synchronized Operate RegisterAuth(String token) throws NoSuchAlgorithmException,UnsupportedEncodingException,ActiveException {
        User user = userDao.queryByToken(token);
        if(user==null){
            throw new NoSuchUserException("该邮箱没有注册");
        }else if(user.getIsactive()==1) {
            throw new RegisterException("该邮箱已经绑定");
        }else if(System.currentTimeMillis()-user.getCtime().getTime()>30*60*1000){
            String newToken = new MD5().EncoderByMd5(new RandomString().getRandomString(128));
            if(userDao.update(user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone(),
                newToken,
                    new java.sql.Timestamp(System.currentTimeMillis()))<1){
                throw new RegisterException("出错了,请重试");
            }else {
                new RegisterObserver().update(null,userDao.query(user.getId()));
                throw new TimeOutException("该注册已经超时,新的邮件已经发送至您的邮箱");
            }
        }else{
            if(userDao.active(user.getId())<1){
                throw new ActiveException("激活失败");
            }
        }
        return new Operate<User>(true,userDao.query(user.getId()));
    }
}

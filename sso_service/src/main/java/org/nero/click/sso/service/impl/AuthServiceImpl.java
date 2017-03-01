package org.nero.click.sso.service.impl;

import org.nero.click.sso.dao.UserDao;
import org.nero.click.sso.dto.Operate;
import org.nero.click.sso.dto.Token;
import org.nero.click.sso.entity.Authpair;
import org.nero.click.sso.entity.User;
import org.nero.click.sso.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-7
 * Time   :  下午9:02
 */
@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired private UserDao userDao;

    public boolean auth(long id, String token) {

        User user  = userDao.queryByToken(token);
        if(user!=null){
            if(user.getId()==id){
                return true;
            }
            return false;
        }
        return false;
    }




    public Operate<Token> thirdLogin(Token token, Authpair authpair) {
        return null;
    }
}

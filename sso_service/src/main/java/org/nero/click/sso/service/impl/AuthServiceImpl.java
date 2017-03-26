package org.nero.click.sso.service.impl;

import org.nero.click.common.utils.Constant;
import org.nero.click.common.utils.md5.FileDiffUtil;
import org.nero.click.common.utils.rendom.RandomString;
import org.nero.click.sso.dao.AccessDao;
import org.nero.click.sso.dao.UserDao;
import org.nero.click.sso.dto.*;
import org.nero.click.sso.entity.Access;
import org.nero.click.sso.entity.Authpair;
import org.nero.click.sso.entity.User;
import org.nero.click.sso.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import static org.nero.click.sso.CONSTANT.*;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-7
 * Time   :  下午9:02
 */
@Service
public class AuthServiceImpl implements IAuthService {



    @Autowired
    private AccessDao accessDao;

    @Autowired
    private UserDao userDao;

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


    /**
     * 调出第三方登陆
     * @param token 第三方应用访问令牌
     * @return
     */
    public Operate<Access> thirdLogin(AccessToken token) {

        Access access = null;
        try {
            //System.out.println(token);
            access = accessDao.findByAccessToken(token.getToken().getToken().toString());

            RandomString randomString = new RandomString();

            String rands = randomString.getRandomString(64) + String.valueOf(System.currentTimeMillis());

            String returnToken = FileDiffUtil.getMD5(rands.getBytes());

            if(accessDao.updateToken(access.getAccesstoken(),returnToken)<1){

                return new Operate<Access>(false,SSO_ERROR.DESC,access);

            }

            return new Operate<Access>(true,new Access(access.getId(),
                    access.getAppkey(),
                    access.getAppsecretkey(),
                    returnToken,
                    access.getAccesstoken(),
                    access.getFeedbackurl(),
                    access.getAppname(),
                    access.getAppavatar(),
                    access.getIsactive(),
                    access.getExpir(),
                    access.getCtime()));

        }catch(NullPointerException e){

            return new Operate<Access>(false,TOKEN_EXPIR.DESC,null);

        }
    }

    public Operate<FeedBack> thirdLoginAccess(Ticket ticket, Authpair authpair) {

        Access access=  null;

        try{

            access = accessDao.findByToken(ticket.getTicket());

            User user = userDao.queryByEmail(authpair.getEmail());

            if (user == null) {

                return new Operate<FeedBack>(false,USER_NOT_EXISTS.DESC,null);

            } else if (user.getIsactive() == Constant.NOT_ACTIVE.flag) {

                return new Operate<FeedBack>(false,USER_NOT_ACTIVE.DESC,null);

            } else {

                if(!authpair.getPassword().equals(user.getPassword())){

                    return new Operate<FeedBack>(false,USER_PASSWORD_UNCORRECT.DESC,null);

                }else{

                    //feedback
                    String feedBackUrl = access.getFeedbackurl();

                    return new Operate<FeedBack>(true,new FeedBack(feedBackUrl,new Ticket(access.getToken()),new Token(user.getToken())));

                }

            }

        }catch(NullPointerException e){

            return new Operate<FeedBack>(false,NOT_ACCESS.DESC,null);

        }

    }


    public Operate<AccessInfo> getAppInfoByKey(String appKey,String appSecretKey){

        AccessInfo access = accessDao.getAppByKey(appKey,appSecretKey);

        if(access==null){

            return new Operate<AccessInfo>(false,NOT_ACCESS.DESC,null);

        }

        return new Operate<AccessInfo>(true,access);

    }



    public Operate<AccessInfo> getAppInfoByTicket(Ticket ticket){
        AccessInfo access = accessDao.getAppByTicket(ticket.getTicket());

        if(access==null){

            return new Operate<AccessInfo>(false,NOT_ACCESS.DESC,null);

        }

        return new Operate<AccessInfo>(true,access);
    }
}

package org.nero.click.sso.service.observer;

import org.nero.click.common.utils.email.MailSenderFactory;
import org.nero.click.common.utils.email.MailSenderType;
import org.nero.click.common.utils.email.SimpleMailSender;
import org.nero.click.sso.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-4
 * time: 下午5:04.
 */
public class RegisterObserver implements Observer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public void update(Observable o, Object arg) {
        SimpleMailSender simpleMailSender = MailSenderFactory.getSender(MailSenderType.SERVICE);
        List<String> reciveUsers = new ArrayList<String>();
        User user = null;
        if(arg instanceof User){
            user = (User)arg;
        }

        reciveUsers.add(user.getEmail());

            try {
                simpleMailSender.send(reciveUsers,"hi "+user.getUsername()+",欢迎加入click基因大数据社区!",
                        "<html><head><title>click</title><meta charset='utf-8'></head><body><style>body{font-family:Microsoft Yahei;}#main{width:500px;height:300px;margin:0 auto;border-collapse:separate;border-spacing:2px;box-shadow:0px 0px 0px 0px#C9C9C9;overflow:hidden}.head{width:500px;height:50px;background:url('http://smilewithu.com/click/headerbgn2.jpg')no-repeat}img{height:50px;width:69px;margin:2px}.container{width:500px;height:250px}.container-text{font-size:40px;text-align:center;color:#715694;font-weight:bold;height:70px;line-height:90px}.container span{text-align:center;font-size:17px;display:block;height:50px}.container.container-activation{text-align:center;height:80px;overflow:hidden}.container.container-activation a{background:#fff;text-decoration:none;border:solid 1px#653885;border-radius:4px;color:#715694;display:block;width:120px;height:50px;line-height:50px;margin:15px auto}.container.annotation{font-size:12px;color:#C4C4C4;height:50px;display:block;padding-top:10px}</style><div id='main'><div class='head'><img src='http://smilewithu.com/click/logo.gif'></div><div class='container'><div class='container-text'>welcome to click！</div><span>Thanks for joining us.<br>Please click the button below to activate your account.</span><div class='container-activation'><a href='http://localhost:8080/"+user.getToken()+"'>Activate</a></div><span class='annotation'>This link is valid for 30 minutes.<br>Please ignore this email if you did not take relative operation.</span></div></div></body></html>");
            } catch (MessagingException e) {
                logger.error(e.getMessage());
            }
    }
}

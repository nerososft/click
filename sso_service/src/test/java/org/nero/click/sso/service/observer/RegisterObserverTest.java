package org.nero.click.sso.service.observer;

import org.junit.Test;
import org.nero.click.sso.entity.User;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/3/16
 * Time   上午10:25
 */
public class RegisterObserverTest {




    @Test
    public void update() throws Exception {


        User user = new User("","","","867958652@qq.com","小柏然");
        RegisterObserver registerObserver = new RegisterObserver();

        for(int i = 0;i<1000;i++) {

            registerObserver.update(null, user);
            System.out.println(i);
        }
    }

}
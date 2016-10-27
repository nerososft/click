package org.nero.click.service.observer;

import org.junit.Test;
import org.nero.click.entity.User;

import static org.junit.Assert.*;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-6
 * time: 下午6:43.
 */
public class RegisterObserverTest {
    private RegisterObserver registerObserver = new RegisterObserver();

    @Test
    public void update() throws Exception {
            registerObserver.update(null, new User("yu", "ss", "asfsvass34tfregwe4tewrg5gw", "mail@smilewithu.com", "yang"));
    }

}
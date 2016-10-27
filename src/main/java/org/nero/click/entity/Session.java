package org.nero.click.entity;


import org.nero.click.entity.Domian;
import org.nero.click.entity.User;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-1
 * time: 下午6:57.
 */
public final class Session {

    private Domian domian;

    private User user;
    
    public Domian getDomian() {
        return domian;
    }

    public void setDomian(Domian domian) {
        this.domian = domian;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Session(Domian domian, User user) {
        this.domian = domian;
        this.user = user;
    }

    public Session() {
    }

    @Override
    public String toString() {
        return "Session{" +
                "domian=" + domian.toString() +
                ", user=" + user.toString() +
                '}';
    }
}

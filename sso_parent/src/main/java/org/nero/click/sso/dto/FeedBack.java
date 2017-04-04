package org.nero.click.sso.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/3/6
 * Time   上午9:19
 */
public class FeedBack implements Serializable {

    private String url;

    private Ticket ticket;

    private Token uToken;

    public FeedBack(String url, Ticket ticket,Token uToken) {
        this.url = url;
        this.ticket = ticket;
        this.uToken = uToken;
    }

    public Token getuToken() {
        return uToken;
    }

    public void setuToken(Token uToken) {
        this.uToken = uToken;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "url='" + url + '\'' +
                ", ticket=" + ticket +
                ", uToken=" + uToken +
                '}';
    }
}

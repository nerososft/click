package org.nero.click.sso.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/3/6
 * Time   上午8:55
 */
public class Ticket implements Serializable {

    private String ticket;


    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Ticket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticket='" + ticket + '\'' +
                '}';
    }
}

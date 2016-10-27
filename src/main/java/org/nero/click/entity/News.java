package org.nero.click.entity;

import java.util.Date;

/**
 * Created by nero on 2016/10/14 0014.
 */
public class News {
    private long id;
    private String title;
    private String Content;
    private Date ctime;

    public News() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", Content='" + Content + '\'' +
                ", ctime=" + ctime +
                '}';
    }
}

package org.click.admin.entity;

import java.io.Serializable;

/**
 * Created by root on 16-11-5.
 */
public class Logo implements Serializable {
    private Long   id;
    private String descrip;

    private String hrefUrl;

    private String imgUrl;

    public Logo() {
    }


    public Logo(String descrip, String hrefUrl, String imgUrl) {
        this.descrip = descrip;
        this.hrefUrl = hrefUrl;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getdescrip() {
        return descrip;
    }

    public void setdescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getHrefUrl() {
        return hrefUrl;
    }

    public void setHrefUrl(String hrefUrl) {
        this.hrefUrl = hrefUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Logo{" +
                "id=" + id +
                ", descrip='" + descrip + '\'' +
                ", hrefUrl='" + hrefUrl + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}

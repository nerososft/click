package org.click.admin.entity;

import java.io.Serializable;

/**
 * Created by root on 16-11-5.
 */
public class Banner implements Serializable {
    private Long id;

    private String descrip;

    private String imgUrl;

    private String hrefUrl;

    public Banner() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getHrefUrl() {
        return hrefUrl;
    }

    public void setHrefUrl(String hrefUrl) {
        this.hrefUrl = hrefUrl;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", descrip='" + descrip + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", hrefUrl='" + hrefUrl + '\'' +
                '}';
    }
}

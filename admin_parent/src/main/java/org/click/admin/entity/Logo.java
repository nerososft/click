package org.click.admin.entity;

import java.io.Serializable;

/**
 * Created by root on 16-11-5.
 */
public class Logo implements Serializable {
    private Long   id;
    private String descript;

    private String hrefUrl;

    private String imgUrl;

    public Logo() {
    }


    public Logo(String descript, String hrefUrl, String imgUrl) {
        this.descript = descript;
        this.hrefUrl = hrefUrl;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
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
                ", descript='" + descript + '\'' +
                ", hrefUrl='" + hrefUrl + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}

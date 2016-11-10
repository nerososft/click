package org.click.admin.dto;

import org.click.admin.entity.*;

import java.io.Serializable;
import java.util.List;

/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-7
 * Time   :  下午7:05
 */
public class Layout implements Serializable {
    private Header header;
    private Footer footer;
    private List<Link> links;
    private List<Logo> logos;
    private List<Banner> banners;

    public Layout() {
    }

    public Layout(Header header, Footer footer, List<Link> links, List<Logo> logos, List<Banner> banners) {
        this.header = header;
        this.footer = footer;
        this.links = links;
        this.logos = logos;
        this.banners = banners;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Footer getFooter() {
        return footer;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<Logo> getLogos() {
        return logos;
    }

    public void setLogos(List<Logo> logos) {
        this.logos = logos;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    @Override
    public String toString() {
        return "Layout{" +
                "header=" + header +
                ", footer=" + footer +
                ", links=" + links +
                ", logos=" + logos +
                ", banners=" + banners +
                '}';
    }
}

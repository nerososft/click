package org.nero.click.data.web.controller;

import org.nero.click.data.dto.Operate;
import org.nero.click.data.exception.news.NewsNotFoundException;
import org.nero.click.data.service.INewsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Author nero
 * Date   2016/10/14 0014
 * Time   21:24
 * Email  nerosoft@outlook.com
 */
@Controller
@RequestMapping("/news")
public class News {

    private INewsService newsService;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<org.nero.click.data.entity.News> getNew(@PathVariable("id") long id){

        Operate<org.nero.click.data.entity.News> operate;
        org.nero.click.data.entity.News news;
        try {
            news = newsService.getNewsById(id);
            operate = new Operate<org.nero.click.data.entity.News>(true,"",news);
        }catch(NewsNotFoundException e){
            operate = new Operate<org.nero.click.data.entity.News>(true,"没有找到",null);
        }
        return operate;
    }


    @RequestMapping(value = "/{limit}/{offset}",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate<org.nero.click.data.entity.News> getNews(@PathVariable("limit") long limit,
                                                            @PathVariable("offset") long offset){
        List<org.nero.click.data.entity.News> news = newsService.getNews(limit,offset);
        return new Operate<org.nero.click.data.entity.News>(true,"", (org.nero.click.data.entity.News) news);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        String url = "jdbc:mysql://localhost:3306/click?"
                + "user=root&password=&useUnicode=true&characterEncoding=UTF8";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql = "select count(*) from gene;";
            boolean result = stmt.execute(sql);
            if(result){
                System.out.println("ok");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        }
        return "test";
    }






}

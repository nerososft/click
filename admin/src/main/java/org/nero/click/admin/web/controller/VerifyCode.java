package org.nero.click.data.admin.web.controller;

import org.nero.click.common.utils.verifycode.Verify;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * author: nero
 * date:   2016/11/2 0002
 * time:   12:53
 */
@RestController
@Controller
@RequestMapping("/verify")
public class VerifyCode {

    /**
     * 获取验证码
     */
    @RequestMapping(value = "/{random}/create",
            method = RequestMethod.GET)
    public void getVerify(@PathVariable("random") String random,
                          HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", 0);
        //表明生成的响应是图片
        response.setContentType("image/png");

        Verify verify = new Verify(request);


        BufferedImage image = verify.createImage(60,200,80,true);


        ImageIO.write(image, "png", response.getOutputStream());
    }

    @RequestMapping(value = "/{code}/auth",
            method = RequestMethod.GET)
    public String authCode(
            @PathVariable("code") String code,
            HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", 0);

        Verify verify = new Verify(request);
        if(verify.checkVerify(code)){
            return "ok";
        }
        return "error";
    }
}

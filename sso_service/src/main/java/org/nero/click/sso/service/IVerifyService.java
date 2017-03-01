package org.nero.click.sso.service;

import org.nero.click.sso.dto.Operate;

import java.awt.image.BufferedImage;

/**
 * Author neroyang
 * 验证码服务
 * 用户生成图形验证码
 *
 * Email  nerosoft@outlook.com
 * Date   2017/2/24
 * Time   上午11:53
 */
public interface IVerifyService {


    /**
     * 获取验证码
     * @return
     */
    Operate<BufferedImage> getVerifyImg();


    /**
     * 验证码验证
     * @param verifyCode
     * @return
     */
    Operate<Boolean> checkVerify(String verifyCode);

}

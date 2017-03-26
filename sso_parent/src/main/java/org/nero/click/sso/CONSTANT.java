package org.nero.click.sso;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2016/12/20
 * Time   下午3:30
 */
public enum CONSTANT {
    NOT_ACTIVE("未激活"),
    NOT_ACCESS("未授权"),
    TOKEN_EXPIR("认证过期"),
    USER_NOT_EXISTS("用户不存在"),
    USER_NOT_ACTIVE("用户未激活"),
    USER_PASSWORD_UNCORRECT("密码错误"),
    USER_LOGIN_ERROR("用户登陆失败"),
    SSO_ERROR("错误");

    public String DESC;

    CONSTANT(String DESC){
        this.DESC = DESC;
    }
}

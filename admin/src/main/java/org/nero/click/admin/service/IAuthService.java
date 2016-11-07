package org.nero.click.admin.service;


/**
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-7
 * Time   :  下午9:01
 */
public interface IAuthService {
    /**
     * token认证
     * @param id
     * @param token
     * @return
     */
    boolean auth(Long id, String token);
}

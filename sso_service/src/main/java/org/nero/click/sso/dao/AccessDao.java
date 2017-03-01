package org.nero.click.sso.dao;

import org.nero.click.sso.entity.Access;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2016/12/20
 * Time   下午3:33
 */
public interface AccessDao {

    /**
     * 查询认证令牌
     *
     * @param appKey 第三方密钥
     * @param appSecretKey 第三方私钥
     * @return 令牌
     */
    Access findByAccessRequest(String appKey,String appSecretKey);

}

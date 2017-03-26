package org.nero.click.sso.dao;

import org.apache.ibatis.annotations.Param;
import org.nero.click.sso.dto.AccessInfo;
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
    Access findByAccessRequest(@Param("appkey") String appKey,
                               @Param("appsecretkey") String appSecretKey);


    Long updateAccessToken(@Param("appkey") String appKey,
                           @Param("token") String token,
                           @Param("exper") Long exper);

    Access findByToken(@Param("token") String token);


    Access findByAccessToken(@Param("accessToken") String accessToken);

    Long updateToken(@Param("accesstoken") String accessToken,
                     @Param("token") String token);

    AccessInfo getAppByKey(@Param("appkey") String appKey,
                           @Param("appsecretkey") String appSecretKey);

    AccessInfo getAppByTicket(@Param("ticket") String ticket);
}

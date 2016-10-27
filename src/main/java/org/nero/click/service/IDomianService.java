package org.nero.click.service;

import org.nero.click.dto.Operate;
import org.nero.click.entity.Session;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-1
 * time: 下午2:15.
 */
public interface IDomianService {


    Operate<Session> sessionInject(String domain, String appkey);


}

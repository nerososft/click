package org.nero.click.service;


import org.nero.click.dto.Operate;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-1
 * time: 下午7:02.
 */
public interface IHttpService {

    Operate<String> get(String url);

}

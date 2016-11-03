package org.nero.click.data.service;


import org.nero.click.data.dto.Operate;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-1
 * time: 下午7:02.
 */
public interface IHttpService {

    Operate<String> get(String url);

}

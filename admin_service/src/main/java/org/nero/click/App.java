package org.nero.click;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new ClassPathXmlApplicationContext(new String[]{"dubbo/provider.xml","spring/spring-dao.xml","spring/spring-service.xml"});
        while (true) {
        }
    }
}

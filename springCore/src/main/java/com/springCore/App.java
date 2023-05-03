package com.springCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext ap = new ClassPathXmlApplicationContext("config.xml");
        User User1 =(User) ap.getBean("User1");
        System.out.println(User1);
    }
}

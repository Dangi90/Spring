package com.ch02;

import com.ch02.config.AppConfig;
import com.ch02.sub1.Greeting;
import com.ch02.sub1.Hello;
import com.ch02.sub1.Welcome;
import com.ch02.sub2.Computer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //스프링 컨테이너
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //빈 가져오기
        Hello hello = context.getBean(Hello.class);
        hello.show();

        Welcome welcome = (Welcome) context.getBean(Welcome.class);
        welcome.show();

        Greeting greeting = context.getBean(Greeting.class);
        greeting.show();

        // IOC/DI 실습
        Computer com = (Computer) context.getBean("com");
        com.show();
    }
}

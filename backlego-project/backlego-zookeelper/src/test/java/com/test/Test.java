package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
    
    /** 
    * <一句话功能简述>
    * <功能详细描述>
    * @param args
    * @see [类、类#方法、类#成员]
    */
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext beanFactory=new ClassPathXmlApplicationContext("classpath*:test-beans1.xml");
        System.out.println(beanFactory.getBean("rmiClient",HelloRMIService.class).add(1, 2));
        System.out.println(beanFactory.getBean("name1"));
        
    }
    
}

	
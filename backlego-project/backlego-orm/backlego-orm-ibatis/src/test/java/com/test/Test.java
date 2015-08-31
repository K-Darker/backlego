package com.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        //测试2个数据源加载
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println(beanFactory);
        System.out.println(beanFactory.getBean("sqlMapClient1"));
        System.out.println(beanFactory.getBean("sqlMapClient1"));
        System.out.println(beanFactory.getBean("sqlMapClient2"));
        
        TestDAO testDAO = (TestDAO)beanFactory.getBean("testDAO");
        System.out.println(((Ibatis)testDAO.getList().get(1)).getName());;
    }
    
}

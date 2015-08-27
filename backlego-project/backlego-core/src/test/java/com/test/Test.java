package com.test;

import java.io.IOException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class Test
{
    
    /** <一句话功能简述>* <功能详细描述>
    		* @param args
    		* @see
    		[类、类#方法、类#成员]
    		*/
    
    public static void main(String[] args)
    {
        // TODO Auto-generated
//                BeanFactory bean = new ClassPathXmlApplicationContext("");
        System.out.println(System.getProperty("java.class.path"));
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
       
        try
        {
            Resource[] resources = resolver.getResources("classpath*:META-INF/*.xml");
            //这样才能加载到
            BeanFactory beanFactory=new ClassPathXmlApplicationContext("classpath*:META-INF/spring*.xml");
//            XmlBeanFactory beanFactory1=new XmlBeanFactory(null);
            System.out.println(resources[0].getURL());
            SpringBeanTest springBeanTest = (SpringBeanTest)beanFactory.getBean("springBeanTest");
            System.out.println(springBeanTest);
        }
        catch (IOException e)
        {
            // TODO Auto-generated
            		e.printStackTrace();
            	
        }
    }
    
}

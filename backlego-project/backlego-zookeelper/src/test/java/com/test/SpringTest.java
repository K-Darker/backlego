/*
* 文 件 名: SpringTest.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-10-31
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ClassUtils;

import com.backlego.zk.service.definition.ServiceContext;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-10-31]
*/
public class SpringTest
{
    
    /** 
    * <一句话功能简述>
    * <功能详细描述>
    * @param args
    * @see [类、类#方法、类#成员]
    */
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext beanFactory=new ClassPathXmlApplicationContext("classpath*:test-beans.xml");
        System.out.println(beanFactory.getBean("dsf.service.name"));
    }
    
}

	
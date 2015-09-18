/*
* 文 件 名: SpringInitializer.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-2
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.spring.init;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-2]
*/
public class SpringInitializer
{
    private static final Map<ClassLoader, ApplicationContext> currentContextPerThread =
        new ConcurrentHashMap<ClassLoader, ApplicationContext>(1);
    
    public void run()
    {
        //系统参数初始化
        System.out.println("SpringInit:" + SpringInitializer.class);
        long startTime = System.currentTimeMillis();
        // 加载log4j
        //initLog4j();
        System.out.println("==========================satrt init busniess context==================");
        try
        {
            // java加载所有的配置文件
            //String [] locations = StandardLaunch.initConfigureList.toArray((new String[StandardLaunch.initConfigureList.size()]));
            ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:conf/*beans.xml");
            ClassLoader ccl = Thread.currentThread().getContextClassLoader();
            if (ccl != null)
            {
                currentContextPerThread.put(ccl, ctx);
            }
            
        }
        catch (BeansException e)
        {
            // TODO: handle exception
        }
        
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("============================end cost " + elapsedTime + "ms ====");
        
    }
}

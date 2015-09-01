/*
* 文 件 名: StandardLaunch.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-8-31
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.launch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.backlego.launch.init.model.LaunchInitializtion;
import com.backlego.launch.init.model.LaunchInitializtions;

/**
* 这是启动一个java工程
*
* @author Administrator
* @version [版本号, 2015-8-31]
*/
public class StandardLaunch
{
    public static String configLocation = "classpath*:META-INF/spring.xml";
    
    public static String log4jLocation = "conf/log4j.properties";
    
    /** 
    * 启动java工程的主函数
    * @param args
    * @see [类、类#方法、类#成员]
    */
    public static void main(String[] args)
    {
        try
        {
            JAXBContext ctx = JAXBContext.newInstance(LaunchInitializtions.class);
            Unmarshaller um = ctx.createUnmarshaller();
            try
            {
                LaunchInitializtions launchInitializtions =
                    (LaunchInitializtions)um.unmarshal(new FileReader(
                        new File(
                            "D:\\eclipse\\Eclipse Classic v4.2.2\\workspaces\\backlego\\backlego-project\\backlego-core\\src\\main\\resources\\spring.xml")));
                System.out.println(launchInitializtions);
            }
            catch (FileNotFoundException e)
            {
                // TODO Auto-generated
                e.printStackTrace();
                
            }
            
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        try
        {
            Enumeration<URL> resourceUrls = ClassLoader.getSystemResources("META-INF/spring.xml");
            while (resourceUrls.hasMoreElements())
            {
                Set result = new LinkedHashSet(16);
                URL url = resourceUrls.nextElement();
                System.out.println(url);
                result.add(url);
            }
            
        }
        catch (IOException e)
        {
            // TODO Auto-generated
            e.printStackTrace();
            
        }
        // 设置启动配置文件
        System.setProperty("configLocation", configLocation);
        System.setProperty("log4jLocation", log4jLocation);
        //初始话spring
        SpringInit.init();
        //启动线程
        Thread thread = new Thread(new SpringInit());
        thread.start();
    }
    
}

class SpringInit implements Runnable
{
    private static final Map<ClassLoader, ApplicationContext> currentContextPerThread =
        new ConcurrentHashMap<ClassLoader, ApplicationContext>(1);
    
    public SpringInit()
    {
        
    }
    
    public static void init()
    {
        //系统参数初始化
        
        System.out.println("SpringInit:" + SpringInit.class);
        long startTime = System.currentTimeMillis();
        // 加载log4j
        //initLog4j();
        System.out.println("==========================satrt init busniess context==================");
        try
        {
            // java加载所有的配置文件
            //setConfigLocations(configLocations);
            ApplicationContext ctx = new ClassPathXmlApplicationContext(System.getProperty("configLocation"));
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
    
    //    public static void initLog4j()
    //    {
    //        String log4jLocation =  System.getProperty("log4jLocation");
    //        System.out.println("log4j configfile path=" + log4jLocation);
    //        PropertyConfigurator.configureAndWatch(log4jLocation, 1000);// 间隔特定时间，检测文件是否修改，自动重新读取配置  
    //    }
    
    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(50000);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated
                e.printStackTrace();
                
            }
        }
    }
    
}

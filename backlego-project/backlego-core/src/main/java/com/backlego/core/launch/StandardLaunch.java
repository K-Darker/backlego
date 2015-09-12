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
package com.backlego.core.launch;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.backlego.core.launch.init.model.LaunchInitializtion;
import com.backlego.core.launch.init.model.LaunchInitializtions;

/**
* 这是启动一个java工程
*
* @author Administrator
* @version [版本号, 2015-8-31]
*/
@SuppressWarnings("restriction")
public class StandardLaunch
{
    public static String configLocation = "classpath*:META-INF/spring.xml";
    
    public static String log4jLocation = "conf/log4j.properties";
    
    public static List<String> initConfigureList = null;
    
    /** 
    * 启动java工程的主函数
    * @param args
    * @see [类、类#方法、类#成员]
    */
    public static void main(String[] args)
    {
        // 设置启动配置文件
        System.setProperty("log4jLocation", log4jLocation);
        try
        {
            // 使用xml to java的方法然后用java反射机制初始话spring 不仅可以初始化core 还可以初始化其他工程下的
            JAXBContext ctx = JAXBContext.newInstance(LaunchInitializtions.class);
            Unmarshaller um = ctx.createUnmarshaller();
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources(configLocation);
            List<LaunchInitializtion> initMethodList = new ArrayList<LaunchInitializtion>();
            initConfigureList = new ArrayList<String>();
            for (Resource resource : resources)
            {
                LaunchInitializtions launchInitializtions =
                    (LaunchInitializtions)um.unmarshal(new InputStreamReader(resource.getInputStream()));
                List<LaunchInitializtion> temp = launchInitializtions.getListLaunchInitializtion();
                for (LaunchInitializtion launchInitializtion : temp)
                {
                    // 取出classname 和方法去invoke
                    String className = launchInitializtion.getInitializeClassName();
                    String configureLocations = launchInitializtion.getConfigureLocations();
                    if (StringUtils.isNotEmpty(className))
                    {
                        initMethodList.add(launchInitializtion);
                    }
                    if (StringUtils.isNotEmpty(configureLocations))
                    {
                        //直接组装数组
                        initConfigureList.add(resource.getFile().getAbsolutePath().replace("META-INF\\spring.xml", "")
                            + configureLocations);
                    }
                }
            }
            //反射 launchInitializtionList
            for (LaunchInitializtion launchInitializtion : initMethodList)
            {
                // 取出classname 和方法去invoke
                String className = launchInitializtion.getInitializeClassName();
                String method = launchInitializtion.getInitializeMethod();
                if (StringUtils.isNotEmpty(className))
                {
                    Class<?> initClass = Class.forName(className);
                    Object instance = initClass.newInstance();
                    Method initMethod = initClass.getDeclaredMethod(method, null);
                    initMethod.invoke(instance, null);
                }
            }
            
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated
            e.printStackTrace();
            
        }
        catch (IOException e)
        {
            // TODO Auto-generated
            e.printStackTrace();
            
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            
        }
        catch (NoSuchMethodException e)
        {
            // TODO Auto-generated
            e.printStackTrace();
            
        }
        catch (SecurityException e)
        {
            // TODO Auto-generated
            e.printStackTrace();
            
        }
        catch (IllegalAccessException e)
        {
            // TODO Auto-generated
            e.printStackTrace();
            
        }
        catch (IllegalArgumentException e)
        {
            // TODO Auto-generated
            e.printStackTrace();
            
        }
        catch (InvocationTargetException e)
        {
            // TODO Auto-generated
            e.printStackTrace();
            
        }
        catch (InstantiationException e)
        {
            // TODO Auto-generated
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
            // make the application wait until we press a key.
            System.in.read();
        }
        catch (IOException e)
        {
            // TODO Auto-generated
            e.printStackTrace();
            
        }
        
    }
    
}
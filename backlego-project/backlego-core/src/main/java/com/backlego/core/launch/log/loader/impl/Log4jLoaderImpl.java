/*
* 文 件 名: Log4jLoaderImpl.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-12
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.log.loader.impl;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.backlego.core.launch.log.loader.Log4jLoader;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-12]
*/
public class Log4jLoaderImpl implements Log4jLoader
{
    private String configLocation = "conf/log4j.properties";
    
    private String isReload = "false";
    
    private int listenerInterval = 1000;
    
    public void setIsReload(String isReload)
    {
        this.isReload = isReload;
    }
    
    public void setListenerInterval(int listenerInterval)
    {
        this.listenerInterval = listenerInterval;
    }
    
    public void setConfigLocation(String configLocation)
    {
        this.configLocation = configLocation;
    }
    
    public void load(String configLocation)
    {
        //String path = Log4jConfig.class.getClass().getResource("/").getPath() + "log4j.properties";
        //String path="config/log4j.properties";   
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = resourcePatternResolver.getResource(configLocation);
        if ("true".equalsIgnoreCase(isReload))
        {
            try
            {
                PropertyConfigurator.configureAndWatch(resource.getFile().getAbsolutePath(), listenerInterval);
            }
            catch (IOException e)
            {
                // TODO Auto-generated
                		e.printStackTrace();
                	
            }
        }
        else
        {
            try
            {
                PropertyConfigurator.configure(resource.getFile().getAbsolutePath());
            }
            catch (IOException e)
            {
                // TODO Auto-generated
                		e.printStackTrace();
                	
            }
        }
    }
    
    public void load()
    {
        load(configLocation);
        
    }
    
}

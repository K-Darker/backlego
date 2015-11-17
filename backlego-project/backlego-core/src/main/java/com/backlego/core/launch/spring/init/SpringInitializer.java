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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.backlego.core.launch.xml.loader.exception.ConfigParseException;
import com.backlego.core.launch.xml.loader.impl.SpringXmlConfigLoaderImpl;
import com.backlego.core.launch.xml.loader.impl.XmlConfigLoaderImpl;
import com.backlego.core.launch.xml.loader.merger.SpringMerger;
import com.backlego.core.launch.xml.spring.model.ConfigLocation;
import com.backlego.core.launch.xml.spring.model.Spring;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-2]
*/
public class SpringInitializer
{
    private static Log logger = LogFactory.getLog(SpringInitializer.class);
    
    private static final String PROP_CONFIG_LOCATION = "com.backlego.spring.init.config-location";
    
    /** The Constant DEFAULT_CONFIG_LOCATION. */
    private static final String DEFAULT_CONFIG_LOCATION = "classpath*:META-INF/backlego-*/spring-beans.xml";
    
    private static final Map<ClassLoader, ApplicationContext> currentContextPerThread =
        new ConcurrentHashMap<ClassLoader, ApplicationContext>(1);
    
    public void run()
    {
        String configLocation = System.getProperty(PROP_CONFIG_LOCATION, DEFAULT_CONFIG_LOCATION);
        //系统参数初始化
        logger.info("SpringInit:" + SpringInitializer.class);
        long startTime = System.currentTimeMillis();
        // 加载log4j
        //initLog4j();
        System.out.println("==========================satrt init busniess context==================");
        try
        {
            // java加载所有的配置文件
            Spring spring = loadInitSpring(configLocation);
            SpringResourcesXmlApplicationContext ctx =
                new SpringResourcesXmlApplicationContext(getConfigResources(spring));
            ctx.start();
            ClassLoader ccl = Thread.currentThread().getContextClassLoader();
            if (ccl != null)
            {
                currentContextPerThread.put(ccl, ctx);
            }
            
        }
        catch (Exception e)
        {
            logger.error("init spring bean failed", e);
        }
        
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("============================end cost " + elapsedTime + "ms ==============");
    }
    
    public Spring loadInitSpring(String configLocation)
    {
        try
        {
            XmlConfigLoaderImpl<Spring> configLoader = new SpringXmlConfigLoaderImpl();
            configLoader.setContextPath(Spring.class.getPackage().getName());
            configLoader.setMerger(new SpringMerger());
            Spring spring = configLoader.loadAndMerge(configLocation);
            //取出local
            return spring;
        }
        catch (ConfigParseException e)
        {
            logger.error("load sping" + configLocation + "failed", e);
            return null;
            
        }
    }
    
    public Resource[] getConfigResources(Spring spring)
    {
        List<ConfigLocation> configLocations = spring.getConfigLocations().getConfigLocation();
        List<String> currentClasspath = spring.getConfigLocations().getCurrentClasspath();
        List<Resource> locations = new ArrayList<Resource>();
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        for (ConfigLocation configLocation : configLocations)
        {
            
            try
            {
                Resource[] resources = resourcePatternResolver.getResources("classpath*:" + configLocation.getValue());
                for (Resource resource : resources)
                {
                    for (String path : currentClasspath)
                    {
                        if (resource.getURL().getPath().startsWith(path))
                        {
                            locations.add(resource);
                        }
                    }
                }
                
            }
            catch (IOException e)
            {
                logger.error("get Config Resources" + configLocation + "failed", e);
            }
            
        }
        return locations.toArray(new Resource[locations.size()]);
    }
}

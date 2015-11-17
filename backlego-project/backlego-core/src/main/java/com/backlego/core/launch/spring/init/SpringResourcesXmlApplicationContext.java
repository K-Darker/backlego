/*
* 文 件 名: SpringResourcesXmlApplicationContext.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-11-17
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.spring.init;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
* 提供单独根据resources加载spring
* @author Administrator
* @version [版本号, 2015-11-17]
*/
public class SpringResourcesXmlApplicationContext extends ClassPathXmlApplicationContext
{
    private Resource[] configResources;
    
    private boolean refresh;
    
    public SpringResourcesXmlApplicationContext(Resource[] configResources)
        throws BeansException
    {
        
        this(true, null, configResources);
        
    }
    
    public SpringResourcesXmlApplicationContext(boolean refresh, ApplicationContext parent, Resource[] configResources)
        throws BeansException
    {
        super(parent);
        this.refresh = refresh;
        this.configResources = configResources;
    }
    
    public void start()
    {
        if (refresh)
        {
            refresh();
        }
    }
    
    @Override
    protected Resource[] getConfigResources()
    {
        return this.configResources;
    }
}

/*
* 文 件 名: PublishServiceBean.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-11-13
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.service.config.spring;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.AbstractApplicationContext;

import com.backlego.service.config.ServiceConfig;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-11-13]
*/
@SuppressWarnings("rawtypes")
public class PublishServiceBean<T> extends ServiceConfig<T> implements InitializingBean, DisposableBean,
    ApplicationContextAware, ApplicationListener, BeanNameAware
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = -6273322841278653406L;
    
    private static transient ApplicationContext SPRING_CONTEXT;
    
    private transient ApplicationContext applicationContext;
    
    private transient String beanName;
    
    private transient boolean supportedApplicationListener;
    
    public static ApplicationContext getSpringContext()
    {
        return SPRING_CONTEXT;
    }
    
    @Override
    public void setBeanName(String name)
    {
        this.beanName = name;
    }
    
    @Override
    public void onApplicationEvent(ApplicationEvent event)
    {
        
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
        throws BeansException
    {
        this.applicationContext = applicationContext;
        SpringExtensionFactory.addApplicationContext(applicationContext);
        if (applicationContext != null)
        {
            SPRING_CONTEXT = applicationContext;
            try
            {
                Method method =
                    applicationContext.getClass().getMethod("addApplicationListener",
                        new Class<?>[] {ApplicationListener.class}); // 兼容Spring2.0.1
                method.invoke(applicationContext, new Object[] {this});
                supportedApplicationListener = true;
            }
            catch (Throwable t)
            {
                if (applicationContext instanceof AbstractApplicationContext)
                {
                    try
                    {
                        Method method =
                            AbstractApplicationContext.class.getDeclaredMethod("addListener",
                                new Class<?>[] {ApplicationListener.class}); // 兼容Spring2.0.1
                        if (!method.isAccessible())
                        {
                            method.setAccessible(true);
                        }
                        method.invoke(applicationContext, new Object[] {this});
                        supportedApplicationListener = true;
                    }
                    catch (Throwable t2)
                    {
                    }
                }
            }
        }
        
    }
    
    @Override
    public void destroy()
        throws Exception
    {
        // TODO Auto-generated
        
    }
    
    @Override
    public void afterPropertiesSet()
        throws Exception
    {
        //获取所需要处理的标签配置
        //导出服务
    }
    
}

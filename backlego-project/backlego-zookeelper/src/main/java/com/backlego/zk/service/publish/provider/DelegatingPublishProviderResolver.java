/*
* 文 件 名: DelegatingPublishProviderResolver.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-11-1
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.zk.service.publish.provider;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.ClassUtils;

import com.backlego.zk.service.config.ServiceExporterDefinitionParser;
import com.backlego.zk.service.definition.PublishServiceDefinition;
import com.backlego.zk.service.definition.ServiceContext;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-11-1]
*/
public class DelegatingPublishProviderResolver implements FactoryBean<Object>, BeanFactoryAware
{
    private String publishId;
    
    private BeanFactory beanFactory;
    
    private Object publishObject;
    
    public void setBeanFactory(BeanFactory factory)
        throws BeansException
    {
        this.beanFactory = factory;
    }
    
    /**
    * @param  publishId进行赋值
    */
    public void setPublishId(String publishId)
    {
        this.publishId = publishId;
    }

    @Override
    public Object getObject()
        throws Exception
    {
        ServiceContext serviceContext = null;
        String serviceContextBeanName = ServiceExporterDefinitionParser.BEAN_CONFIGURER_BEAN_NAME;
        //从容器里面取
        if(beanFactory.getBean(serviceContextBeanName) instanceof ServiceContext)
        {
            serviceContext = (ServiceContext) beanFactory.getBean(serviceContextBeanName);
        }
        PublishServiceDefinition publishServiceDefinition = serviceContext.getPublishServiceDefinitionMap().get(publishId);
        publishObject = publishServiceDefinition.getRef();
        //校验要发布的对象实例是接口的实例么
        Class<?> interfaceClass = ClassUtils.getUserClass(publishServiceDefinition.getInterfaceName());

        return publishObject;
        
    }
    
    @Override
    public Class<?> getObjectType()
    {
        return ClassUtils.getUserClass(publishObject);
        
    }
    
    @Override
    public boolean isSingleton()
    {
        return true;
        
    }
    
    /** 
     * 根据beanName名字取得bean 
     *  
     * @param beanName 
     * @return 
     */
    @SuppressWarnings("unchecked")
    public <T> T getBean(String beanName)
    {
        if (null != beanFactory)
        {
            return (T)beanFactory.getBean(beanName);
        }
        return null;
    }
    
}

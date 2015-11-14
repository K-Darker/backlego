/*
* 文 件 名: ServiceNamespaceHandler.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-10-30
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.service.config.spring.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.backlego.service.config.spring.PublishServiceBean;
import com.backlego.service.config.spring.SubscribeServiceBean;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-10-30]
*/
public class ServiceNamespaceHandler extends NamespaceHandlerSupport
{
    
    @Override
    public void init()
    {
        registerBeanDefinitionParser("importer", new ServiceBeanDefinitionParser(SubscribeServiceBean.class, true));
        registerBeanDefinitionParser("exporter", new ServiceBeanDefinitionParser(PublishServiceBean.class, true));
    }
}

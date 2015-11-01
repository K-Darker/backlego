/*
* 文 件 名: ServiceEmportDefinitionParser.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-10-31
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.zk.service.config;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import com.backlego.zk.service.publish.provider.DelegatingPublishProviderResolver;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-10-31]
*/
public class ServiceExportDefinitionParser extends AbstractSingleBeanDefinitionParser
{
    @Override
    protected Class<?> getBeanClass(Element element)
    {
        return DelegatingPublishProviderResolver.class;
    }
    
    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder)
    {
        System.out.println(element);
    }
}

	
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

import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import com.backlego.zk.service.definition.PublishServiceDefinition;
import com.backlego.zk.service.definition.ServiceContext;
import com.backlego.zk.service.publish.provider.DelegatingPublishProviderResolver;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-10-31]
*/
public class ServiceExporterDefinitionParser extends AbstractSingleBeanDefinitionParser
{
    public static final String BEAN_CONFIGURER_BEAN_NAME = "test";
    
    public static final String EXPORTER_BEAN_ID = "id";
    
    public static final String EXPORTER_BEAN_NAME = "name";
    
    public static final String EXPORTER_INTERFACE = "interface";
    
    public static final String EXPORTER_VERSION = "version";
    
    public static final String EXPORTER_REF = "ref";
    
    public static final String INTERFACE_NAME = "interfaceName";
    
    public static final String PUBLISH_SERVICE_MAP_NAME = "publishServiceDefinitionMap";
    
    @Override
    protected Class<?> getBeanClass(Element element)
    {
        return DelegatingPublishProviderResolver.class;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder)
    {
        System.out.println(element);
        //1.校验参数是否是必填的
        checkService(element);
        String name = element.getAttribute(EXPORTER_BEAN_NAME);
        String version = element.getAttribute(EXPORTER_VERSION);
        builder.addPropertyValue("publishId", name + " " + version);
        //2.从Context里面获得没有获得就创建 publishServiceDefinitionMap
        RootBeanDefinition serviceContextDefinition = null;
        if (!parserContext.getRegistry().containsBeanDefinition(BEAN_CONFIGURER_BEAN_NAME))
        {
            serviceContextDefinition = new RootBeanDefinition();
            serviceContextDefinition.setBeanClass(ServiceContext.class);
        }
        else
        {
            serviceContextDefinition =
                (RootBeanDefinition)parserContext.getRegistry().getBeanDefinition(BEAN_CONFIGURER_BEAN_NAME);
        }
        //取出map
        ManagedMap<Object, Object> map = null;
        if (!serviceContextDefinition.getPropertyValues().contains(PUBLISH_SERVICE_MAP_NAME))
        {
            //创建
            map = new ManagedMap<Object, Object>();
            parsePublishMapElement(element, parserContext, map);
            serviceContextDefinition.getPropertyValues().add(PUBLISH_SERVICE_MAP_NAME, map);
        }
        else
        {
            map =
                (ManagedMap<Object, Object>)serviceContextDefinition.getPropertyValues()
                    .getPropertyValue(PUBLISH_SERVICE_MAP_NAME)
                    .getValue();
            parsePublishMapElement(element, parserContext, map);
        }
        parserContext.registerBeanComponent(new BeanComponentDefinition(serviceContextDefinition,
            BEAN_CONFIGURER_BEAN_NAME));
    }
    
    public void parsePublishMapElement(Element element, ParserContext parserContext, ManagedMap<Object, Object> map)
    {
        String name = element.getAttribute(EXPORTER_BEAN_NAME);
        String ref = element.getAttribute(EXPORTER_REF);
        String version = element.getAttribute(EXPORTER_VERSION);
        String interfaceName = element.getAttribute(EXPORTER_INTERFACE);
        map.setMergeEnabled(true);
        //放入key和value
        TypedStringValue typedValue = new TypedStringValue(name + " " + version, String.class);
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        element.setAttribute(EXPORTER_BEAN_ID, name);
        genericBeanDefinition.setBeanClass(PublishServiceDefinition.class);
        genericBeanDefinition.getPropertyValues().add(EXPORTER_BEAN_NAME, name);
        genericBeanDefinition.getPropertyValues().add(EXPORTER_VERSION, version);
        genericBeanDefinition.getPropertyValues().add(INTERFACE_NAME, interfaceName);
        RuntimeBeanReference reference = new RuntimeBeanReference(ref);
        reference.setSource(parserContext.extractSource(element));
        genericBeanDefinition.getPropertyValues().add(EXPORTER_REF, reference);
        map.put(typedValue, genericBeanDefinition);
    }
    
    public void checkService(Element element)
    {
        
        //        String id = element.getAttribute("id");
        //        String ref = element.getAttribute("ref");
        //        String version = element.getAttribute("version");
        //        String serviceName = element.getAttribute("serviceName");
        //        String interfaceName = element.getAttribute("interfaceName");
    }
}

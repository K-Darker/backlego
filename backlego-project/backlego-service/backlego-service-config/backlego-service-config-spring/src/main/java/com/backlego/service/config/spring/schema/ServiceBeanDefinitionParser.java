/*
* 文 件 名: ServiceBeanDefinitionParser.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-11-13
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.service.config.spring.schema;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.backlego.service.common.logger.Logger;
import com.backlego.service.common.logger.LoggerFactory;
import com.backlego.service.common.utils.ReflectUtils;
import com.backlego.service.config.spring.PublishServiceBean;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-11-13]
*/
public class ServiceBeanDefinitionParser implements BeanDefinitionParser
{
    private static final Logger logger = LoggerFactory.getLogger(ServiceBeanDefinitionParser.class);
    
    private final Class<?> beanClass;
    
    private final boolean required;
    
    public ServiceBeanDefinitionParser(Class<?> beanClass, boolean required)
    {
        this.beanClass = beanClass;
        this.required = required;
    }
    
    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext)
    {
        return parse(element, parserContext, beanClass, required);
        
    }
    
    private static BeanDefinition parse(Element element, ParserContext parserContext, Class<?> beanClass,
        boolean required)
    {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false);
        String id = element.getAttribute("id");
        //id一般是必须的
        String generatedBeanName = element.getAttribute("name");
        String version = element.getAttribute("verion");
        if ((id == null || id.length() == 0) && required)
        {
            //id没有id但是id是必须的所以对于服务发布方使用的是服务名称
            if (StringUtils.isEmpty(version))
            {
                version = "0.0.0";
            }
            while (parserContext.getRegistry().containsBeanDefinition(id))
            {
                //已经存在
                logger.warn("Duplicate spring bean id " + generatedBeanName);
                //生成
                id = generatedBeanName + version;
            }
            //将id注册进去
            parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);
            //id属性放进去
            beanDefinition.getPropertyValues().addPropertyValue("id", id);
        }
        //判断是服务发布的bean
        if (PublishServiceBean.class.equals(beanClass))
        {
            String className = element.getAttribute("interface");
            if (className != null && className.length() > 0)
            {
                RootBeanDefinition classDefinition = new RootBeanDefinition();
                classDefinition.setBeanClass(ReflectUtils.forName(className));
                classDefinition.setLazyInit(false);
                parseProperties(element.getChildNodes(), classDefinition);
                beanDefinition.getPropertyValues().addPropertyValue("ref",
                    new BeanDefinitionHolder(classDefinition, id + "Impl"));
            }
        }
        return beanDefinition;
    }
    
    private static void parseProperties(NodeList nodeList, RootBeanDefinition beanDefinition) {
        if (nodeList != null && nodeList.getLength() > 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    if ("property".equals(node.getNodeName())
                            || "property".equals(node.getLocalName())) {
                        String name = ((Element) node).getAttribute("name");
                        if (name != null && name.length() > 0) {
                            String value = ((Element) node).getAttribute("value");
                            String ref = ((Element) node).getAttribute("ref");
                            if (value != null && value.length() > 0) {
                                beanDefinition.getPropertyValues().addPropertyValue(name, value);
                            } else if (ref != null && ref.length() > 0) {
                                beanDefinition.getPropertyValues().addPropertyValue(name, new RuntimeBeanReference(ref));
                            } else {
                                throw new UnsupportedOperationException("Unsupported <property name=\"" + name + "\"> sub tag, Only supported <property name=\"" + name + "\" ref=\"...\" /> or <property name=\"" + name + "\" value=\"...\" />");
                            }
                        }
                    }
                }
            }
        }
    }
}

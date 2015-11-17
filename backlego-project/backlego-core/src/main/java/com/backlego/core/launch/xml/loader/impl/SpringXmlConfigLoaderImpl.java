/*
* 文 件 名: SpringXmlConfigLoaderImpl.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-11-17
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.loader.impl;

import java.io.IOException;

import javax.xml.bind.Unmarshaller;

import org.springframework.core.io.Resource;

import com.backlego.core.launch.xml.loader.exception.ConfigParseException;
import com.backlego.core.launch.xml.spring.model.Spring;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-11-17]
*/
public class SpringXmlConfigLoaderImpl extends XmlConfigLoaderImpl<Spring>
{
    @Override
    protected Spring load(Unmarshaller unmarshaller, Resource resource)
        throws ConfigParseException, IOException
    {
        Spring spring = super.load(unmarshaller, resource);
        spring.getConfigLocations().getCurrentClasspath().add( resource.getURL().getPath().split("META-INF")[0]);
        return spring;
        
    }
}

	
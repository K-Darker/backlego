/*
* 文 件 名: XmlConfigLoaderImpl.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-9
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.loader.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.backlego.core.launch.xml.loader.XmlConfigLoader;
import com.backlego.core.launch.xml.loader.exception.ConfigParseException;
import com.backlego.core.launch.xml.loader.merger.Merger;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-9]
*/
public class XmlConfigLoaderImpl<T> implements XmlConfigLoader<T>
{
    /** The xml input factory. */
    protected XMLInputFactory xmlInputFactory = createXmlInputFactory();
    
    /** The context path. */
    protected String contextPath;
    
    /** The merger. */
    protected Merger<T> merger;
    
    public XmlConfigLoaderImpl(String contextPath, Merger<T> merger)
    {
        this.contextPath = contextPath;
        this.merger = merger;
    }
    
    /**
     * The Constructor.
     */
    public XmlConfigLoaderImpl()
    {
    }
    
    public T loadAndMerge(String configLocation)
        throws ConfigParseException
    {
        List<T> list = load(configLocation);
        T result = null;
        for (T t : list)
        {
            if (null == result)
            {
                result = t;
            }
            else
            {
                result = merger.merge(result, t);
            }
        }
        return result;
    }
    
    public List<T> load(String configLocation)
        throws ConfigParseException
    {
        if (StringUtils.isEmpty(configLocation))
        {
            return Collections.emptyList();
        }
        
        configLocation = StringUtils.trim(configLocation);
        String[] locs = configLocation.split("\\s*(,|\r|\n)\\s*");
        
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        try
        {
            //需要xml ->java object的类
            JAXBContext context = JAXBContext.newInstance(contextPath);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return load(locs, resourcePatternResolver, unmarshaller);
        }
        catch (JAXBException e)
        {
            throw new ConfigParseException("Parsing config file error. config location: " + configLocation, e);
        }
    }
    
    public void setContextPath(String contextPath)
    {
        this.contextPath = contextPath;
    }
    
    public void setMerger(Merger<T> merger)
    {
        this.merger = merger;
    }
    
    protected XMLInputFactory createXmlInputFactory()
        throws FactoryConfigurationError
    {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        xmlInputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        return xmlInputFactory;
    }
    
    protected List<T> load(String[] locations, ResourcePatternResolver resourcePatternResolver,
        Unmarshaller unmarshaller)
        throws ConfigParseException
    {
        List<T> list = new ArrayList<T>();
        T object;
        for (String loc : locations)
        {
            try
            {
                Resource[] resources = resourcePatternResolver.getResources(loc);
                for (Resource resource : resources)
                {
                    object = load(unmarshaller, resource);
                    if (null != object)
                    {
                        list.add(object);
                    }
                }
            }
            catch (IOException e)
            {
                throw new ConfigParseException("Parsing config location error, config location: " + loc, e);
            }
        }
        return list;
    }
    
    @SuppressWarnings("unchecked")
    protected T load(Unmarshaller unmarshaller, Resource resource)
        throws ConfigParseException, IOException
    {
        InputStream input = null;
        try
        {
            input = resource.getInputStream();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(input);
            Object object = unmarshaller.unmarshal(xmlStreamReader);
            if (object instanceof JAXBElement<?>)
            {
                return (T)((JAXBElement<?>)object).getValue();
            }
            return (T)object;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new ConfigParseException("Parsing config file error, config file: " + resource.getURI(), e);
        }
        finally
        {
            IOUtils.closeQuietly(input);
        }
    }
}

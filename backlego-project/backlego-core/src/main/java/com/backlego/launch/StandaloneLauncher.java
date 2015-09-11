/*
* 文 件 名: StandaloneLauncher.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-8
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.launch;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import com.backlego.launch.xml.loader.XmlConfigLoader;
import com.backlego.launch.xml.loader.impl.XmlConfigLoaderImpl;
import com.backlego.launch.xml.loader.merger.LauncherMerger;
import com.backlego.launch.xml.loader.model.Initializer;
import com.backlego.launch.xml.loader.model.Initializers;
import com.backlego.launch.xml.loader.model.Launcher;
import com.backlego.launch.xml.loader.model.Parameter;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-8]
*/
public class StandaloneLauncher
{
    /** The Constant PROP_CONFIG_LOCATION. */
    private static final String PROP_CONFIG_LOCATION = "com.backlego.launch.config-location";
    
    /** The Constant DEFAULT_CONFIG_LOCATION. */
    private static final String DEFAULT_CONFIG_LOCATION = "classpath*:META-INF/backlego-*/launcher.xml";
    
    public static void main(String[] args)
    {
        launch();
    }
    
    /**
     * Launch.
     *
     * @return true, if launch
     */
    public static boolean launch()
    {
        String configLocation = System.getProperty(PROP_CONFIG_LOCATION, DEFAULT_CONFIG_LOCATION);
        XmlConfigLoader<Launcher> configLoader = buildXmlConfigLoader();
        try
        {
            Launcher launcher = configLoader.loadAndMerge(configLocation);
            initialize(launcher);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            return false;
        }
    }
    
    private static void initialize(Launcher launcher)
        throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException,
        InstantiationException
    {
        if (null == launcher)
        {
            return;
        }
        Initializers initializers = launcher.getInitializers();
        if (null == initializers)
        {
            return;
        }
        List<Initializer> list = initializers.getInitializer();
        if (CollectionUtils.isEmpty(list))
        {
            return;
        }
        for (Initializer initializer : list)
        {
            initialize(initializer);
        }
    }
    
    private static void initialize(Initializer initializer)
        throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException,
        InstantiationException
    {
        if (null == initializer.getClassName() || null == initializer.getMethodName())
        {
            return;
        }
        
        Map<String, String> parameters = getParameters(initializer);
        Class<?> type = ClassUtils.getClass(initializer.getClassName().trim(), false);
        String methodName = initializer.getMethodName().trim();
        if (initializer.isStatic())
        {
            if (parameters.isEmpty())
            {
                MethodUtils.invokeStaticMethod(type, methodName);
            }
            else
            {
                MethodUtils.invokeStaticMethod(type, methodName, parameters);
            }
        }
        else
        {
            Object instance = ConstructorUtils.invokeConstructor(type);
            if (parameters.isEmpty())
            {
                MethodUtils.invokeMethod(instance, methodName);
            }
            else
            {
                MethodUtils.invokeMethod(instance, methodName, parameters);
            }
        }
    }
    
    private static Map<String, String> getParameters(Initializer initializer)
    {
        if (null == initializer.getParameters())
        {
            return Collections.emptyMap();
        }
        
        List<Parameter> parameters = initializer.getParameters().getParameter();
        if (CollectionUtils.isEmpty(parameters))
        {
            return Collections.emptyMap();
        }
        
        Map<String, String> map = new HashMap<String, String>();
        for (Parameter parameter : parameters)
        {
            if (StringUtils.isNotEmpty(parameter.getName()) && StringUtils.isNotEmpty(parameter.getValue()))
            {
                map.put(parameter.getName().trim(), parameter.getValue().trim());
            }
        }
        return map;
    }
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    private static XmlConfigLoader<Launcher> buildXmlConfigLoader()
    {
        XmlConfigLoaderImpl<Launcher> configLoader = new XmlConfigLoaderImpl<Launcher>();
        configLoader.setContextPath(Launcher.class.getPackage().getName());
        configLoader.setMerger(new LauncherMerger());
        return configLoader;
    }
    
}

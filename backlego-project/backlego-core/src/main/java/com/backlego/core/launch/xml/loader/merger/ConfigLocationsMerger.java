/*
* 文 件 名: ConfigLocationsMerger.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-20
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.loader.merger;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

import com.backlego.core.launch.xml.spring.model.ConfigLocation;
import com.backlego.core.launch.xml.spring.model.ConfigLocations;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-20]
*/
public class ConfigLocationsMerger extends AbstractMerger<ConfigLocations> implements Comparator<ConfigLocation>,
    Serializable
{
    
    /** 注释内容. */
    private static final long serialVersionUID = 1L;
    
    /** {@inheritDoc} */
    
    @Override
    public ConfigLocations merge(ConfigLocations object1, ConfigLocations object2)
    {
        if (null == object1)
        {
            return object2;
        }
        
        if (null == object2)
        {
            return object1;
        }
        
        ConfigLocations configLocations = new ConfigLocations();
        configLocations.getCurrentClasspath().addAll(object1.getCurrentClasspath());
        configLocations.getCurrentClasspath().addAll(object2.getCurrentClasspath());
        configLocations.getConfigLocation().addAll(object1.getConfigLocation());
        configLocations.getConfigLocation().addAll(object2.getConfigLocation());
        Collections.sort(configLocations.getConfigLocation(), this);
        return configLocations;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public int compare(ConfigLocation o1, ConfigLocation o2)
    {
        return o1.getPriority() - o2.getPriority();
    }
    
}

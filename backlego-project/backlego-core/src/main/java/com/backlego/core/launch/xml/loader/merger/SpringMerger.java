/*
* 文 件 名: SpringMerger.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-20
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.loader.merger;

import com.backlego.core.launch.xml.spring.model.ConfigLocations;
import com.backlego.core.launch.xml.spring.model.Spring;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-20]
*/
public class SpringMerger extends AbstractMerger<Spring>
{
    
    /** The config locations merger. */
    private Merger<ConfigLocations> configLocationsMerger = new ConfigLocationsMerger();
    


    public Merger<ConfigLocations> getConfigLocationsMerger()
    {
        return configLocationsMerger;
    }
    
    /**
     * Sets the config locations merger.
     *
     * @param configLocationsMerger the config locations merger
     */
    public void setConfigLocationsMerger(Merger<ConfigLocations> configLocationsMerger)
    {
        this.configLocationsMerger = configLocationsMerger;
    }
    
    /** {@inheritDoc} */
     
    @Override
    public Spring merge(Spring object1, Spring object2)
    {
        if (null == object1)
        {
            return object2;
        }
        
        if (null == object2)
        {
            return object1;
        }
        
        Spring spring = new Spring();
        ConfigLocations configLocations =
            configLocationsMerger.merge(object1.getConfigLocations(), object2.getConfigLocations());
        spring.setConfigLocations(configLocations);
        return spring;
    }
    
}
	
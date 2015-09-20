/*
* 文 件 名: Spring.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-20
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.spring.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-20]
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "spring")
public class Spring
{
    @XmlElement(name = "configLocations")
    private ConfigLocations configLocations;
    
    /**
    * @return 返回  configLocations
    */
    public ConfigLocations getConfigLocations()
    {
        return configLocations;
    }
    
    /**
    * @param  configLocations进行赋值
    */
    public void setConfigLocations(ConfigLocations configLocations)
    {
        this.configLocations = configLocations;
    }
    
}

/*
* 文 件 名: ConfigLocations.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-20
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.spring.model;

import java.util.ArrayList;
import java.util.List;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-20]
*/
public class ConfigLocations
{
    private List<String> currentClasspath = new ArrayList<String>();
    
    private List<ConfigLocation> configLocation = new ArrayList<ConfigLocation>();
    
    /**
    * @return 返回  configLocation
    */
    public List<ConfigLocation> getConfigLocation()
    {
        return configLocation;
    }
    
    /**
    * @param  configLocation进行赋值
    */
    public void setConfigLocation(List<ConfigLocation> configLocation)
    {
        this.configLocation = configLocation;
    }
    
    /**
    * @return 返回  currentClasspath
    */
    public List<String> getCurrentClasspath()
    {
        return currentClasspath;
    }
    
    /**
    * @param  currentClasspath进行赋值
    */
    public void setCurrentClasspath(List<String> currentClasspath)
    {
        this.currentClasspath = currentClasspath;
    }
    
}

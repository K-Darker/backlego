/*
* 文 件 名: LaunchInitializtion.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-1
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.launch.init.model;


/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-1]
*/
public class LaunchInitializtion
{
    private String initializeClassName;
    
    private String initializeMethod;
    
    private String configureLocations;
    
    private String launchPriority;
    
    private String uri;
    
    public String getUri()
    {
        return uri;
    }
    
    public void setUri(String uri)
    {
        this.uri = uri;
    }
    
    public String getLaunchPriority()
    {
        return launchPriority;
    }
    
    public void setLaunchPriority(String launchPriority)
    {
        this.launchPriority = launchPriority;
    }
    
    public String getInitializeClassName()
    {
        return initializeClassName;
    }
    
    public void setInitializeClassName(String initializeClassName)
    {
        this.initializeClassName = initializeClassName;
    }
    
    public String getInitializeMethod()
    {
        return initializeMethod;
    }
    
    public void setInitializeMethod(String initializeMethod)
    {
        this.initializeMethod = initializeMethod;
    }
    
    public String getConfigureLocations()
    {
        return configureLocations;
    }
    
    public void setConfigureLocations(String configureLocations)
    {
        this.configureLocations = configureLocations;
    }
    
}

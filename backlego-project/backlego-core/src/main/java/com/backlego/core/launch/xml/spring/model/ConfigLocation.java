/*
* 文 件 名: ConfigLocation.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-20
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.spring.model;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-20]
*/
public class ConfigLocation
{
    private int priority;
    
    private String value;
    
    /**
    * @return 返回  priority
    */
    public int getPriority()
    {
        return priority;
    }
    
    /**
    * @param  priority进行赋值
    */
    public void setPriority(int priority)
    {
        this.priority = priority;
    }
    
    /**
    * @return 返回  value
    */
    public String getValue()
    {
        return value;
    }
    
    /**
    * @param  value进行赋值
    */
    public void setValue(String value)
    {
        this.value = value;
    }
    
}

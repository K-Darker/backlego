/*
* 文 件 名: LaunchInitializtions.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-1
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.launch.init.model;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-1]
*/
@XmlRootElement(name = "LaunchInitializtions")
@XmlAccessorType(XmlAccessType.FIELD)
public class LaunchInitializtions
{
    @XmlElement(name = "LaunchInitializtion")
    private List<LaunchInitializtion> listLaunchInitializtion;
    
    public List<LaunchInitializtion> getListLaunchInitializtion()
    {
        return listLaunchInitializtion;
    }
    
    public void setListLaunchInitializtion(List<LaunchInitializtion> listLaunchInitializtion)
    {
        this.listLaunchInitializtion = listLaunchInitializtion;
    }
    
}

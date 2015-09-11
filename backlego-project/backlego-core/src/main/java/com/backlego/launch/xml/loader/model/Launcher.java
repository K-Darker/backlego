/*
* 文 件 名: Launcher.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-8
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.launch.xml.loader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-8]
*/
@SuppressWarnings("restriction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "launcher")
public class Launcher
{
    @XmlElement(name = "initializers")
    private Initializers initializers;

    /**
    * @return 返回  initializers
    */
    public Initializers getInitializers()
    {
        return initializers;
    }

    /**
    * @param  initializers进行赋值
    */
    public void setInitializers(Initializers initializers)
    {
        this.initializers = initializers;
    }
    
    
}

	
/*
* 文 件 名: Initializers.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-8
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.loader.model;

import java.util.ArrayList;
import java.util.List;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-8]
*/
public class Initializers
{
    private List<Initializer> initializer =new ArrayList<Initializer>();
    
    /**
    * @return 返回  initializer
    */
    public List<Initializer> getInitializer()
    {
        return initializer;
    }
    
    /**
    * @param  initializer进行赋值
    */
    public void setInitializer(List<Initializer> initializer)
    {
        this.initializer = initializer;
    }
    
}

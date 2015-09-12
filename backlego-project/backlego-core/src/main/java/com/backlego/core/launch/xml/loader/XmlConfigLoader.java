/*
* 文 件 名: XmlConfigLoader.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-8
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.loader;

import com.backlego.core.launch.xml.loader.exception.ConfigParseException;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-8]
*/
public interface XmlConfigLoader<T>
{
    public T loadAndMerge(String configLocation)
        throws ConfigParseException;
}

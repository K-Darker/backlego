/*
* 文 件 名: ConfigParseException.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-11
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.loader.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-11]
*/
public class ConfigParseException extends Exception
{
    private static Log logger = LogFactory.getLog(ConfigParseException.class);
    
    /**
    * 注释内容
    */
    private static final long serialVersionUID = 1L;
    
    public ConfigParseException()
    {
    }
    
    public ConfigParseException(String errorDesc, Exception e)
    {
        logger.error(errorDesc, e);
    }
    
}

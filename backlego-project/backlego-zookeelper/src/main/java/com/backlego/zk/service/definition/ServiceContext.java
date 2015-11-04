/*
* 文 件 名: ServiceContext.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-11-2
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.zk.service.definition;

import java.util.Map;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-11-2]
*/
public class ServiceContext
{
    private Map<String,PublishServiceDefinition> publishServiceDefinitionMap;

    /**
    * @return 返回  publishServiceDefinitionMap
    */
    public Map<String, PublishServiceDefinition> getPublishServiceDefinitionMap()
    {
        return publishServiceDefinitionMap;
    }

    /**
    * @param  publishServiceDefinitionMap进行赋值
    */
    public void setPublishServiceDefinitionMap(Map<String, PublishServiceDefinition> publishServiceDefinitionMap)
    {
        this.publishServiceDefinitionMap = publishServiceDefinitionMap;
    }
    
    
}

	
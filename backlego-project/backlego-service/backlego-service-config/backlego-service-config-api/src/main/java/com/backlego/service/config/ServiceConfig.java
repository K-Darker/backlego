/*
* 文 件 名: ServiceConfig.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-11-13
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.service.config;

import java.util.HashMap;
import java.util.Map;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-11-13]
*/
public class ServiceConfig<T> extends AbstractServiceConfig
{
    private static final Map<String, Integer> RANDOM_PORT_MAP = new HashMap<String, Integer>();

    // 接口类型
    private String              interfaceName;

    private Class<?>            interfaceClass;

    // 接口实现类引用
    private T                   ref;

    // 服务名称
    private String              path;


    //private ProviderConfig provider;
    

    private transient volatile boolean exported;

    private transient volatile boolean unexported;
    
    private volatile String generic;
    
    
}

	
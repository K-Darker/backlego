/*
* 文 件 名: ZKServerDefinition.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-10-18
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.zk.config;

/**
* zk的地址集群 获得集群中各个zk的配置 基本配置和zk自己配置
*
* @author Administrator
* @version [版本号, 2015-10-18]
*/
public class ZKServerDefinition
{
    private String serverIP;
    
    private String serverPort;
    
    private String serverStatus;
    
    private int sessionTimeout;
}

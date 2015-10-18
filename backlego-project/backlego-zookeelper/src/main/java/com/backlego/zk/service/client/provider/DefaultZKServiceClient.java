/*
* 文 件 名: DefaultZKServiceClient.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-10-18
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.zk.service.client.provider;

import java.io.IOException;
import java.util.Map;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.jboss.netty.util.internal.ConcurrentHashMap;

import com.backlego.zk.config.ZKServerDefinition;
import com.backlego.zk.service.client.ZKClient;
import com.test.Test;

/**
* 连接zk的默认实现
*
* @author Administrator
* @version [版本号, 2015-10-18]
*/
public class DefaultZKServiceClient implements ZKClient, Watcher
{
    protected ZooKeeper zooKeeper;
    
    @Override
    public void process(WatchedEvent paramWatchedEvent)
    {
        // TODO Auto-generated
        
    }
    
    @Override
    public void connectZK(String hosts, int sessionTimeout)
        throws IOException
    {
        zooKeeper = new ZooKeeper(hosts, sessionTimeout, this);
    }
    
    @Override
    public void updateServices()
    {
        // TODO Auto-generated
        
    }
    
}

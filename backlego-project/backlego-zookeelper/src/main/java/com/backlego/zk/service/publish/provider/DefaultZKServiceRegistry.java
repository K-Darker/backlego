/*
* 文 件 名: DefaultZKServiceRegistry.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-10-18
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.zk.service.publish.provider;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import com.backlego.zk.service.definition.PublishServiceDefinition;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-10-18]
*/
public class DefaultZKServiceRegistry implements  Watcher
{
    ZooKeeper zkCluster = null;
    public DefaultZKServiceRegistry()
    {
        try
        {
            zkCluster = new ZooKeeper("192.168.51.39:2828", 500, this);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            	
        }
    }
    public void publishServices(List<PublishServiceDefinition> publishServiceDefinitions)
    {
        for (PublishServiceDefinition publishServiceDefinition : publishServiceDefinitions)
        {
            publishService(publishServiceDefinition);
        }
        
    }
    
    public void publishService(PublishServiceDefinition publishServiceDefinition)
    {
        try
        {
            zkCluster.exists("/service", true);
        }
        catch (KeeperException e)
        {
            // TODO Auto-generated
            		e.printStackTrace();
            	
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated
            		e.printStackTrace();
            	
        }
    }

    @Override
    public void process(WatchedEvent event)
    {
        // TODO Auto-generated
        	
    }
}

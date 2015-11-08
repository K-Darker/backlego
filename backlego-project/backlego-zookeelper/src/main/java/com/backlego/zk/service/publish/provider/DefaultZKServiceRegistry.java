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
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import com.backlego.zk.service.definition.PublishServiceDefinition;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-10-18]
*/
public class DefaultZKServiceRegistry implements Watcher
{
    public static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    protected ZooKeeper zkCluster = null;
    
    public DefaultZKServiceRegistry()
    {
        try
        {
            zkCluster = new ZooKeeper("127.0.0.1:2181", 500, this);
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
    public static void main(String[] args)
    {
        new DefaultZKServiceRegistry().publishService(null);
    }
    public void publishService(PublishServiceDefinition publishServiceDefinition)
    {
        try
        {
            if(zkCluster.exists("/service", true) == null)
            {
               //no exist create node persistent
                zkCluster.create("/service", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            //create ephemeral node set init data into node
            zkCluster.create("/service/"+" default#serviceName#192.168.51.29:2009#0.0.0", "1231234\ntest\n".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            connectedSemaphore.await();
        }
        catch (KeeperException e)
        {
            e.printStackTrace();
            
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            
        }
    }
    
    @Override
    public void process(WatchedEvent event)
    {
        System.out.println(event);
        
    }
}

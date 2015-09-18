package com.test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class Test implements Watcher
{
    private static CountDownLatch cdl = new CountDownLatch(1);
    
    public static void main(String[] args)
    {
        try
        {
            ZooKeeper zk = new ZooKeeper("192.168.51.39:2181", 5000, new Test());
            System.out.println(zk.getState());
            System.out.println(zk.getSessionId());
            System.out.println(zk.getSessionPasswd());
            //zk.create(path, data, acl, createMode)
            try
            {
                List<String> lists = zk.getChildren("/tes", new Test());
                System.out.println(lists);
            }
            catch (KeeperException e1)
            {
                // TODO Auto-generated
                		e1.printStackTrace();
                	
            }
            catch (InterruptedException e1)
            {
                // TODO Auto-generated
                		e1.printStackTrace();
                	
            }
            try
            {
                cdl.await();
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated
                e.printStackTrace();
                
            }
        }
        catch (IOException e)
        {
            // TODO Auto-generated
            e.printStackTrace();
            
        }
    }
    
    public void process(WatchedEvent event)
    {
        System.out.println(event);
        cdl.countDown();
    }
}

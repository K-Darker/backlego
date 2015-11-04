/*
* 文 件 名: PublishServiceDelegate.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-11-2
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.zk.service.publish.provider;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.backlego.zk.service.config.ServiceExporterDefinitionParser;
import com.backlego.zk.service.definition.PublishServiceDefinition;
import com.backlego.zk.service.definition.ServiceContext;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-11-2]
*/
public class PublishServiceDelegate implements ApplicationListener<ContextRefreshedEvent>
{
    ServiceContext serviceContext;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        // TODO Auto-generated
        ApplicationContext applicationContextevent = event.getApplicationContext();
        //1.获得ServiceContext
        String serviceContextBeanName = ServiceExporterDefinitionParser.BEAN_CONFIGURER_BEAN_NAME;
        //从容器里面取
        if(applicationContextevent.getBean(serviceContextBeanName) instanceof ServiceContext)
        {
            serviceContext = (ServiceContext) applicationContextevent.getBean(serviceContextBeanName);
        }
        //2.获得导出服务列表
        Map<String,PublishServiceDefinition> publishServiceDefinitionMap = serviceContext.getPublishServiceDefinitionMap();
        
        //3.向zk发布服务(解析zk配置文件)
        //4.启动监听端口
    }
    
}

	
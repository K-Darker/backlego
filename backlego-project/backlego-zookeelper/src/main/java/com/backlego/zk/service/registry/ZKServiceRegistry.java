/*
* 文 件 名: ZKServiceRegistry.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-10-18
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.zk.service.registry;

import java.io.IOException;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-10-18]
*/
public interface ZKServiceRegistry
{
    public void connectZK() throws IOException;
    
    public void publishService();
    
    public void refresh(long refreshTime);
}

	
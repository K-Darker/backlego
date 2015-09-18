/*
* 文 件 名: LauncherMerger.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-9
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.loader.merger;

import com.backlego.core.launch.xml.loader.model.Initializers;
import com.backlego.core.launch.xml.loader.model.Launcher;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-9]
*/
public class LauncherMerger extends AbstractMerger<Launcher>
{
    
    /** The initializers merger. */
    private Merger<Initializers> initializersMerger = new InitializersMerger<Initializers>();
    
    /** {@inheritDoc} */
    
    public Launcher merge(Launcher object1, Launcher object2)
    {
        if (null == object1)
        {
            return object2;
        }
        
        if (null == object2)
        {
            return object1;
        }
        
        Launcher launcher = new Launcher();
        Initializers initializers = initializersMerger.merge(object1.getInitializers(), object2.getInitializers());
        launcher.setInitializers(initializers);
        return launcher;
    }
    
}

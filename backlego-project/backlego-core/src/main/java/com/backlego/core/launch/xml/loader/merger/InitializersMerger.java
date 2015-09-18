/*
* 文 件 名: InitializersMerger.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-14
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.loader.merger;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

import com.backlego.core.launch.xml.loader.model.Initializer;
import com.backlego.core.launch.xml.loader.model.Initializers;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-14]
*/
public class InitializersMerger<T> extends AbstractMerger<Initializers> implements Comparator<Initializer>, Serializable
{

    
    /** 注释内容. */
    private static final long serialVersionUID = 1L;
     
    public Initializers merge(Initializers object1, Initializers object2)
    {
        if (null == object1)
        {
            return object2;
        }
        
        if (null == object2)
        {
            return object1;
        }
        
        Initializers initializers = new Initializers();
        initializers.getInitializer().addAll(object1.getInitializer());
        initializers.getInitializer().addAll(object2.getInitializer());
        Collections.sort(initializers.getInitializer(), this);
        return initializers;
    }
    
    /** {@inheritDoc} */
     
    public int compare(Initializer o1, Initializer o2)
    {
        return o1.getPriority() - o2.getPriority();
    }
    
}

	
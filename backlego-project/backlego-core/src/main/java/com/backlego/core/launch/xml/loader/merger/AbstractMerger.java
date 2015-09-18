/*
* 文 件 名: AbstractMerger.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-14
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.loader.merger;

import java.util.List;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-14]
*/
public abstract class AbstractMerger<T> implements Merger<T>
{
    public T merge(List<T> objects)
    {
        T result = null;
        for (T object : objects)
        {
            if (null == result)
            {
                result = object;
            }
            else
            {
                result = merge(result, object);
            }
        }
        return result;
    }
}

	
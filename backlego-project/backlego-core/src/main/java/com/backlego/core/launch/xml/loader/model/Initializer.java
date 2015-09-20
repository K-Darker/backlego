/*
 文 件 名: Initializer.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-8
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.loader.model;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-8]
*/
public class Initializer
{
    private Parameters parameters;
    
    private String className;
    
    private String methodName;
    
    private boolean isStatic;
    
    private int priority;
    
    /**
    * @return 返回  parameters
    */
    public Parameters getParameters()
    {
        return parameters;
    }
    
    /**
    * @param  parameters进行赋值
    */
    public void setParameters(Parameters parameters)
    {
        this.parameters = parameters;
    }
    
    /**
    * @return 返回  className
    */
    public String getClassName()
    {
        return className;
    }
    
    /**
    * @param  className进行赋值
    */
    public void setClassName(String className)
    {
        this.className = className;
    }
    
    /**
    * @return 返回  methodName
    */
    public String getMethodName()
    {
        return methodName;
    }
    
    /**
    * @param  methodName进行赋值
    */
    public void setMethodName(String methodName)
    {
        this.methodName = methodName;
    }
    
    /**
    * @return 返回  isStatic
    */
    public boolean isStatic()
    {
        return isStatic;
    }
    
    /**
    * @param  isStatic进行赋值
    */
    public void setStatic(boolean isStatic)
    {
        this.isStatic = isStatic;
    }
    
    public int getPriority()
    {
        return priority;
    }
    
    public void setPriority(int priority)
    {
        this.priority = priority;
    }
    
}

/*
* 文 件 名: PublishServiceDefinition.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-11-2
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.zk.service.definition;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-11-2]
*/
public class PublishServiceDefinition
{
    
    private String name;
    
    private String serviceName;
    
    private String interfaceName;
    
    private String version;
    
    private Object ref;
    
    /**
    * @return 返回  ref
    */
    public Object getRef()
    {
        return ref;
    }
    
    /**
    * @param  ref进行赋值
    */
    public void setRef(Object ref)
    {
        this.ref = ref;
    }
    
    /**
    * @return 返回  name
    */
    public String getName()
    {
        return name;
    }
    
    /**
    * @param  name进行赋值
    */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
    * @return 返回  serviceName
    */
    public String getServiceName()
    {
        return serviceName;
    }
    
    /**
    * @param  serviceName进行赋值
    */
    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }
    
    /**
    * @return 返回  interfaceName
    */
    public String getInterfaceName()
    {
        return interfaceName;
    }
    
    /**
    * @param  interfaceName进行赋值
    */
    public void setInterfaceName(String interfaceName)
    {
        this.interfaceName = interfaceName;
    }
    
    /**
    * @return 返回  version
    */
    public String getVersion()
    {
        return version;
    }
    
    /**
    * @param  version进行赋值
    */
    public void setVersion(String version)
    {
        this.version = version;
    }
    
}

/*
* 文 件 名: AbstractServiceConfig.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-11-13
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.service.config;


/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-11-13]
*/
public class AbstractServiceConfig extends AbstractMethodConfig
{
    private static final long serialVersionUID = 1L;
    
    // 服务版本
    protected String version;
    
    // 服务分组
    protected String group;
    
    // 服务是否已经deprecated
    protected Boolean deprecated;
    
    // 延迟暴露
    protected Integer delay;
    
    // 是否暴露
    protected Boolean export;
    
    // 权重
    protected Integer weight;
    
    // 应用文档
    protected String document;
    
    // 在注册中心上注册成动态的还是静态的服务
    protected Boolean dynamic;
    
    // 是否使用令牌
    protected String token;
    
    // 访问日志
    protected String accesslog;
    
    // 允许执行请求数
    private Integer executes;
    
    // 是否注册
    private Boolean register;
    
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
    
    /**
    * @return 返回  group
    */
    public String getGroup()
    {
        return group;
    }
    
    /**
    * @param  group进行赋值
    */
    public void setGroup(String group)
    {
        this.group = group;
    }
    
    /**
    * @return 返回  deprecated
    */
    public Boolean getDeprecated()
    {
        return deprecated;
    }
    
    /**
    * @param  deprecated进行赋值
    */
    public void setDeprecated(Boolean deprecated)
    {
        this.deprecated = deprecated;
    }
    
    /**
    * @return 返回  delay
    */
    public Integer getDelay()
    {
        return delay;
    }
    
    /**
    * @param  delay进行赋值
    */
    public void setDelay(Integer delay)
    {
        this.delay = delay;
    }
    
    /**
    * @return 返回  export
    */
    public Boolean getExport()
    {
        return export;
    }
    
    /**
    * @param  export进行赋值
    */
    public void setExport(Boolean export)
    {
        this.export = export;
    }
    
    /**
    * @return 返回  weight
    */
    public Integer getWeight()
    {
        return weight;
    }
    
    /**
    * @param  weight进行赋值
    */
    public void setWeight(Integer weight)
    {
        this.weight = weight;
    }
    
    /**
    * @return 返回  document
    */
    public String getDocument()
    {
        return document;
    }
    
    /**
    * @param  document进行赋值
    */
    public void setDocument(String document)
    {
        this.document = document;
    }
    
    /**
    * @return 返回  dynamic
    */
    public Boolean getDynamic()
    {
        return dynamic;
    }
    
    /**
    * @param  dynamic进行赋值
    */
    public void setDynamic(Boolean dynamic)
    {
        this.dynamic = dynamic;
    }
    
    /**
    * @return 返回  token
    */
    public String getToken()
    {
        return token;
    }
    
    /**
    * @param  token进行赋值
    */
    public void setToken(String token)
    {
        this.token = token;
    }
    
    /**
    * @return 返回  accesslog
    */
    public String getAccesslog()
    {
        return accesslog;
    }
    
    /**
    * @param  accesslog进行赋值
    */
    public void setAccesslog(String accesslog)
    {
        this.accesslog = accesslog;
    }
    
    /**
    * @return 返回  executes
    */
    public Integer getExecutes()
    {
        return executes;
    }
    
    /**
    * @param  executes进行赋值
    */
    public void setExecutes(Integer executes)
    {
        this.executes = executes;
    }
    
    /**
    * @return 返回  register
    */
    public Boolean getRegister()
    {
        return register;
    }
    
    /**
    * @param  register进行赋值
    */
    public void setRegister(Boolean register)
    {
        this.register = register;
    }
    
}

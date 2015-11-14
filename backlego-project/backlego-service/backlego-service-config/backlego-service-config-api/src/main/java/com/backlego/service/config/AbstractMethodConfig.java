/*
* 文 件 名: AbstractMethodConfig.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-11-13
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.service.config;

import java.util.Map;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-11-13]
*/
public class AbstractMethodConfig extends AbstractConfig
{
    private static final long serialVersionUID = 1L;
    
    // 远程调用超时时间(毫秒)
    protected Integer timeout;
    
    // 重试次数
    protected Integer retries;
    
    // 最大并发调用
    protected Integer actives;
    
    // 负载均衡
    protected String loadbalance;
    
    // 是否异步
    protected Boolean async;
    
    // 异步发送是否等待发送成功
    protected Boolean sent;
    
    // 服务接口的失败mock实现类名
    protected String mock;
    
    // 合并器
    protected String merger;
    
    // 服务接口的失败mock实现类名
    protected String cache;
    
    // 服务接口的失败mock实现类名
    protected String validation;
    
    // 自定义参数
    protected Map<String, String> parameters;
    
    public Integer getTimeout()
    {
        return timeout;
    }
    
    public void setTimeout(Integer timeout)
    {
        this.timeout = timeout;
    }
    
    public Integer getRetries()
    {
        return retries;
    }
    
    public void setRetries(Integer retries)
    {
        this.retries = retries;
    }
    
    public String getLoadbalance()
    {
        return loadbalance;
    }
    
    public void setLoadbalance(String loadbalance)
    {
        this.loadbalance = loadbalance;
    }
    
    public Boolean isAsync()
    {
        return async;
    }
    
    public void setAsync(Boolean async)
    {
        this.async = async;
    }
    
    public Integer getActives()
    {
        return actives;
    }
    
    public void setActives(Integer actives)
    {
        this.actives = actives;
    }
    
    public Boolean getSent()
    {
        return sent;
    }
    
    public void setSent(Boolean sent)
    {
        this.sent = sent;
    }
    
    public String getMock()
    {
        return mock;
    }
    
    public void setMock(String mock)
    {
        this.mock = mock;
    }
    
    public void setMock(Boolean mock)
    {
        if (mock == null)
        {
            setMock((String)null);
        }
        else
        {
            setMock(String.valueOf(mock));
        }
    }
    
    public String getMerger()
    {
        return merger;
    }
    
    public void setMerger(String merger)
    {
        this.merger = merger;
    }
    
    public String getCache()
    {
        return cache;
    }
    
    public void setCache(String cache)
    {
        this.cache = cache;
    }
    
    public String getValidation()
    {
        return validation;
    }
    
    public void setValidation(String validation)
    {
        this.validation = validation;
    }
    
    public Map<String, String> getParameters()
    {
        return parameters;
    }
    
    public void setParameters(Map<String, String> parameters)
    {
        this.parameters = parameters;
    }
    
}

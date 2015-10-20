/*
* 文 件 名: EncryptPropertyPlaceholderConfigurer.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-10-14
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.db.encryptproperty;

import java.io.IOException;
import java.security.Key;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;

import com.backlego.core.crypt.des.DESEncryptUtil;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-10-14]
*/
public class DecryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer
{
    private String PASSWORD = "password";
    
    private Resource keyLocation;
    
    private static Properties props;
    
    /**
    * @return 返回  props
    */
    public static Properties getProps()
    {
        return props;
    }
    
    /**
    * @param  keyLocation进行赋值
    */
    public void setKeyLocation(Resource keyLocation)
    {
        this.keyLocation = keyLocation;
    }
    
    @SuppressWarnings("static-access")
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
        throws BeansException
    {
        if(!props.isEmpty())
        {
            this.props = props;
        }
        super.processProperties(beanFactoryToProcess, props);
        
    }
    
    @Override
    protected String convertProperty(String propertyName, String propertyValue)
    {
//        if (propertyName.contains(PASSWORD))
//        {
//            String password = propertyValue;
//            //解密
//            if (keyLocation != null && StringUtils.isNotEmpty(password))
//            {
//                try
//                {
//                    Key secretKey = DESEncryptUtil.getKey(keyLocation.getInputStream());
//                    String context = DESEncryptUtil.decrypt(secretKey, password);
//                    propertyValue = context;
//                }
//                catch (IOException e)
//                {
//                    e.printStackTrace();
//                    
//                }
//            }
//            
//        }
        // TODO Auto-generated
        return super.convertProperty(propertyName, propertyValue);
        
    }
}

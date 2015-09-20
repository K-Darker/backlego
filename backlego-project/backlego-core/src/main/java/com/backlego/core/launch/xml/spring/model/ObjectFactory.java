/*
* 文 件 名: ObjectFactory.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-20
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.spring.model;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-9-20]
*/
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory
{
    
    private final static QName _Spring_QNAME = new QName("", "spring");
    
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory()
    {
    }
    
    /**
     * Create an instance of {@link Spring }
     * 
     */
    public Spring createSpring()
    {
        return new Spring();
    }
    
    /**
     * Create an instance of {@link ConfigLocation }
     * 
     */
    public ConfigLocation createConfigLocation()
    {
        return new ConfigLocation();
    }
    
    /**
     * Create an instance of {@link Spring.ConfigLocations }
     * 
     */
    public ConfigLocations createSpringConfigLocations()
    {
        return new ConfigLocations();
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Spring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "spring")
    public JAXBElement<Spring> createSpring(Spring value)
    {
        return new JAXBElement<Spring>(_Spring_QNAME, Spring.class, null, value);
    }
    
}

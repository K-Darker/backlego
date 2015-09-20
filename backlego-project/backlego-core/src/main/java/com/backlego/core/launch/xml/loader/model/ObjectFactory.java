/*
* 文 件 名: LauncherObjectFactory.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-9-11
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.backlego.core.launch.xml.loader.model;


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
public class ObjectFactory {

    private final static QName _Launcher_QNAME = new QName("", "launcher");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Initializer }
     * 
     */
    public Initializer createInitializer() {
        return new Initializer();
    }

    /**
     * Create an instance of {@link Launcher }
     * 
     */
    public Launcher createLauncher() {
        return new Launcher();
    }

    /**
     * Create an instance of {@link Parameter }
     * 
     */
    public Parameter createParameter() {
        return new Parameter();
    }

    /**
     * Create an instance of {@link Initializer.Parameters }
     * 
     */
    public Parameters createInitializerParameters() {
        return new Parameters();
    }

    /**
     * Create an instance of {@link Launcher.Initializers }
     * 
     */
    public Initializers createLauncherInitializers() {
        return new Initializers();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Launcher }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "launcher")
    public JAXBElement<Launcher> createLauncher(Launcher value) {
        return new JAXBElement<Launcher>(_Launcher_QNAME, Launcher.class, null, value);
    }

}

	
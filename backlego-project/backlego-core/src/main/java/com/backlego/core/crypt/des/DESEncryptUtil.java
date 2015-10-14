package com.backlego.core.crypt.des;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.backlego.core.crypt.common.CommonUtil;

public class DESEncryptUtil extends CommonUtil
{
    
    /** 
     * <ul> 
     * <li>Description:[根据流得到密钥]</li> 
     * <li>Created by [Huyvanpull] [Jul 19, 2010]</li> 
     * <li>Midified by [修改人] [修改时间]</li> 
     * </ul> 
     *  
     * @param is 
     * @return 
     */
    public static Key getKey(InputStream is)
    {
        try
        {
            ObjectInputStream ois = new ObjectInputStream(is);
            return (Key)ois.readObject();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
    /** 
     * 创建密匙 
     *  
     * @param algorithm 
     *            加密算法,可用 DES,DESede,Blowfish 
     * @return SecretKey 秘密（对称）密钥 
     */
    public static Key createSecretKey(String algorithm)
    {
        // 声明KeyGenerator对象  
        KeyGenerator keygen;
        // 声明 密钥对象  
        SecretKey deskey = null;
        try
        {
            // 返回生成指定算法的秘密密钥的 KeyGenerator 对象  
            keygen = KeyGenerator.getInstance(algorithm);
            // 生成一个密钥  
            deskey = keygen.generateKey();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        // 返回密匙  
        return deskey;
    }
    
    /** 
     * 根据密匙进行DES加密 
     *  
     * @param key 
     *            密匙 
     * @param info 
     *            要加密的信息 
     * @return String 加密后的信息 
     */
    public static String encrypt(Key key, String info)
    {
        // 定义 加密算法,可用 DES,DESede,Blowfish  
        String Algorithm = "DES";
        // 加密随机数生成器 (RNG),(可以不写)  
        SecureRandom sr = new SecureRandom();
        // 定义要生成的密文  
        byte[] cipherByte = null;
        try
        {
            // 得到加密/解密器  
            Cipher c1 = Cipher.getInstance(Algorithm);
            // 用指定的密钥和模式初始化Cipher对象  
            // 参数:(ENCRYPT_MODE, DECRYPT_MODE, WRAP_MODE,UNWRAP_MODE)  
            c1.init(Cipher.ENCRYPT_MODE, key, sr);
            // 对要加密的内容进行编码处理,  
            cipherByte = c1.doFinal(info.getBytes());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // 返回密文的十六进制形式  
        return byte2hex(cipherByte);
    }
    
    /** 
     * 根据密匙进行DES解密 
     *  
     * @param key 
     *            密匙 
     * @param sInfo 
     *            要解密的密文 
     * @return String 返回解密后信息 
     */
    public static String decrypt(Key key, String sInfo)
    {
        // 定义 加密算法,  
        String Algorithm = "DES";
        // 加密随机数生成器 (RNG)  
        SecureRandom sr = new SecureRandom();
        byte[] cipherByte = null;
        try
        {
            // 得到加密/解密器  
            Cipher c1 = Cipher.getInstance(Algorithm);
            // 用指定的密钥和模式初始化Cipher对象  
            c1.init(Cipher.DECRYPT_MODE, key, sr);
            // 对要解密的内容进行编码处理  
            cipherByte = c1.doFinal(hex2byte(sInfo));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // return byte2hex(cipherByte);  
        return new String(cipherByte);
    }
    
    /** 
    * <一句话功能简述>
    * <功能详细描述>
    * @param args
    * @see [类、类#方法、类#成员]
    */
    public static void main(String[] args)
        throws Exception
    {
        // 生成密钥文件  
        //        Key key = createSecretKey("DES");
        //        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\key.key"));
        //        oos.writeObject(key);
        //        oos.close();
        //key的地址
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource r = resourcePatternResolver.getResource("classpath:keyStore/db.key");
        SecretKey key1 = (SecretKey)getKey(r.getInputStream());
        
        String passwd = encrypt(key1, "");
        System.out.println(passwd);
        String context = decrypt(key1, passwd);
        System.out.println(context);
    }
    
}

package com.test;

public class TestJava
{
    
    /** 
    * <一句话功能简述>
    * <功能详细描述>
    * @param args
    * @see [类、类#方法、类#成员]
    */
    public static void main(String[] args)
    {
        
        int i = f();
        System.out.println(i);
        
    }
    
    public static int f()
    {
        int i= 0;
        try
        {
            ++i;
            i = i/0;
            return i;
        }
        catch(Exception e)
        {
            ++i;
            return i;
        }
        finally
        {
            ++i;
            return i;
        }
    }
}


package com.test;

import java.util.List;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-8-27]
*/
public interface IDao
{
    public void delete(String id);
    
    public Ibatis getById(String id);
    
    public Ibatis getByName(String name);
    
    public List<Ibatis> getList();
    
    public void save(Ibatis ibatis);
    
    public void update(Ibatis ibatis);
}

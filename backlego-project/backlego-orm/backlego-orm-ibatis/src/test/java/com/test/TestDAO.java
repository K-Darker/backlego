/*
* 文 件 名: TestDAO.java
* 版 权: xxx., Ltd. Copyright 2015-2015, All rights reserved
* 描 述: <描述>
* 修 改 人:Administrator
* 修改时间: 2015-8-27
* 跟踪单号: <跟踪单号>
* 修改单号: <修改单号>
* 修改内容:<修改内容>
*/
package com.test;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
* <一句话功能简述>
* <功能详细描述>
*
* @author Administrator
* @version [版本号, 2015-8-27]
*/
@SuppressWarnings("deprecation")
public class TestDAO extends SqlMapClientDaoSupport implements IDao
{
    public void delete(String id)
    {
        getSqlMapClientTemplate().delete("deleteUsers", id);
    }
    
    public Ibatis getById(String id)
    {
        return (Ibatis)getSqlMapClientTemplate().queryForObject("getUsersById", id);
    }
    
    public Ibatis getByName(String name)
    {
        
        return (Ibatis)getSqlMapClientTemplate().queryForObject("getUsersByName", name);
    }
    
    @SuppressWarnings("unchecked")
    public List<Ibatis> getList()
    {
        return (List<Ibatis>)getSqlMapClientTemplate().queryForList("User.getAllUsers", null);
    }
    
    public void save(Ibatis ibatis)
    {
        getSqlMapClientTemplate().insert("insertUsers", ibatis);
    }
    
    public void update(Ibatis ibatis)
    {
        getSqlMapClientTemplate().update("updateUsers", ibatis);
    }
}

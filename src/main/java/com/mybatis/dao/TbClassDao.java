package com.mybatis.dao;


import com.mybatis.entity.TbClass;

import java.util.List;

/**
 * Created by Sukiy on 2018/1/28.
 */
public interface TbClassDao {

    List<TbClass> findClsList();
}

package com.mybatis.dao.impl;

import com.mybatis.dao.TbClassDao;
import com.mybatis.entity.TbClass;
import com.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sukiy on 2018/1/28.
 */
@Repository("tbClassDao")
public class TbClassImpl implements TbClassDao{
    @Override
    public List<TbClass> findClsList() { //查询班级详情
        SqlSession session= MybatisUtil.getSqlSession();
        List list=session.getMapper(TbClassDao.class).findClsList();
        return list;
    }
}

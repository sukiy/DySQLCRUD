package com.mybatis.dao;

import com.mybatis.entity.TbStu;

import java.util.List;

/**
 * Created by Sukiy on 2018/1/26.
 */
public interface StuDao {

    boolean addStu(TbStu stu); //增加学生

    boolean deleteStu(TbStu stu); //删除学生

    boolean updateStu(TbStu stu); //修改学生

    TbStu findStuById(int id); //根据id查询学生

    List findStuList();// 查询学生信息


}

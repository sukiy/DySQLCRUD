package com.mybatis.dao.impl;

import com.mybatis.dao.StuDao;
import com.mybatis.entity.TbStu;
import com.mybatis.utils.Ergodic;
import com.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sukiy on 2018/1/26.
 */
@Repository("stuDao")
public class StuDaoImpl implements StuDao{

    /**
     * 添加学生
     * @param stu
     * @return
     */
    @Override
    public boolean addStu(TbStu stu) {//他是说什么已经关闭？你把session写在了外边，我们把他放里面试试，不行的话，那就，，，
        SqlSession session= MybatisUtil.getSqlSession();
        try {

            session.getMapper(StuDao.class).addStu(stu);
            session.commit();
            System.out.println("添加学生成功");
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    /**
     * 删除学生
     * @param stu
     * @return
     */
    @Override
    public boolean deleteStu(TbStu stu) {
        SqlSession session= MybatisUtil.getSqlSession();
        try {
            session.getMapper(StuDao.class).deleteStu(stu);
            session.commit();
            System.out.println("删除学生成功");
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }


    /**
     * 修改学生
     * @param stu
     * @return
     */
    @Override
    public boolean updateStu(TbStu stu) {
        SqlSession session= MybatisUtil.getSqlSession();
        try {
            session.getMapper(StuDao.class).updateStu(stu);
            session.commit();
            System.out.println("修改学生成功");
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    /**
     * 根据id查询学生
     * @param id
     * @return
     */
    @Override
    public TbStu findStuById(int id) {
        SqlSession session= MybatisUtil.getSqlSession();
        try {
            TbStu stu=session.getMapper(StuDao.class).findStuById(id);
            System.out.println(stu.getSno()+","+stu.getSname()+","+stu.getSex());
            return stu;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    /**
     * 查询学生详情
     * @return
     */
    @Override
    public List findStuList() {
        SqlSession session= MybatisUtil.getSqlSession();
        List list=session.getMapper(StuDao.class).findStuList();
        return list;
    }

}

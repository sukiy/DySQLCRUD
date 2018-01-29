package com.mybatis.service;

import com.mybatis.dao.StuDao;
import com.mybatis.entity.TbStu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sukiy on 2018/1/26.
 */
@Service("stuService")
public class StuService {

    @Resource(name = "stuDao")
    private StuDao stuDao;

    public boolean addStu(TbStu stu){
        return stuDao.addStu(stu);
    }

    public boolean deleteStu(TbStu stu){
        return stuDao.deleteStu(stu);
    }

    public boolean updateStu(TbStu stu){
        return stuDao.updateStu(stu);
    }

    public TbStu findStuById(int id){
        return stuDao.findStuById(id);
    }

    public List findStuList(){
        return stuDao.findStuList();
    }

    public StuDao getStuDao() {
        return stuDao;
    }

    public void setStuDao(StuDao stuDao) {
        this.stuDao = stuDao;
    }
}

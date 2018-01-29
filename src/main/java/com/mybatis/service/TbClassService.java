package com.mybatis.service;

import com.mybatis.dao.TbClassDao;
import com.mybatis.entity.TbClass;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sukiy on 2018/1/28.
 */
@Service("tbClassService")
public class TbClassService {

    @Resource(name = "tbClassDao")
    private TbClassDao tbClassDao;

    public List<TbClass> findClassList(){
        return tbClassDao.findClsList();
    }

    public TbClassDao getTbClassDao() {
        return tbClassDao;
    }

    public void setTbClassDao(TbClassDao tbClassDao) {
        this.tbClassDao = tbClassDao;
    }
}

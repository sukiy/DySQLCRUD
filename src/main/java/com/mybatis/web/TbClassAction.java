package com.mybatis.web;

import com.mybatis.service.TbClassService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sukiy on 2018/1/28.
 */
@Controller
@RequestMapping("/tbClassAction")
public class TbClassAction {

    @Resource
    private TbClassService tbClassService;

    @RequestMapping("/findClsList")
    @ResponseBody
    public List findClsList(){
        return tbClassService.findClassList();
    }

    public TbClassService getTbClassService() {
        return tbClassService;
    }

    public void setTbClassService(TbClassService tbClassService) {
        this.tbClassService = tbClassService;
    }
}

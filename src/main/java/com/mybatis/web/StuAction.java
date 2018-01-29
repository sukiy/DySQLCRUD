package com.mybatis.web;

import com.mybatis.entity.TbClass;
import com.mybatis.entity.TbStu;
import com.mybatis.service.StuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sukiy on 2018/1/26.
 */
@Controller
@RequestMapping("/stuAction")
public class StuAction {

    @Resource(name = "stuService")
    private StuService stuService;

    /**
     * 添加学生的方法
     * @param stu
     * @return
     */
    @RequestMapping("/addStu")
    @ResponseBody
    public int addStu(TbStu stu){
        if (stuService.addStu(stu)){
            return 1;
        }
            return 0;

    }


    /**
     * 查询学生的方法
     * @return
     */
    @RequestMapping("/findStuList")
    @ResponseBody
    public List findStuList(){
        return stuService.findStuList();
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(int sno, Model model){
        model.addAttribute("stu",stuService.findStuById(sno));
        return "forward:/updateStu.jsp";
    }

    /**
     * 修改学生的方法
     * @param stu
     * @return
     */
    @RequestMapping("/doUpdate")
    @ResponseBody
    public int doUpdate(TbStu stu){
         if (stuService.updateStu(stu)){
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 删除学生
     * @param stu
     * @return
     */
    @RequestMapping("/deleteStu")
    public String deleteStu(TbStu stu){
        if (stuService.deleteStu(stu)){
            return "forward:/stuList.jsp";

        }else {
            return "forward:/stuList.jsp";
        }
    }

    public StuService getStuService() {
        return stuService;
    }

    public void setStuService(StuService stuService) {
        this.stuService = stuService;
    }
}

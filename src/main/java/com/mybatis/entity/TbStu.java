package com.mybatis.entity;

import java.io.Serializable;

/**
 * Created by Sukiy on 2018/1/26.
 */
public class TbStu implements Serializable{

    private int sno;
    private String sname;
    private int sage;
    private String sex;

    //多个学生对应一个班级
    private TbClass cls;

    public TbStu() {
    }

    public TbStu(int sno, String sname, int sage, String sex) {
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
        this.sex = sex;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public TbClass getCls() {
        return cls;
    }

    public void setCls(TbClass cls) {
        this.cls = cls;
    }
}

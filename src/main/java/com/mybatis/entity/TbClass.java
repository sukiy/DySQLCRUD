package com.mybatis.entity;


import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sukiy on 2018/1/26.
 */

public class TbClass implements Serializable{

    private int cno;
    private String cname;

    public TbClass() {
    }

    public TbClass(int cno, String cname) {
        this.cno = cno;
        this.cname = cname;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

}

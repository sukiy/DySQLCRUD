package com.mybatis.utils;

import java.lang.reflect.Field;

/**
 * 提供遍历的方法
 * Created by Sukiy on 2018/1/25.
 */
public class Ergodic {

    public static void readAttributeValue(Object obj){
        String nameValues="";
        //得到Class
        Class cls=obj.getClass();
        //得到所有属性
        Field[] fields=cls.getDeclaredFields();
        for (int i=0;i<fields.length;i++){ //遍历
            try {
                //得到属性
                Field field=fields[i];
                //打开私有访问
                field.setAccessible(true);
                //获取属性
                String name=field.getName();
                //获取属性值
                Object value=field.get(obj);
                //一个个赋值
                nameValues += field.getName()+":"+value+",";
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        System.out.println(nameValues);
    }
}

package com.dumm.reflect;
/**
 * Created by dumm on 2019/2/22.
 */


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: giteeLearn
 * @Package: com.dumm.reflect
 * @ClassName: ReflectUser
 * @Description: java类作用描述
 * @Author: dumm
 * @Date： 2019/2/22
 */
public class ReflectUser {


    public static void main(String[] args) {
        List<userVo> users = new ArrayList<userVo>();
        users.add(new userVo("dumm", "19"));
        users.add(new userVo("bmm", ""));
        CheckNotEmpty(users);
    }

    public static void CheckNotEmpty(List<userVo> users) {
        users.stream().forEach(user -> {
            reflect(user);
        });

    }

    public static void reflect(Object obj) {
        if (obj == null) {
            return;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int j = 0; j < fields.length; j++) {
            fields[j].setAccessible(true);
            // 字段名
            String  fieldName = fields[j].getName();
            System.out.print(fields[j].getName() + ":");
            // 字段值
            try {
                System.out.print(fields[j].get(obj) + "     ");
                if(fields[j].get(obj)==null || fields[j].get(obj).toString().equals("")){
                    //异常处理 或则记录下来一起处理
                    String exc = fields[j].getAnnotation(TitleNotEmpty.class).message();
                    throw new Exception("exc"+exc);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}

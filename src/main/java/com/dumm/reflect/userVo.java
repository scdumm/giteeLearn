package com.dumm.reflect;
/**
 * Created by dumm on 2019/2/22.
 */


/**
 * @ProjectName: giteeLearn
 * @Package: com.dumm.reflect
 * @ClassName: userVo
 * @Description: java类作用描述
 * @Author: dumm
 * @Date： 2019/2/22
 */
public class userVo {
    @TitleNotEmpty(message="用户名")
    private String userName;
    @TitleNotEmpty(message="年龄不能为空")
    private String age;

    public userVo(String userName, String age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

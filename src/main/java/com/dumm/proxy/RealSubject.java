package com.dumm.proxy;
/**
 * Created by dumm on 2019/3/4.
 */

import com.dumm.proxy.ISubject;

/**
 * @ProjectName: giteeLearn
 * @Package: com.dumm.reflect
 * @ClassName: RealSubject
 * @Description: java类作用描述
 * @Author: dumm
 * @Date： 2019/3/4
 */
public class RealSubject implements ISubject {
    @Override
    public void doSomething() {
        System.out.println("RealSubject doSomething");

    }

}

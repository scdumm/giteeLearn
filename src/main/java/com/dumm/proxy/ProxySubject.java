package com.dumm.proxy;
/**
 * Created by dumm on 2019/3/4.
 */

import com.dumm.proxy.ISubject;

/**
 * @ProjectName: giteeLearn
 * @Package: com.dumm.reflect
 * @ClassName: ProxySubject
 * @Description: java类作用描述
 * @Author: dumm
 * @Date： 2019/3/4
 */
public class ProxySubject implements ISubject {

    private ISubject real;

    public ProxySubject(ISubject real) {
        this.real = real;
    }

    @Override
    public void doSomething() {
        doOtherthing();
        real.doSomething();

    }

    public void doOtherthing() {
        System.out.println("ProxySubject doOtherthing");
    }
}

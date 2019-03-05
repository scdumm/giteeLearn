package com.dumm.proxy;
/**
 * Created by dumm on 2019/3/4.
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: giteeLearn
 * @Package: com.dumm.proxy
 * @ClassName: Client
 * @Description: 静态代理
 * @Author: dumm
 * @Date： 2019/3/4
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        RealSubject real = new RealSubject();
        ProxySubject proxy = new ProxySubject(real);
        proxy.doSomething();
        //----------------------
        //接口代理类
        Class proxyClass = Proxy.getProxyClass(ISubject.class.getClassLoader(),new Class<?>[]{ISubject.class});
        Constructor<?> proxyClassConstructor  = proxyClass.getConstructor(new Class<?>[]{InvocationHandler.class});
        ISubject oo = (ISubject) proxyClassConstructor.newInstance(client.handler);
        oo.doSomething();

        //动态简写
        ISubject o = (ISubject)Proxy.newProxyInstance(ISubject.class.getClassLoader(), new Class<?>[] {ISubject.class}, client.handler);
        o.doSomething();
    }

    //(1)通过实现 InvocationHandler 接口创建自己的调用处理器
    //负责连接代理类和委托类的中间类必须实现的接口
    private InvocationHandler handler = new InvocationHandler() {
        //创建委托类对象实例
        private RealSubject real = new RealSubject();

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //调用委托类的方法
            return method.invoke(real, args);
        }
    };
}

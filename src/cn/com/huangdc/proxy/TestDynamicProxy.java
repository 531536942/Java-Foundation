package cn.com.huangdc.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class TestDynamicProxy {
    @Test
    public void test() {
        // 实际对象
        RealSubject realSubject = new RealSubject();
        MyInvocationHandler handler = new MyInvocationHandler();
        Object bind = handler.bind(realSubject);
        // 代理对象
        Subject subject = (Subject) bind;
        subject.action();// 转到MyInvocationHandler.invoke调用
        subject.action2();
    }
}

// 接口
interface Subject{
    void action();

    void action2();
}

// 实际对象
class RealSubject implements Subject {
    @Override
    public void action() {
        System.out.println("这是一个实际动作");
    }

    @Override
    public void action2() {
        System.out.println("这是一个实际动作2");
    }
}
// 动态代理handler
class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    /**
     * 传入实际对象，返回代理对象，可直接通过接口接收Subject
     */
    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    /**
     * 代理类调用方法时，实际调用的invoke方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("哈，我是代理类，由我来执行");
        Object invoke = method.invoke(obj, args);
        System.out.println("哈，代理结束了，返回值是 -- " + invoke);
        return invoke;
    }
}

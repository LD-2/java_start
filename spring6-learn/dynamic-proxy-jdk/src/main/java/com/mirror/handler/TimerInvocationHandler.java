package com.mirror.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


//InvocationHandler接口中有一个方法invoke，这个invoke方法上有三个参数：
//● 第一个参数：Object proxy。代理对象。设计这个参数只是为了后期的方便，如果想在invoke方法中使用代理对象的话，尽管通过这个参数来使用。
//● 第二个参数：Method method。目标方法。
//● 第三个参数：Object[] args。目标方法调用时要传的参数。
//我们将来肯定是要调用“目标方法”的，但要调用目标方法的话，需要“目标对象”的存在，“目标对象”从哪儿来呢？我们可以给TimerInvocationHandler提供一个构造方法，可以通过这个构造方法传过来“目标对象”

public class TimerInvocationHandler implements InvocationHandler {

    // 目标对象
    private Object target;

    // 通过构造方法来传目标对象

    public TimerInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 目标执行之前增强。
        long begin = System.currentTimeMillis();
        // 调用目标对象的目标方法
        Object retValue = method.invoke(target, args);
        // 目标执行之后增强。
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-begin));
        return retValue;
    }
}

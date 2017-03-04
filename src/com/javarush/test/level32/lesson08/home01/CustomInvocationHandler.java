package com.javarush.test.level32.lesson08.home01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler{

    private SomeInterfaceWithMethods methods;

    public CustomInvocationHandler(SomeInterfaceWithMethods methods) {
        this.methods = methods;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        System.out.println(method.getName() + " in");
        Object result = method.invoke(methods, objects);
        System.out.println(method.getName() + " out");
        return result;
    }
}

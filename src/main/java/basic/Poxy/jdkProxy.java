package basic.Poxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class jdkProxy implements InvocationHandler {

    private Service service;
    public jdkProxy(Service service){
        this.service = service;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("befor jdk invoke ");
        Object invoke = method.invoke(service, args);
        System.out.println("after jdk invoke");
        return invoke;
    }


}

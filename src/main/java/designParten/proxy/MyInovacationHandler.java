package designParten.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInovacationHandler implements InvocationHandler {

    private Object target;
    MyInovacationHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        method.invoke(target, args);

        System.out.println("after");
        return null;
    }

    public Object getTarget(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this::invoke);
    }

    public static void main(String[] args) {
        Service service = new ServiceImpl();
        MyInovacationHandler myInovacationHandler = new MyInovacationHandler(service);
        Service target = (Service) myInovacationHandler.getTarget();
        service.say();
        target.say();
    }
}

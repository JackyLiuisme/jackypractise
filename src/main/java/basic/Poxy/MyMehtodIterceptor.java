package basic.Poxy;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMehtodIterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before cglib interceptor");

        //Object o1 = method.invoke(o, objects);
        System.out.println("------");
        Object o2 = methodProxy.invokeSuper(o, objects);

        System.out.println("after cglib interceptor");
        return o2;
    }

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"/Users/jacky/IdeaProjects/jackypractise/src/main/resources");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Service.class);
        enhancer.setCallback(new MyMehtodIterceptor());
        Service proxy = (Service)enhancer.create();
        proxy.doservice("order" );
    }
}

package basic.Poxy;

import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
        proxy o = (proxy) Proxy.newProxyInstance(jdkProxy.class.getClassLoader(), Service.class.getInterfaces(), new
                jdkProxy(new Service()));
        o.doservice("proxy order" );
    }
}

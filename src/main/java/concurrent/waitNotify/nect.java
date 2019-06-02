package concurrent.waitNotify;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public  class nect{
    static class ConnectionHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("commit")){
                Thread.sleep(1000);
                System.out.println("is committing");
            }
            method.invoke(proxy,args);
            return null;
        }
    }
    public static MyMethod get(){
        return (MyMethod) Proxy.newProxyInstance(MyMehod.class.getClassLoader(),       //Thread.currentThread().getContextClassLoader()
                new Class[]{MyMethod.class}, new ConnectionHandler());
    }

    public static void main(String[] args) {
        MyMethod connection = nect.get();
            connection.input();


    }
}
package basic.classLoad;

import java.io.InputStream;

public class ClassLoadTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader myLoad = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);

                }catch (Exception e){
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object object = myLoad.loadClass("basic.classLoad.ClassLoadTest");
        System.out.println(object instanceof ClassLoadTest);
    }
}

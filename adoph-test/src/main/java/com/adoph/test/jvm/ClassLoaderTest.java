package com.adoph.test.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/8/29
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if (is == null) {
                    return super.loadClass(name);
                }
                try {
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return super.loadClass(name);
            }
        };

        Object o = myLoader.loadClass("com.adoph.test.jvm.ClassLoaderTest").newInstance();
        System.out.println(o.getClass());
        System.out.println(o instanceof ClassLoaderTest);
    }
}

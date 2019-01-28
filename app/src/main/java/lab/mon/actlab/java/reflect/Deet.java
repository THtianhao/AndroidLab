package lab.mon.actlab.java.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Locale;

import static java.lang.System.out;
import static java.lang.System.err;

public class Deet<T> {
    private boolean testDeet(Locale l) {
        // getISO3Language() may throw a MissingResourceException
        out.format("Locale = %s, ISO Language Code = %s%n", l.getDisplayName(), l.getISO3Language());
        return true;
    }

    private int testFoo(Locale l) {
        return 0;
    }

    private boolean testBar() {
        return true;
    }

    public void main(String... args) {
        if (args.length != 4) {
            err.format("Usage: java Deet <classname> <langauge> <country> <variant>%n");
            return;
        }

        try {
            //获取类的class
            Class<?> c = Class.forName(args[0]);
            //创建类的实例
            Object t = c.newInstance();
            //获取所有的方法
            Method[] allMethods = c.getDeclaredMethods();
            for (Method m : allMethods) {
                //获取方法名称
                String mname = m.getName();
                //如果不是以test开头或者返回类型不是boolean的话就跳出循环
                if (!mname.startsWith("test") || (m.getGenericReturnType() != boolean.class)) {
                    continue;
                }
                //获取所有的参数
                Type[] pType = m.getGenericParameterTypes();
                //如果方法参数不是1或者不允许访问的话跳出
                if ((pType.length != 1) || Locale.class.isAssignableFrom(pType[0].getClass())) {
                    continue;
                }

                out.format("invoking %s()%n", mname);
                try {
                    //获取访问权限
                    m.setAccessible(true);
                    //调用方法并得到返回值
                    Object o = m.invoke(t, new Locale(args[1], args[2], args[3]));
                    out.format("%s() returned %b%n", mname, (Boolean) o);

                } catch (InvocationTargetException x) {
                    Throwable cause = x.getCause();
                    err.format("invocation of %s failed: %s%n",
                            mname, cause.getMessage());
                }
            }

            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        } catch (InstantiationException x) {
            x.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        }
    }
}
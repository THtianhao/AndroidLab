package lab.mon.actlab.java.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import static java.lang.System.out;

public class MethodSpy {
    private static final String  fmt = "%24s: %s%n";

    // for the morbidly curious
    <E extends RuntimeException> void genericThrow() throws E {}

    public void main(String... args) {
        try {
            //获取Class实例
            Class<?> c = Class.forName(args[0]);
            //获取所有的方法
            Method[] allMethods = c.getDeclaredMethods();
            //遍历所有方法
            for (Method m : allMethods) {
                //如果方法名对应的话走下面的代码
                if (!m.getName().equals(args[1])) {
                    continue;
                }
                //输出方法名称

                out.format("%s%n", m.toGenericString());
                //输出返回类型
                out.format(fmt, "ReturnType", m.getReturnType());
                out.format(fmt, "GenericReturnType", m.getGenericReturnType());

                Class<?>[] pType  = m.getParameterTypes();
                Type[] gpType = m.getGenericParameterTypes();
                for (int i = 0; i < pType.length; i++) {
                    //输出参数类型
                    out.format(fmt,"ParameterType", pType[i]);
                    out.format(fmt,"GenericParameterType", gpType[i]);
                }

                Class<?>[] xType  = m.getExceptionTypes();
                Type[] gxType = m.getGenericExceptionTypes();
                for (int i = 0; i < xType.length; i++) {
                    //输出异常类型
                    out.format(fmt,"ExceptionType", xType[i]);
                    out.format(fmt,"GenericExceptionType", gxType[i]);
                }
            }

        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }
}
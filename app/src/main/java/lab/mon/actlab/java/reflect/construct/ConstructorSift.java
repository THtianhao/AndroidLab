package lab.mon.actlab.java.reflect.construct;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import static java.lang.System.out;

public class ConstructorSift {
    public void main(String... args) {
        try {
            Class<?> cArg = Class.forName(args[1]);

            Class<?> c = Class.forName(args[0]);
            //获取类的构造函数
            Constructor[] allConstructors = c.getDeclaredConstructors();
            //遍历构造函数
            for (Constructor ctor : allConstructors) {
                //获取构造函数的参数
                Class<?>[] pType = ctor.getParameterTypes();
                //构造函数的参数
                for (int i = 0; i < pType.length; i++) {
                    //如果构造函数的参数包含了传递过来的参数
                    if (pType[i].equals(cArg)) {
                        //输出构造函数
                        out.format("%s%n", ctor.toGenericString());
                        //获取构造函数的参数
                        Type[] gpType = ctor.getGenericParameterTypes();
                        //遍历参数
                        for (int j = 0; j < gpType.length; j++) {
                            char ch = (pType[j].equals(cArg) ? '*' : ' ');
                            //输出参数
                            out.format("%7c%s[%d]: %s%n", ch, "GenericParameterType", j, gpType[j]);
                        }
                        break;
                    }
                }
            }
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }
}
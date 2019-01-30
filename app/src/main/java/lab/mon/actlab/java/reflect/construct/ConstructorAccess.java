package lab.mon.actlab.java.reflect.construct;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import static java.lang.System.out;

public class ConstructorAccess {
    public void main(String... args) {
        try {
            //获取类
            Class<?> c = Class.forName(args[0]);
            //获取类的构造函数
            Constructor[] allConstructors = c.getDeclaredConstructors();
            //遍历构造函数
            for (Constructor ctor : allConstructors) {
                //获取输入的修饰符
                int searchMod = modifierFromString(args[1]);
                //获取修饰符修饰符模式
                int mods = accessModifiers(ctor.getModifiers());
                if (searchMod == mods) {
                    //输出
                    out.format("%s%n", ctor.toGenericString());
                    out.format("  [ synthetic=%-5b var_args=%-5b ]%n",
                            ctor.isSynthetic(), ctor.isVarArgs());
                }
            }

        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private static int accessModifiers(int m) {
        return m & (Modifier.PUBLIC | Modifier.PRIVATE | Modifier.PROTECTED);
    }

    private static int modifierFromString(String s) {
        if ("public".equals(s))               return Modifier.PUBLIC;
        else if ("protected".equals(s))       return Modifier.PROTECTED;
        else if ("private".equals(s))         return Modifier.PRIVATE;
        else if ("package-private".equals(s)) return 0;
        else return -1;
    }
}
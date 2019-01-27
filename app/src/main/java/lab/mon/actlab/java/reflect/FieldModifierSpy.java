package lab.mon.actlab.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import static java.lang.System.out;

enum Spy { BLACK , WHITE }

public class FieldModifierSpy {
    volatile int share;
    int instance;
    class Inner {}

    public void fieldModifierSpy(String... args) {
        try {
            //获取类中的Class
            Class<?> c = Class.forName(args[0]);
            int searchMods = 0x0;
            //解析传入的类型
            for (int i = 1; i < args.length; i++) {
                searchMods |= modifierFromString(args[i]);
            }
            //获取类的所有字段
            Field[] flds = c.getDeclaredFields();
            //打印出类名，和搜索模式
            out.format("Fields in Class '%s' containing modifiers:  %s%n", c.getName(), Modifier.toString(searchMods));
            boolean found = false;
            //遍历字段
            for (Field f : flds) {
                //获取字段的修饰符
                int foundMods = f.getModifiers();
                // Require all of the requested modifiers to be present
                if ((foundMods & searchMods) == searchMods) {
                    //查找并打印出相应的修饰符
                    out.format("%-8s [ synthetic=%-5b enum_constant=%-5b ]%n", f.getName(), f.isSynthetic(), f.isEnumConstant());
                    found = true;
                }
            }

            if (!found) {
                out.format("No matching fields%n");
            }
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private static int modifierFromString(String s) {
        int m = 0x0;
        if ("public".equals(s))           m |= Modifier.PUBLIC;
        else if ("protected".equals(s))   m |= Modifier.PROTECTED;
        else if ("private".equals(s))     m |= Modifier.PRIVATE;
        else if ("static".equals(s))      m |= Modifier.STATIC;
        else if ("final".equals(s))       m |= Modifier.FINAL;
        else if ("transient".equals(s))   m |= Modifier.TRANSIENT;
        else if ("volatile".equals(s))    m |= Modifier.VOLATILE;
        return m;
    }
}
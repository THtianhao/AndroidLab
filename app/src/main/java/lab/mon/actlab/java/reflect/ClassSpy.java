package lab.mon.actlab.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Member;
import static java.lang.System.out;

enum ClassMember { CONSTRUCTOR, FIELD, METHOD, CLASS, ALL }

public class ClassSpy {
    public void classSpy(String... args) {
        try {
            //获取类名
            Class<?> c = Class.forName(args[0]);
            out.format("Class:%n  %s%n%n", c.getCanonicalName());
            //获取包名
            Package p = c.getPackage();
            out.format("Package:%n  %s%n%n", (p != null ? p.getName() : "-- No Package --"));

            for (int i = 1; i < args.length; i++) {
                switch (ClassMember.valueOf(args[i])) {
                    case CONSTRUCTOR:
                        //获取构造函数
                        printMembers(c.getConstructors(), "Constructor");
                        break;
                    case FIELD:
                        //获取当前类的字段
                        printMembers(c.getDeclaredFields(), "Fields");
                        break;
                    case METHOD:
                        //获取当前类的方法
                        printMembers(c.getDeclaredMethods(), "Methods");
                        break;
                    case CLASS:
                        //获取当前类的类，接口，枚举
                        printClasses(c);
                        break;
                    case ALL:
                        printMembers(c.getConstructors(), "Constuctors");
                        printMembers(c.getDeclaredFields(), "Fields");
                        printMembers(c.getDeclaredMethods(), "Methods");
                        printClasses(c);
                        break;
                    default:
                        assert false;
                }
            }

        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    //打印成员变量
    private static void printMembers(Member[] mbrs, String s) {
        out.format("%s:%n", s);
        for (Member mbr : mbrs) {
            if (mbr instanceof Field)
                out.format("  %s%n", ((Field)mbr).toGenericString());
            else if (mbr instanceof Constructor)
                out.format("  %s%n", ((Constructor)mbr).toGenericString());
            else if (mbr instanceof Method)
                out.format("  %s%n", ((Method)mbr).toGenericString());
        }
        if (mbrs.length == 0)
            out.format("  -- No %s --%n", s);
        out.format("%n");
    }
    //打印类成员
    private static void printClasses(Class<?> c) {
        out.format("Classes:%n");
        Class<?>[] clss = c.getClasses();
        for (Class<?> cls : clss)
            out.format("  %s%n", cls.getCanonicalName());
        if (clss.length == 0)
            out.format("  -- No member interfaces, classes, or enums --%n");
        out.format("%n");
    }
}
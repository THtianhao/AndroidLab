package lab.mon.actlab.java.reflect;


import java.lang.reflect.*;
import java.util.function.*;
import static java.lang.System.out;

public class MethodParameterSpy {

    private static final String  fmt = "%24s: %s%n";

    <E extends RuntimeException> void genericThrow() throws E {}

    public static void printClassConstructors(Class c) {
        Constructor[] allConstructors = c.getConstructors();
        out.format(fmt, "Number of constructors", allConstructors.length);
        for (Constructor currentConstructor : allConstructors) {
            printConstructor(currentConstructor);
        }
        Constructor[] allDeclConst = c.getDeclaredConstructors();
        out.format(fmt, "Number of declared constructors",
                allDeclConst.length);
        for (Constructor currentDeclConst : allDeclConst) {
            printConstructor(currentDeclConst);
        }
    }


    public static void printConstructor(Constructor c) {
        out.format("%s%n", c.toGenericString());
        Parameter[] params = c.getParameters();
        out.format(fmt, "Number of parameters", params.length);
        for (int i = 0; i < params.length; i++) {
            printParameter(params[i]);
        }
    }

    public static void printClassMethods(Class c) {
        //获取类的所有方法
        Method[] allMethods = c.getDeclaredMethods();
        out.format(fmt, "Number of methods", allMethods.length);
        for (Method m : allMethods) {
            //答应类的方法
            printMethod(m);
        }
    }

    public static void printMethod(Method m) {
        //打印方法名称
        out.format("%s%n", m.toGenericString());
        //打印返回类型
        out.format(fmt, "Return type", m.getReturnType());
        //打印返回类型
        out.format(fmt, "Generic return type", m.getGenericReturnType());

        Parameter[] params = m.getParameters();
        for (int i = 0; i < params.length; i++) {
            //打印参数。
            printParameter(params[i]);
        }
    }

    public static void printParameter(Parameter p) {
        //获取参数类型。
        out.format(fmt, "Parameter class", p.getType());
        //获取参数名称
        out.format(fmt, "Parameter name", p.getName());
        //获取参数的修饰符
        out.format(fmt, "Modifiers", p.getModifiers());
        //是否是隐式参数
        out.format(fmt, "Is implicit?", p.isImplicit());
        //是否能拿到名字
        out.format(fmt, "Is name present?", p.isNamePresent());
        //是否是合成参数
        out.format(fmt, "Is synthetic?", p.isSynthetic());
    }

    public void main(String... args) {

        try {
            //打印构造函数信息
            printClassConstructors(Class.forName(args[0]));
            //打印类的方法
            printClassMethods(Class.forName(args[0]));
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }
}

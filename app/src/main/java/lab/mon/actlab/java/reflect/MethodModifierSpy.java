package lab.mon.actlab.java.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static java.lang.System.out;

public class MethodModifierSpy {

    private static int count;
    private static synchronized void inc() { count++; }
    private static synchronized int cnt() { return count; }

    public void main(String... args) {
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] allMethods = c.getDeclaredMethods();
            for (Method m : allMethods) {
                if (!m.getName().equals(args[1])) {
                    continue;
                }
                out.format("%s%n", m.toGenericString());
                out.format("  Modifiers:  %s%n", Modifier.toString(m.getModifiers()));
                out.format("  [ synthetic=%-5b var_args=%-5b bridge=%-5b ]%n", m.isSynthetic(), m.isVarArgs(), m.isBridge());
                inc();
            }
            out.format("%d matching overload%s found%n", cnt(), (cnt() == 1 ? "" : "s"));

        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }
}

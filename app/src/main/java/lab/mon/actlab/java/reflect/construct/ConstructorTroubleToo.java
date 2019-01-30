package lab.mon.actlab.java.reflect.construct;

import java.lang.reflect.InvocationTargetException;

import static java.lang.System.err;

public class ConstructorTroubleToo {
    public ConstructorTroubleToo() {
        throw new RuntimeException("exception in constructor");
    }

    public static void main(String... args) {
        try {
            Class<?> c = Class.forName(ConstructorTroubleToo.class.getName());
            // Method propagetes any exception thrown by the constructor
            // (including checked exceptions).
            if (args.length > 0 && args[0].equals("class")) {
                Object o = c.newInstance();
            } else {
                Object o = c.getConstructor().newInstance();
            }

            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        } catch (InstantiationException x) {
            x.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        } catch (NoSuchMethodException x) {
            x.printStackTrace();
        } catch (InvocationTargetException x) {
            x.printStackTrace();
            err.format("%n%nCaught exception: %s%n", x.getCause());
        }
    }
}
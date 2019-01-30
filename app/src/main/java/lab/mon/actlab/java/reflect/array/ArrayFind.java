package lab.mon.actlab.java.reflect.array;

import java.lang.reflect.Field;

import static java.lang.System.out;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import static java.lang.System.out;

public class ArrayFind {
    public static void main(String... args) {
        boolean found = false;
        try {
            Class<?> cls = Class.forName(args[0]);
            Field[] flds = cls.getDeclaredFields();
            for (Field f : flds) {
                Class<?> c = f.getType();
                if (c.isArray()) {
                    found = true;
                    out.format("%s%n"
                                    + "           Field: %s%n"
                                    + "            Type: %s%n"
                                    + "  Component Type: %s%n",
                            f, f.getName(), c, c.getComponentType());
                }
            }
            if (!found) {
                out.format("No array fields%n");
            }

            // production code should handle this exception more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }
}